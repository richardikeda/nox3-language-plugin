package com.enterscript.nox3languageplugin.language

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.util.ProcessingContext
import javax.swing.Icon
import com.enterscript.nox3languageplugin.language.psi.NOX3Types

/**
 * Provides basic code completion for the X3 language. Completions include
 * language keywords, built in functions and symbols defined in the current
 * project.
 */
class NOX3CompletionContributor : CompletionContributor() {
    init {
        // Top level keywords and glossary terms
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(NOX3Types.KEY)
                .withLanguage(NOX3Language.INSTANCE)
                .withSuperParent(2, PsiFile::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    val project = parameters.position.project

                    KEYWORDS.forEach { keyword ->
                        resultSet.addElement(LookupElementBuilder.create(keyword))
                    }
                    SYMBOLS.forEach { symbol ->
                        resultSet.addElement(LookupElementBuilder.create(symbol))
                    }

                    // glossary terms
                    X3RuleService.glossary()
                        .sortedWith(compareBy({ STATUS_ORDER[it.status] }, { it.token }))
                        .forEach { entry ->
                            var builder = LookupElementBuilder
                                .create(entry.token)
                                .withIcon(iconFor(entry.family))
                                .withTypeText(entry.family.name, true)
                            if (entry.helpMd) {
                                val docElement = NOX3KeywordDocElement(PsiManager.getInstance(project), entry.token)
                                builder = builder.withPsiElement(docElement)
                            }
                            resultSet.addElement(builder)
                        }
                }
            }
        )

        // Variables and properties from project stubs
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(NOX3Types.KEY)
                .withLanguage(NOX3Language.INSTANCE)
                .andNot(
                    PlatformPatterns.psiElement()
                        .withSuperParent(2, PsiFile::class.java)
                ),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    val project = parameters.position.project

                    NOX3Util.findVariables(project).mapNotNull { it.name }.forEach {
                        resultSet.addElement(LookupElementBuilder.create(it))
                    }
                    NOX3Util.findProperties(project).mapNotNull { it.key }.forEach {
                        resultSet.addElement(LookupElementBuilder.create(it))
                    }
                }
            }
        )
    }

    private companion object {
        private val STATUS_ORDER = mapOf(
            KeywordStatus.Public to 0,
            KeywordStatus.New to 1,
            KeywordStatus.Internal to 2,
            KeywordStatus.Deprecated to 3,
            KeywordStatus.DeprecatedClassic to 4,
            KeywordStatus.Unknown to 5
        )

        private val KEYWORDS = listOf("KEY")
        private val SYMBOLS = listOf("=", "(", ")", ",")

        private fun iconFor(family: KeywordFamily): Icon = when (family) {
            KeywordFamily.FUNCTION -> AllIcons.Nodes.Function
            KeywordFamily.INSTRUCTION -> AllIcons.Nodes.Method
            KeywordFamily.SYSVAR -> AllIcons.Nodes.Variable
            else -> AllIcons.Nodes.Property
        }
    }
}

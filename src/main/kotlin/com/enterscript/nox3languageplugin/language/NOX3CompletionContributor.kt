package com.enterscript.nox3languageplugin.language

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiManager
import com.intellij.util.ProcessingContext
import javax.swing.Icon

/**
 * Provides basic code completion for the X3 language. Completions include
 * language keywords, built in functions and symbols defined in the current
 * project.
 */
class NOX3CompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withLanguage(NOX3Language.INSTANCE),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    val project = parameters.position.project

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

                    // project symbols (property keys)
                    NOX3Util.findProperties(project).mapNotNull { it.key }.forEach {
                        resultSet.addElement(LookupElementBuilder.create(it))
                    }
                }
            }
        )
    }

    private companion object {
        private val STATUS_ORDER = mapOf(
            X3RuleService.KeywordStatus.Public to 0,
            X3RuleService.KeywordStatus.New to 1,
            X3RuleService.KeywordStatus.Internal to 2,
            X3RuleService.KeywordStatus.Deprecated to 3,
            X3RuleService.KeywordStatus.DeprecatedClassic to 4,
            X3RuleService.KeywordStatus.Unknown to 5
        )

        private fun iconFor(family: X3RuleService.KeywordFamily): Icon = when (family) {
            X3RuleService.KeywordFamily.FUNCTION -> AllIcons.Nodes.Function
            X3RuleService.KeywordFamily.INSTRUCTION -> AllIcons.Nodes.Method
            X3RuleService.KeywordFamily.SYSVAR -> AllIcons.Nodes.Variable
            else -> AllIcons.Nodes.Property
        }
    }
}

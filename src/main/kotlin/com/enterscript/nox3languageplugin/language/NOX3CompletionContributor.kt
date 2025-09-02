package com.enterscript.nox3languageplugin.language

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

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
                    // keywords
                    KEYWORDS.forEach { resultSet.addElement(LookupElementBuilder.create(it)) }

                    // built‑in functions
                    FUNCTIONS.forEach { resultSet.addElement(LookupElementBuilder.create("$it()")) }

                    // project symbols (property keys)
                    val project = parameters.position.project
                    NOX3Util.findProperties(project).mapNotNull { it.key }.forEach {
                        resultSet.addElement(LookupElementBuilder.create(it))
                    }
                }
            }
        )
    }

    private companion object {
        val KEYWORDS = listOf("if", "else", "while", "function")
        val FUNCTIONS = listOf("print", "len", "sqrt")
    }
}

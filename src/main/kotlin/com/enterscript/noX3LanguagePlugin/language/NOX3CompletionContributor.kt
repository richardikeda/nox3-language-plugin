package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext


class NOX3CompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(NOX3Types.VALUE),
            object : CompletionProvider<CompletionParameters>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create("Hello"))
                }
            }
        )
    }
}
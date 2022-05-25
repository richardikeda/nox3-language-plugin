package com.enterscript.noX3LanguagePlugin.language

import com.intellij.openapi.util.TextRange


import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext


class NOX3ReferenceContributor : PsiReferenceContributor() {
    companion object {
        fun registerReferenceProviders(psiReferenceRegistrar: PsiReferenceRegistrar) {
            psiReferenceRegistrar.registerReferenceProvider(
                PlatformPatterns.psiElement(
                    PsiLiteralExpression::class.java,
                ),
                object : PsiReferenceProvider() {
                    override fun getReferencesByElement(
                        psiElement: PsiElement,
                        processingContext: ProcessingContext
                    ): Array<PsiReference> {
                        val literalExpression = psiElement as PsiLiteralExpression
                        val value = if (literalExpression.value is String) literalExpression.value as String? else null
                        if (value != null && value.startsWith(NOX3Annotator.NOX3_PREFIX_STR + NOX3Annotator.NOX3_SEPARATOR_STR)) {
                            val property = TextRange(
                                NOX3Annotator.NOX3_PREFIX_STR.length + NOX3Annotator.NOX3_SEPARATOR_STR.length + 1,
                                value.length + 1
                            )
                            return arrayOf(NOX3Reference(psiElement, property))
                        }
                        return PsiReference.EMPTY_ARRAY
                    }
                }
            )


        }
    }

    override fun registerReferenceProviders(p0: PsiReferenceRegistrar) {
        return NOX3ReferenceContributor.registerReferenceProviders(p0)
    }

}

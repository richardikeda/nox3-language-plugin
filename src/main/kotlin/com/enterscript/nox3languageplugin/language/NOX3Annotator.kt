package com.enterscript.nox3languageplugin.language

import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.enterscript.nox3languageplugin.language.ReplaceKeywordQuickFix

/**
 * Provides simple annotation support for NOX3 string literals.
 */
class NOX3Annotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is LeafPsiElement) return

        val token = element.text.lowercase()
        val info = X3RuleService.keywordInfo(token) ?: return

        val (severity, message) = when (info.status) {
            KeywordStatus.Internal ->
                HighlightSeverity.WARNING to "$token is internal"
            KeywordStatus.Deprecated,
            KeywordStatus.DeprecatedClassic ->
                HighlightSeverity.WEAK_WARNING to "$token is deprecated"
            else -> return
        }

        val builder = holder.newAnnotation(severity, message).range(element)
        info.replacement?.let { replacement ->
            builder.withFix(ReplaceKeywordQuickFix(element, replacement))
        }
        builder.create()
    }

    companion object {
        // Prefix used to identify NOX3 function calls inside string literals
        const val NOX3_PREFIX_STR: String = "X3"
        const val NOX3_SEPARATOR_STR: String = ":"
    }
}

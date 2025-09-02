package com.enterscript.nox3languageplugin.language

import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression

/**
 * Provides simple annotation support for NOX3 string literals.
 */
class NOX3Annotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        // Placeholder annotator. Real highlighting will be implemented later.
        if (element !is PsiLiteralExpression) return
    }

    companion object {
        const val NOX3_PREFIX_STR: String = "nox"
        const val NOX3_SEPARATOR_STR: String = ":"
    }
}

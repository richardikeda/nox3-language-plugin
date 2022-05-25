package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.enterscript.noX3LanguagePlugin.language.syntax.NOX3SyntaxHighlighter

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression


class NOX3Annotator : Annotator {


    companion object {
        // Define strings for the X3 language prefix - used for annotations, line markers, etc.
        const val NOX3_PREFIX_STR = "X3"
        const val NOX3_SEPARATOR_STR = ":"
    }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        // Ensure the Psi Element is an expression
        if (element !is PsiLiteralExpression) {
            return
        }

        // Ensure the Psi element contains a string that starts with the prefix and separator
//        val literalExpression: PsiLiteralExpression = element as PsiLiteralExpression
//        val value = if (element.value is String) element.value else null
        val value = if (element.value is String) element.value as String? else null

        if (value == null || !value.startsWith(NOX3_PREFIX_STR + NOX3_SEPARATOR_STR)) {
            return
        }

        // Define the text ranges (start is inclusive, end is exclusive)
        // "NOX3:key"
        //  01234567890
        val prefixRange  = TextRange.from(element.textRange.startOffset, NOX3_PREFIX_STR.length + 1)
        val separatorRange = TextRange.from(prefixRange.endOffset, NOX3_SEPARATOR_STR.length)
        val keyRange = TextRange(separatorRange.endOffset, element.textRange.endOffset - 1)

        // highlight "simple" prefix and ":" separator
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create()
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(separatorRange).textAttributes(NOX3SyntaxHighlighter.SEPARATOR).create()


        // Get the list of properties for given key
        val key = value.substring(NOX3_PREFIX_STR.length + NOX3_SEPARATOR_STR.length)
        val properties: List<NOX3Property> = NOX3Util.findProperties(element.project, key)
        if (properties.isEmpty()) {
//            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
//                .range(keyRange)
//                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
//                .withFix(SimpleCreatePropertyQuickFix(key))
//                .create()
        } else {
            // Found at least one property, force the text attributes to Simple syntax value character
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(keyRange).textAttributes(NOX3SyntaxHighlighter.VALUE).create()
        }
    }

}
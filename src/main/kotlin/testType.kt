//import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
//import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
//
//object NOX3PsiImplUtil {
//    fun getKey(element: NOX3Property): String? {
//        val keyNode = element.node.findChildByType(NOX3Types.KEY)
//        return keyNode?.text?.replace("\\\\ ".toRegex(), " ")
//    }
//
//    fun getValue(element: NOX3Property): String? {
//        val valueNode = element.node.findChildByType(NOX3Types.VALUE)
//        return valueNode?.text
//    }
//}
////
//package org.intellij.sdk.language
//
//
//import com.enterscript.noX3LanguagePlugin.language.NOX3Annotator.Companion.NOX3_PREFIX_STR
//import com.enterscript.noX3LanguagePlugin.language.NOX3Annotator.Companion.NOX3_SEPARATOR_STR
//import com.intellij.openapi.util.TextRange
//import com.intellij.patterns.PlatformPatterns
//import com.intellij.psi.*
//import com.intellij.util.ProcessingContext
//
//import org.intellij.sdk.language.com.enterscript.noX3LanguagePlugin.language.NOX3Reference
//
//
//class NOX3ReferenceContributor : PsiReferenceContributor() {
//    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
//        registrar.registerReferenceProvider(
//            PlatformPatterns.psiElement(
//                PsiLiteralExpression::class.java
//            ),
//            object : PsiReferenceProvider() {
//                override fun getReferencesByElement(
//                    element: PsiElement,
//                    context: ProcessingContext
//                ): Array<PsiReference> {
//                    val literalExpression = element as PsiLiteralExpression
//                    val value = if (literalExpression.value is String) literalExpression.value as String? else null
//                    if (value != null && value.startsWith(NOX3_PREFIX_STR + NOX3_SEPARATOR_STR)) {
//                        val property = TextRange(
//                            NOX3_PREFIX_STR.length + NOX3_SEPARATOR_STR.length + 1,
//                            value.length + 1
//                        )
//                        return arrayOf(NOX3Reference(element, property))
//                    }
//                    return PsiReference.EMPTY_ARRAY
//                }
//            })
//    }
//}

//
//import com.enterscript.noX3LanguagePlugin.language.NOX3Util
//import com.enterscript.noX3LanguagePlugin.language.syntax.NOX3SyntaxHighlighter
//import com.intellij.codeInspection.ProblemHighlightType
//import com.intellij.lang.annotation.AnnotationHolder
//import com.intellij.lang.annotation.Annotator
//import com.intellij.lang.annotation.HighlightSeverity
//import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
//import com.intellij.openapi.util.TextRange
//import com.intellij.psi.PsiElement
//import com.intellij.psi.PsiLiteralExpression
//
//class NOX3Annotator : Annotator {
//    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
//        // Ensure the Psi Element is an expression
//        if (element !is PsiLiteralExpression) {
//            return
//        }
//
//        // Ensure the Psi element contains a string that starts with the prefix and separator
//        val value = if (element.value is String) element.value as String? else null
//        if (value == null || !value.startsWith(NOX3_PREFIX_STR + NOX3_SEPARATOR_STR)) {
//            return
//        }
//
//        // Define the text ranges (start is inclusive, end is exclusive)
//        // "X3:key"
//        //  01234567890
//        val prefixRange = TextRange.from(element.getTextRange().startOffset, NOX3_PREFIX_STR.length + 1)
//        val separatorRange = TextRange.from(prefixRange.endOffset, NOX3_SEPARATOR_STR.length)
//        val keyRange = TextRange(separatorRange.endOffset, element.getTextRange().endOffset - 1)
//
//        // highlight "NOX3" prefix and ":" separator
//        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//            .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create()
//        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//            .range(separatorRange).textAttributes(NOX3SyntaxHighlighter.SEPARATOR).create()
//
//
//        // Get the list of properties for given key
//        val key = value.substring(NOX3_PREFIX_STR.length + NOX3_SEPARATOR_STR.length)
//        val properties = NOX3Util.findProperties(element.getProject(), key)
//        if (properties.isEmpty()) {
//            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
//                .range(keyRange)
//                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL) // ** Tutorial step 18.3 - Add a quick fix for the string containing possible properties
//                .withFix(NOX3CreatePropertyQuickFix(key))
//                .create()
//        } else {
//            // Found at least one property, force the text attributes to NOX3 syntax value character
//            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//                .range(keyRange).textAttributes(NOX3SyntaxHighlighter.VALUE).create()
//        }
//    }
//
//    companion object {
//        // Define strings for the NOX3 language prefix - used for annotations, line markers, etc.
//        const val NOX3_PREFIX_STR = "NOX3"
//        const val NOX3_SEPARATOR_STR = ":"
//    }
//}
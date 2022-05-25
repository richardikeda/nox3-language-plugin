package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.icons.NOX3Icons
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*


class NOX3Reference(element: PsiElement, textRange: TextRange) : PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {
    private val key: String

    init {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun multiResolve(p0: Boolean): Array<ResolveResult> {
        val project = myElement!!.project
        val properties: List<NOX3Property> = NOX3Util.findProperties(project, key)
        val results: MutableList<ResolveResult> = ArrayList()
        for (property in properties) {
            results.add(PsiElementResolveResult(property))
        }
        return results.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val project = myElement!!.project
        val properties: List<NOX3Property> = NOX3Util.findProperties(project)
        val variants: MutableList<LookupElement> = ArrayList()
        for (property in properties) {
            if (property.key != null && property.key!!.isNotEmpty()) {
                variants.add(
                    LookupElementBuilder
                        .create(property).withIcon(NOX3Icons.Icon.FileType)
                        .withTypeText(property.containingFile.name)
                )
            }
        }
        return variants.toTypedArray()
    }

}

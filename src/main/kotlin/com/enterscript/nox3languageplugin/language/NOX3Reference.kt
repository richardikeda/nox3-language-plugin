package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.icons.NOX3Icons
import com.enterscript.nox3languageplugin.language.psi.NOX3Property
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class NOX3Reference(element: PsiElement, textRange: TextRange) : PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {
    private val key: String = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun resolve(): PsiElement? {
        val results = multiResolve(false)
        return if (results.size == 1) results[0].element else null
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement.project
        val properties: List<NOX3Property> = NOX3Util.findProperties(project, key)
        return properties.map { PsiElementResolveResult(it) }.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val project = myElement.project
        val properties: List<NOX3Property> = NOX3Util.findProperties(project)
        val variants = mutableListOf<LookupElement>()
        for (property in properties) {
            val name = property.key
            if (!name.isNullOrEmpty()) {
                variants.add(
                    LookupElementBuilder.create(property).withIcon(NOX3Icons.Icon.FileType)
                        .withTypeText(property.containingFile.name)
                )
            }
        }
        return variants.toTypedArray()
    }
}

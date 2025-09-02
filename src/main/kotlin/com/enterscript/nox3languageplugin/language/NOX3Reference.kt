package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.icons.NOX3Icons
import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
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
        val variables: List<NOX3Variable> = NOX3Util.findVariables(project, key)
        return variables.map { PsiElementResolveResult(it) }.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val project = myElement.project
        val variables: List<NOX3Variable> = NOX3Util.findVariables(project)
        val variants = mutableListOf<LookupElement>()
        for (variable in variables) {
            val name = variable.name
            if (!name.isNullOrEmpty()) {
                variants.add(
                    LookupElementBuilder.create(variable).withIcon(NOX3Icons.Icon.FileType)
                        .withTypeText(variable.containingFile.name)
                )
            }
        }
        return variants.toTypedArray()
    }
}

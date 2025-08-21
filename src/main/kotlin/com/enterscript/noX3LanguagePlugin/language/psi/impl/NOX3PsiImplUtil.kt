package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.enterscript.noX3LanguagePlugin.language.psi.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class NOX3PsiImplUtil {
    companion object {
        @JvmStatic
        fun getName(element: NOX3NamedElement): String? {
            val idNode = (element as PsiElement).node.findChildByType(NOX3Types.IDENTIFIER)
            return idNode?.text
        }

        @JvmStatic
        fun setName(element: NOX3NamedElement, newName: String): PsiElement {
            val psi = element as PsiElement
            val idNode: ASTNode? = psi.node.findChildByType(NOX3Types.IDENTIFIER)
            if (idNode != null) {
                val newElement = when (element) {
                    is NOX3Module -> NOX3ElementFactory.createModule(psi.project, newName)
                    is NOX3Function -> NOX3ElementFactory.createFunction(psi.project, newName)
                    is NOX3Variable -> NOX3ElementFactory.createVariable(psi.project, newName)
                    else -> null
                }
                val newId = (newElement as? PsiElement)?.node?.findChildByType(NOX3Types.IDENTIFIER)
                if (newId != null) {
                    psi.node.replaceChild(idNode, newId)
                }
            }
            return psi
        }

        @JvmStatic
        fun getNameIdentifier(element: NOX3NamedElement): PsiElement? {
            return (element as PsiElement).node.findChildByType(NOX3Types.IDENTIFIER)?.psi
        }
    }
}

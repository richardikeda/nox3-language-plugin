package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement




class NOX3PsiImplUtil{
    companion object {

        @JvmStatic
        fun getKey(element: NOX3Property): String? {
            val keyNode = element.node.findChildByType(NOX3Types.KEY)
            return keyNode?.text?.replace("\\\\ ".toRegex(), " ")
        }

        @JvmStatic
        fun getValue(element: NOX3Property): String? {
            val valueNode = element.node.findChildByType(NOX3Types.VALUE)
            return valueNode?.text
        }
        @JvmStatic
        fun getName(element: NOX3Property): String? {
            return getKey(element)
        }

        @JvmStatic
        fun setName(element: NOX3Property, newName: String?): PsiElement? {
            val keyNode: ASTNode? = element.node.findChildByType(NOX3Types.KEY)
            if (keyNode != null) {
                val validName = newName ?: throw IllegalArgumentException("newName cannot be null")
                val property: NOX3Property = NOX3ElementFactory.createProperty(element.project, validName)
                val newKeyNode: ASTNode = property.firstChild.node
                element.node.replaceChild(keyNode, newKeyNode)
            }
            return element
        }

        @JvmStatic
        fun getNameIdentifier(element: NOX3Property): PsiElement? {
            return element.node.findChildByType(NOX3Types.KEY)?.psi
        }


    }

}

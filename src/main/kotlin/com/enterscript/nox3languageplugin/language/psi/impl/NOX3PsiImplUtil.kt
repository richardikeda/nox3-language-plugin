package com.enterscript.nox3languageplugin.language.psi.impl

import com.enterscript.nox3languageplugin.language.psi.*
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.enterscript.nox3languageplugin.language.psi.NOX3ElementFactory
import com.intellij.psi.PsiElement

object NOX3PsiImplUtil {
    @JvmStatic
    fun getName(element: NOX3NamedElement): String? {
        val idNode = element.node.findChildByType(NOX3Types.KEY)
        return idNode?.text
    }

    @JvmStatic
    fun setName(element: NOX3NamedElement, newName: String): PsiElement {
        val idNode = element.node.findChildByType(NOX3Types.KEY)
        if (idNode != null) {
            val newId = NOX3ElementFactory.createIdentifier(element, newName)
            element.node.replaceChild(idNode, newId.node)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: NOX3NamedElement): PsiElement? {
        val idNode = element.node.findChildByType(NOX3Types.KEY)
        return idNode?.psi
    }

    @JvmStatic
    fun getKey(property: NOX3Property): String? = getName(property)

    @JvmStatic
    fun getValue(property: NOX3Property): String? {
        val valueNode = property.node.findChildByType(NOX3Types.VALUE)
        return valueNode?.text
    }
}

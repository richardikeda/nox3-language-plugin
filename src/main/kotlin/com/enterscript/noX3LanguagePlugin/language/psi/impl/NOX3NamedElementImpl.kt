package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.enterscript.noX3LanguagePlugin.language.psi.*
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class NOX3NamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), NOX3NamedElement {
    override fun getName(): String? = NOX3PsiImplUtil.getName(this)
    override fun setName(name: String): PsiElement = NOX3PsiImplUtil.setName(this, name)
    override fun getNameIdentifier(): PsiElement? = NOX3PsiImplUtil.getNameIdentifier(this)
}

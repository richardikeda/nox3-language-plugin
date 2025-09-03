package com.enterscript.nox3languageplugin.language

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.impl.FakePsiElement

/**
 * Lightweight PSI element used to attach documentation to lookup items.
 */
class NOX3KeywordDocElement(private val manager: PsiManager, val keyword: String) : FakePsiElement() {
    override fun getProject() = manager.project
    override fun getLanguage() = NOX3Language.INSTANCE
    override fun getParent(): PsiElement? = null
    override fun toString(): String = "NOX3KeywordDocElement($keyword)"
}


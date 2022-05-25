package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement


class NOX3RefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(elementToRename: PsiElement, context: PsiElement?): Boolean {
        return elementToRename is NOX3Property
    }
}
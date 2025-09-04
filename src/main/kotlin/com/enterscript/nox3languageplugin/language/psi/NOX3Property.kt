package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.psi.stubs.NOX3PropertyStub
import com.intellij.psi.stubs.StubBasedPsiElement

interface NOX3Property : NOX3NamedElement, StubBasedPsiElement<NOX3PropertyStub> {
    fun getKey(): String?
    fun getValue(): String?
}

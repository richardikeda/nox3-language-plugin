package com.enterscript.nox3languageplugin.language.psi.stubs

import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.intellij.psi.stubs.StubElement

interface NOX3VariableStub : StubElement<NOX3Variable> {
    val name: String?
}

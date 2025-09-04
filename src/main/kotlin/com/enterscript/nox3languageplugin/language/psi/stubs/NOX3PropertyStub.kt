package com.enterscript.nox3languageplugin.language.psi.stubs

import com.enterscript.nox3languageplugin.language.psi.NOX3Property
import com.intellij.psi.stubs.StubElement

interface NOX3PropertyStub : StubElement<NOX3Property> {
    val name: String?
}

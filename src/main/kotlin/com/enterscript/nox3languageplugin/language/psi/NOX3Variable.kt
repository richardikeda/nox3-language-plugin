package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.psi.stubs.NOX3VariableStub
import com.intellij.psi.stubs.StubBasedPsiElement

interface NOX3Variable : NOX3NamedElement, StubBasedPsiElement<NOX3VariableStub>

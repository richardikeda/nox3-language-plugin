package com.enterscript.nox3languageplugin.language.psi.stubs

import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement

class NOX3VariableStubImpl(
    parent: StubElement<*>?,
    elementType: IStubElementType<*, *>,
    override val name: String?
) : StubBase<NOX3Variable>(parent, elementType), NOX3VariableStub

package com.enterscript.nox3languageplugin.language.psi.stubs

import com.enterscript.nox3languageplugin.language.psi.NOX3Property
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement

class NOX3PropertyStubImpl(
    parent: StubElement<*>?,
    elementType: IStubElementType<*, *>,
    override val name: String?
) : StubBase<NOX3Property>(parent, elementType), NOX3PropertyStub

package com.enterscript.nox3languageplugin.language.psi.stubs

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.enterscript.nox3languageplugin.language.psi.impl.NOX3VariableImpl
import com.intellij.psi.stubs.*

class NOX3VariableStubElementType(debugName: String) :
    IStubElementType<NOX3VariableStub, NOX3Variable>(debugName, NOX3Language.INSTANCE) {

    override fun createPsi(stub: NOX3VariableStub): NOX3Variable =
        NOX3VariableImpl(stub, this)

    override fun createStub(psi: NOX3Variable, parentStub: StubElement<*>?): NOX3VariableStub =
        NOX3VariableStubImpl(parentStub, this, psi.name)

    override fun serialize(stub: NOX3VariableStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): NOX3VariableStub =
        NOX3VariableStubImpl(parentStub, this, dataStream.readNameString())

    override fun indexStub(stub: NOX3VariableStub, sink: IndexSink) {
        stub.name?.let { sink.occurrence(INDEX_KEY, it) }
    }

    override fun getExternalId(): String = "nox3.variable"

    companion object {
        val INDEX_KEY: StubIndexKey<String, NOX3Variable> =
            StubIndexKey.createIndexKey("nox3.variable")
    }
}

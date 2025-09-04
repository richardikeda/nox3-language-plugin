package com.enterscript.nox3languageplugin.language.psi.stubs

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.enterscript.nox3languageplugin.language.psi.NOX3Property
import com.enterscript.nox3languageplugin.language.psi.impl.NOX3PropertyImpl
import com.intellij.psi.stubs.*

class NOX3PropertyStubElementType(debugName: String) :
    IStubElementType<NOX3PropertyStub, NOX3Property>(debugName, NOX3Language.INSTANCE) {

    override fun createPsi(stub: NOX3PropertyStub): NOX3Property =
        NOX3PropertyImpl(stub, this)

    override fun createStub(psi: NOX3Property, parentStub: StubElement<*>?): NOX3PropertyStub =
        NOX3PropertyStubImpl(parentStub, this, psi.name)

    override fun serialize(stub: NOX3PropertyStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): NOX3PropertyStub =
        NOX3PropertyStubImpl(parentStub, this, dataStream.readNameString())

    override fun indexStub(stub: NOX3PropertyStub, sink: IndexSink) {
        stub.name?.let { sink.occurrence(INDEX_KEY, it) }
    }

    override fun getExternalId(): String = "nox3.property"

    companion object {
        val INDEX_KEY: StubIndexKey<String, NOX3Property> =
            StubIndexKey.createIndexKey("nox3.property")
    }
}

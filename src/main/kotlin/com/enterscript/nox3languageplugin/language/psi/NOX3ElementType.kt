package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.intellij.psi.tree.IElementType


class NOX3ElementType(debugName: String) :
    IElementType    (debugName, NOX3Language.INSTANCE) {
    override fun toString(): String =  "NOX3ElementType." + super.toString()


}

package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.intellij.psi.tree.IElementType


class NOX3TokenType(debugName: String) :
    IElementType(debugName, NOX3Language.INSTANCE) {

    override fun toString(): String {
        return "NOX3TokenType." + super.toString()
    }

}
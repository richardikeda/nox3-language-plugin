package com.enterscript.noX3LanguagePlugin.language.psi

import com.enterscript.noX3LanguagePlugin.language.NOX3Language
import com.intellij.psi.tree.IElementType


class NOX3ElementType(debugName: String) :
    IElementType    (debugName, NOX3Language) {
    override fun toString(): String {
        return "NOX3ElementType." + super.toString()
    }

}


//refer class SimpleElementType(debugName: String) : IElementType(debugName, SimpleLanguage.INSTANCE)


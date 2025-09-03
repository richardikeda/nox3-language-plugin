package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

/**
 * Token type used by the generated lexer and parser.
 */
class NOX3TokenType(@NonNls debugName: String) : IElementType(debugName, NOX3Language.INSTANCE) {
    override fun toString(): String = "NOX3TokenType." + super.toString()
}


package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

/**
 * Defines a custom element type for NOX3 AST nodes.
 */
class NOX3ElementType(@NonNls debugName: String) : IElementType(debugName, NOX3Language.INSTANCE)


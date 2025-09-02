package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.psi.impl.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

object NOX3Types {
    @JvmField val MODULE_DECL: IElementType = NOX3ElementType("MODULE_DECL")
    @JvmField val FUNCTION_DECL: IElementType = NOX3ElementType("FUNCTION_DECL")
    @JvmField val VARIABLE_DECL: IElementType = NOX3ElementType("VARIABLE_DECL")

    @JvmField val MODULE: IElementType = NOX3TokenType("MODULE")
    @JvmField val FUNCTION: IElementType = NOX3TokenType("FUNCTION")
    @JvmField val VAR: IElementType = NOX3TokenType("VAR")
    @JvmField val IDENTIFIER: IElementType = NOX3TokenType("IDENTIFIER")

    object Factory {
        @JvmStatic
        fun createElement(node: ASTNode): PsiElement {
            return when (node.elementType) {
                MODULE_DECL -> NOX3ModuleImpl(node)
                FUNCTION_DECL -> NOX3FunctionImpl(node)
                VARIABLE_DECL -> NOX3VariableImpl(node)
                else -> throw AssertionError("Unknown element type: " + node.elementType)
            }
        }
    }
}

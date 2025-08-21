package com.enterscript.noX3LanguagePlugin.language.psi.impl.parser

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.intellij.lang.ASTNode
import com.intellij.lang.LightPsiParser
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class NOX3Parser : PsiParser, LightPsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        parseLight(root, builder)
        return builder.treeBuilt
    }

    override fun parseLight(root: IElementType, builder: PsiBuilder) {
        val marker = builder.mark()
        while (!builder.eof()) {
            when (builder.tokenType) {
                NOX3Types.MODULE -> parseModule(builder)
                NOX3Types.FUNCTION -> parseFunction(builder)
                NOX3Types.VAR -> parseVariable(builder)
                else -> builder.advanceLexer()
            }
        }
        marker.done(root)
    }

    private fun parseModule(builder: PsiBuilder) {
        val m = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == NOX3Types.IDENTIFIER) {
            builder.advanceLexer()
        }
        m.done(NOX3Types.MODULE_DECL)
    }

    private fun parseFunction(builder: PsiBuilder) {
        val m = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == NOX3Types.IDENTIFIER) {
            builder.advanceLexer()
        }
        m.done(NOX3Types.FUNCTION_DECL)
    }

    private fun parseVariable(builder: PsiBuilder) {
        val m = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == NOX3Types.IDENTIFIER) {
            builder.advanceLexer()
        }
        m.done(NOX3Types.VARIABLE_DECL)
    }
}

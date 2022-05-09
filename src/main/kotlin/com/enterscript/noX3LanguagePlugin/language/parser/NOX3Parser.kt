package com.enterscript.noX3LanguagePlugin.language.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.LightPsiParser
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.lang.parser.GeneratedParserUtilBase.*
import com.intellij.psi.tree.IElementType


class NOX3Parser : PsiParser, LightPsiParser {
    override fun parseLight(root: IElementType?, builder: PsiBuilder?) {
        var b = builder
        val t: IElementType? =root

        b = adapt_builder_(t, b, this, null)
        val m: PsiBuilder.Marker = enter_section_(b, 0, _COLLAPSE_, null)
        val r: Boolean = parseRoot(t, b)

        exit_section_(b, 0, m, t, r, true, TRUE_CONDITION)

    }

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        TODO("Not yet implemented")
    }

    private fun parseRoot(t: IElementType?, b: PsiBuilder?): Boolean {
        return parseRoot(t, b)
    }


}
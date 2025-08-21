package com.enterscript.noX3LanguagePlugin.language.syntax

import com.enterscript.noX3LanguagePlugin.language.lexer.NOX3Lexer
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class NOX3SyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val KEYWORD: TextAttributesKey = createTextAttributesKey("NOX3_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val IDENTIFIER: TextAttributesKey = createTextAttributesKey("NOX3_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val BAD_CHARACTER: TextAttributesKey = createTextAttributesKey("NOX3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val keys = hashMapOf<IElementType, TextAttributesKey>(
            NOX3Types.MODULE to KEYWORD,
            NOX3Types.FUNCTION to KEYWORD,
            NOX3Types.VAR to KEYWORD,
            NOX3Types.IDENTIFIER to IDENTIFIER,
            TokenType.BAD_CHARACTER to BAD_CHARACTER
        )
    }

    override fun getHighlightingLexer(): Lexer = NOX3Lexer()
    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = pack(keys[tokenType])
}

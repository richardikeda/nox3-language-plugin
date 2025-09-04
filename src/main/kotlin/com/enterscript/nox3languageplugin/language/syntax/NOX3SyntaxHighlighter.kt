package com.enterscript.nox3languageplugin.language.syntax

import com.enterscript.nox3languageplugin.language.lexer.NOX3LexerAdapter
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

/**
 * Basic syntax highlighter for the X3 language. It recognises keywords,
 * literals and both line and block comments.
 */
class NOX3SyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val KEYWORD: TextAttributesKey = createTextAttributesKey("NOX3_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val IDENTIFIER: TextAttributesKey = createTextAttributesKey("NOX3_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val NUMBER: TextAttributesKey = createTextAttributesKey("NOX3_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val STRING: TextAttributesKey = createTextAttributesKey("NOX3_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER: TextAttributesKey = createTextAttributesKey("NOX3_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val COMMENT: TextAttributesKey = createTextAttributesKey("NOX3_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val SEPARATOR: TextAttributesKey = createTextAttributesKey("NOX3_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val BAD_CHARACTER: TextAttributesKey = createTextAttributesKey("NOX3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val SEPARATOR: TextAttributesKey = createTextAttributesKey("NOX3_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val IDENTIFIER: TextAttributesKey = createTextAttributesKey("NOX3_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)


        private val ATTRIBUTES = mapOf<IElementType, TextAttributesKey>(
            NOX3Types.MODULE to KEYWORD,
            NOX3Types.FUNCTION to KEYWORD,
            NOX3Types.VAR to KEYWORD,
            NOX3Types.IF to KEYWORD,
            NOX3Types.ENDIF to KEYWORD,
            NOX3Types.FOR to KEYWORD,
            NOX3Types.ENDFOR to KEYWORD,
            NOX3Types.SEPARATOR to SEPARATOR,
            NOX3Types.STRING to STRING,
            NOX3Types.NUMBER to NUMBER,
            NOX3Types.IDENTIFIER to IDENTIFIER,
            NOX3Types.COMMENT to COMMENT,
            TokenType.BAD_CHARACTER to BAD_CHARACTER
        )
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = pack(ATTRIBUTES[tokenType])

    override fun getHighlightingLexer(): Lexer = NOX3LexerAdapter()
}

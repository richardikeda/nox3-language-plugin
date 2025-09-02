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
        val STRING: TextAttributesKey = createTextAttributesKey("NOX3_STRING", DefaultLanguageHighlighterColors.STRING)
        val COMMENT: TextAttributesKey = createTextAttributesKey("NOX3_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER: TextAttributesKey = createTextAttributesKey("NOX3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        private val SEPARATOR: TextAttributesKey = createTextAttributesKey("NOX3_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)

        private val keys = HashMap<IElementType, TextAttributesKey>().apply {
            put(NOX3Types.KEY, KEYWORD)
            put(NOX3Types.VALUE, STRING)
            put(NOX3Types.COMMENT, COMMENT)
            put(NOX3Types.COMMENT_MULTI_LINE, COMMENT)
            put(NOX3Types.SEPARATOR, SEPARATOR)
            put(TokenType.BAD_CHARACTER, BAD_CHARACTER)
        }
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = pack(keys[tokenType])

    override fun getHighlightingLexer(): Lexer = NOX3LexerAdapter()
}

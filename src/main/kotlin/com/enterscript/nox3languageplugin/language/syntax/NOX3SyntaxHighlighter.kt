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
 * Basic syntax highlighter for the Sage X3 language. It recognises keywords,
 * literals, identifiers, operators and comments.
 */
class NOX3SyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val KEYWORD: TextAttributesKey =
            createTextAttributesKey("NOX3_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

        val IDENTIFIER: TextAttributesKey =
            createTextAttributesKey("NOX3_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)

        val NUMBER: TextAttributesKey =
            createTextAttributesKey("NOX3_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

        val STRING: TextAttributesKey =
            createTextAttributesKey("NOX3_STRING", DefaultLanguageHighlighterColors.STRING)

        val COMMENT: TextAttributesKey =
            createTextAttributesKey("NOX3_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

        val OPERATOR: TextAttributesKey =
            createTextAttributesKey("NOX3_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)

        val BAD_CHARACTER: TextAttributesKey =
            createTextAttributesKey("NOX3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val KEYWORDS = setOf(
            NOX3Types.SUBPROG,
            NOX3Types.VALUE,
            NOX3Types.GLOBAL,
            NOX3Types.LOCAL,
            NOX3Types.CLASS,
            NOX3Types.IF,
            NOX3Types.THEN,
            NOX3Types.ELSE,
            NOX3Types.ENDIF,
            NOX3Types.FOR,
            NOX3Types.TO,
            NOX3Types.NEXT,
            NOX3Types.CALL,
            NOX3Types.FROM,
            NOX3Types.CASE,
            NOX3Types.WHEN,
            NOX3Types.ENDCASE,
            NOX3Types.RETURN,
            NOX3Types.ONERRGO,
            NOX3Types.TRBEGIN,
            NOX3Types.COMMIT,
            NOX3Types.ROLLBACK,
            NOX3Types.FILTER,
            NOX3Types.READ,
            NOX3Types.UPDATE,
            NOX3Types.WRITE,
            NOX3Types.REWRITE,
            NOX3Types.DELETE,
            NOX3Types.GOSUB
        )

        private val OPERATORS = setOf(
            NOX3Types.SEPARATOR, // '='
            NOX3Types.PLUS,
            NOX3Types.MINUS,
            NOX3Types.STAR,
            NOX3Types.DIV,
            NOX3Types.NEQ,
            NOX3Types.LPAREN,
            NOX3Types.RPAREN,
            NOX3Types.LBRACKET,
            NOX3Types.RBRACKET,
            NOX3Types.COMMA,
            NOX3Types.ACTION,
            NOX3Types.DOT,
            NOX3Types.COLON
        )

        private val ATTRIBUTES: Map<IElementType, TextAttributesKey> = buildMap {
            KEYWORDS.forEach { put(it, KEYWORD) }
            OPERATORS.forEach { put(it, OPERATOR) }
            put(NOX3Types.NUMBER, NUMBER)
            put(NOX3Types.STRING, STRING)
            put(NOX3Types.IDENTIFIER, IDENTIFIER)
            put(NOX3Types.COMMENT, COMMENT)
            put(TokenType.BAD_CHARACTER, BAD_CHARACTER)
        }
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> =
        pack(ATTRIBUTES[tokenType])

    override fun getHighlightingLexer(): Lexer = NOX3LexerAdapter()
}


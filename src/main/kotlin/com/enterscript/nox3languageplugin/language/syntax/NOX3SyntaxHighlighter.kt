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
          val KEY: TextAttributesKey =
              createTextAttributesKey("NOX3_KEY", DefaultLanguageHighlighterColors.KEYWORD)

          val VALUE: TextAttributesKey =
              createTextAttributesKey("NOX3_VALUE", DefaultLanguageHighlighterColors.STRING)

          val SEPARATOR: TextAttributesKey =
              createTextAttributesKey("NOX3_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)

          val COMMENT: TextAttributesKey =
              createTextAttributesKey("NOX3_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

          val BAD_CHARACTER: TextAttributesKey =
              createTextAttributesKey("NOX3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

          private val ATTRIBUTES: Map<IElementType, TextAttributesKey> = mapOf(
              NOX3Types.KEY to KEY,
              NOX3Types.VALUE to VALUE,
              NOX3Types.SEPARATOR to SEPARATOR,
              NOX3Types.COMMENT to COMMENT,
              TokenType.BAD_CHARACTER to BAD_CHARACTER
          )
      }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> =
        pack(ATTRIBUTES[tokenType])

    override fun getHighlightingLexer(): Lexer = NOX3LexerAdapter()
}


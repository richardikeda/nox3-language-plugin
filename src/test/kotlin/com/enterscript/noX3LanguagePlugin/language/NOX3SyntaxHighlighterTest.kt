package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.syntax.NOX3SyntaxHighlighter
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals

class NOX3SyntaxHighlighterTest : BasePlatformTestCase() {
    fun testHighlightsTokens() {
        val highlighter = NOX3SyntaxHighlighter()
        val lexer = highlighter.highlightingLexer

        lexer.start("key=value")
        assertEquals(NOX3SyntaxHighlighter.KEYWORD, highlighter.getTokenHighlights(lexer.tokenType)[0])
        lexer.advance() // separator
        lexer.advance()
        assertEquals(NOX3SyntaxHighlighter.STRING, highlighter.getTokenHighlights(lexer.tokenType)[0])

        lexer.start("#comment")
        assertEquals(NOX3SyntaxHighlighter.COMMENT, highlighter.getTokenHighlights(lexer.tokenType)[0])
    }
}

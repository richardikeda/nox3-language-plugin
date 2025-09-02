package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.language.syntax.NOX3SyntaxHighlighter
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals

class NOX3SyntaxHighlighterTest : BasePlatformTestCase() {
    fun testHighlightsTokens() {
        val highlighter = NOX3SyntaxHighlighter()
        val lexer = highlighter.highlightingLexer

        lexer.start("case")
        assertEquals(NOX3SyntaxHighlighter.KEYWORD, highlighter.getTokenHighlights(lexer.tokenType)[0])

        lexer.start("\"text\"")
        assertEquals(NOX3SyntaxHighlighter.STRING, highlighter.getTokenHighlights(lexer.tokenType)[0])

        lexer.start("#comment")
        assertEquals(NOX3SyntaxHighlighter.COMMENT, highlighter.getTokenHighlights(lexer.tokenType)[0])
    }
}

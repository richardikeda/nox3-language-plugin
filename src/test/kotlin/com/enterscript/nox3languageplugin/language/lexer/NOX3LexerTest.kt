package com.enterscript.nox3languageplugin.language.lexer

import com.enterscript.nox3languageplugin.language.lexer.NOX3LexerAdapter
import com.enterscript.nox3languageplugin.language.lexer._NOX3Lexer
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import kotlin.test.Test
import kotlin.test.assertEquals

class NOX3LexerTest {
    @Test
    fun testKeywordToken() {
        val lexer = NOX3LexerAdapter(_NOX3Lexer(null))
        lexer.start("case")
        assertEquals(NOX3Types.CASE, lexer.tokenType)
    }

    @Test
    fun testFunctionToken() {
        val lexer = NOX3LexerAdapter(_NOX3Lexer(null))
        lexer.start("print")
        assertEquals(NOX3Types.PRINT, lexer.tokenType)
    }
}


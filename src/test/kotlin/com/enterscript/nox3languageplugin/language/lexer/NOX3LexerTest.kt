package com.enterscript.nox3languageplugin.language.lexer

import com.enterscript.nox3languageplugin.language.lexer.NOX3LexerAdapter
import com.enterscript.nox3languageplugin.language.lexer._NOX3Lexer
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import kotlin.test.Test
import kotlin.test.assertEquals

class NOX3LexerTest {
    @Test
    fun testModuleToken() {
        val lexer = NOX3LexerAdapter(_NOX3Lexer(null))
        lexer.start("module")
        assertEquals(NOX3Types.MODULE, lexer.tokenType)
    }

    @Test
    fun testFunctionToken() {
        val lexer = NOX3LexerAdapter(_NOX3Lexer(null))
        lexer.start("function")
        assertEquals(NOX3Types.FUNCTION, lexer.tokenType)
    }

    @Test
    fun testVarToken() {
        val lexer = NOX3LexerAdapter(_NOX3Lexer(null))
        lexer.start("var")
        assertEquals(NOX3Types.VAR, lexer.tokenType)
    }
}


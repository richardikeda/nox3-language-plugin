package com.enterscript.nox3languageplugin.language.lexer

import com.enterscript.nox3languageplugin.language.lexer.NOX3LexerAdapter
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import kotlin.test.Test
import kotlin.test.assertEquals

class NOX3LexerTest {
    @Test
    fun testTokens() {
        val lexer = NOX3LexerAdapter()
        lexer.start("foo:bar")
        assertEquals(NOX3Types.KEY, lexer.tokenType)
        lexer.advance()
        assertEquals(NOX3Types.SEPARATOR, lexer.tokenType)
        lexer.advance()
        assertEquals(NOX3Types.VALUE, lexer.tokenType)
    }
}

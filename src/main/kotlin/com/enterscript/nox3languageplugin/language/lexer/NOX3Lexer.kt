package com.enterscript.nox3languageplugin.language.lexer

import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class NOX3Lexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset: Int = 0
    private var endOffset: Int = 0
    private var tokenStart: Int = 0
    private var tokenEnd: Int = 0
    private var tokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.tokenStart = startOffset
        advance()
    }

    override fun getState(): Int = 0

    override fun getTokenType(): IElementType? = tokenType

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = endOffset

    override fun advance() {
        var current = tokenEnd
        while (current < endOffset && buffer[current].isWhitespace()) {
            current++
        }
        if (current >= endOffset) {
            tokenStart = endOffset
            tokenEnd = endOffset
            tokenType = null
            return
        }
        tokenStart = current
        while (current < endOffset && !buffer[current].isWhitespace()) {
            current++
        }
        tokenEnd = current
        val word = buffer.subSequence(tokenStart, tokenEnd).toString()
        tokenType = when (word.lowercase()) {
            "module" -> NOX3Types.MODULE
            "function" -> NOX3Types.FUNCTION
            "var" -> NOX3Types.VAR
            else -> NOX3Types.IDENTIFIER
        }
    }
}

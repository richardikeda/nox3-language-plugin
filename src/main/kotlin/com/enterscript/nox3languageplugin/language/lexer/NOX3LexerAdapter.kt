package com.enterscript.nox3languageplugin.language.lexer

import com.enterscript.nox3languageplugin.language.lexer._NOX3Lexer
import com.intellij.lexer.FlexAdapter

class NOX3LexerAdapter : FlexAdapter(_NOX3Lexer(null))

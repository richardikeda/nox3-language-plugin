package com.enterscript.noX3LanguagePlugin.language

import com.intellij.lexer.FlexAdapter


class NOX3LexerAdapter : FlexAdapter(NOX3Lexer(null))
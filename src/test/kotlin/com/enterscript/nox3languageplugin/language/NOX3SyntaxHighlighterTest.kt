package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.language.syntax.NOX3SyntaxHighlighter
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals

class NOX3SyntaxHighlighterTest : BasePlatformTestCase() {
    fun testKeywordHighlighting() {
        myFixture.configureByText("test.nox3", "Subprog Demo")
        myFixture.checkHighlighting(false, true, false)

        val highlight = myFixture.doHighlighting().first { it.startOffset == 0 && it.endOffset == "Subprog".length }
        assertEquals(NOX3SyntaxHighlighter.KEYWORD, highlight.forcedTextAttributesKey)
    }
}

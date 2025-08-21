package com.enterscript.noX3LanguagePlugin.language

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertTrue

class NOX3InspectionTest : BasePlatformTestCase() {
    fun testAnnotatorHighlights() {
        myFixture.configureByText("a.java", "class A { String s = \"X3:key\"; }")
        val highlights = myFixture.doHighlighting()
        assertTrue(highlights.any { it.severity == HighlightSeverity.INFORMATION })
    }
}

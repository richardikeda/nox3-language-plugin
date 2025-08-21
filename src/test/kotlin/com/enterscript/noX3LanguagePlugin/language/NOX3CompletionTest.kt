package com.enterscript.noX3LanguagePlugin.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertTrue

class NOX3CompletionTest : BasePlatformTestCase() {
    fun testCompletion() {
        myFixture.configureByText("a.nox3", "<caret>")
        val result = myFixture.completeBasic().map { it.lookupString }
        assertTrue(result.contains("Hello"))
    }
}

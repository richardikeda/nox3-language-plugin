package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NOX3NavigationTest : BasePlatformTestCase() {
    fun testNavigateToProperty() {
        myFixture.configureByText("a.nox3", "foo:bar")
        myFixture.configureByText("b.java", "class B { String s = \"X3:fo<caret>o\"; }")
        val element = myFixture.elementAtCaret
        assertTrue(element is NOX3Property)
        assertEquals("foo", (element as NOX3Property).key)
    }
}

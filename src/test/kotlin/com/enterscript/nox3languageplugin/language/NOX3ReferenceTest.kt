package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class NOX3ReferenceTest : BasePlatformTestCase() {
    fun testVariableReference() {
        myFixture.configureByText("test.nox3", "var myVar\n a = myV<caret>ar")
        val resolved = myFixture.getReferenceAtCaretPosition()?.resolve()
        assertNotNull(resolved)
        assertTrue(resolved is NOX3Variable)
        assertEquals("myVar", (resolved as NOX3Variable).name)
    }
}

package com.enterscript.nox3languageplugin.language

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixture4TestCase
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NOX3FunctionCallInspectionTest : LightJavaCodeInsightFixture4TestCase() {

    @Test
    fun testValidArity() {
        myFixture.configureByText("Foo.java", "class Foo { String a = \"X3:addmonth(1,2)\"; }")
        myFixture.enableInspections(NOX3FunctionCallInspection())
        val highlights = myFixture.doHighlighting()
        assertEquals(0, highlights.count { it.severity.myName == \"ERROR\" })
    }

    @Test
    fun testInvalidArity() {
        myFixture.configureByText("Foo.java", "class Foo { String a = \"X3:addmonth(1)\"; }")
        myFixture.enableInspections(NOX3FunctionCallInspection())
        val highlights = myFixture.doHighlighting()
        assertTrue(highlights.any { it.description?.contains(\"Too few arguments\") == true })
    }
}

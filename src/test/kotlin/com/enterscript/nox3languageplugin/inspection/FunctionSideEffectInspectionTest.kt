package com.enterscript.nox3languageplugin.inspection

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixture4TestCase
import kotlin.test.Test
import kotlin.test.assertTrue

class FunctionSideEffectInspectionTest : LightJavaCodeInsightFixture4TestCase() {

    @Test
    fun testSideEffectInPureContext() {
        myFixture.configureByText("Pure.java", "public @interface Pure {}")
        myFixture.configureByText(
            "Foo.java",
            """
            class Foo {
                @Pure void test() {
                    String a = \"X3:ADXTCP()\";
                }
            }
            """
        )
        myFixture.enableInspections(FunctionSideEffectInspection())
        val highlights = myFixture.doHighlighting()
        assertTrue(highlights.any { it.description?.contains("side-effecting function") == true })
    }
}

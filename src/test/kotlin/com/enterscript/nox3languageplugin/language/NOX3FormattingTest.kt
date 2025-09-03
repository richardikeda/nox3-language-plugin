package com.enterscript.nox3languageplugin.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class NOX3FormattingTest : BasePlatformTestCase() {

    fun testFormatIfElseEndif() {
        val before = """IF\nA\nELSE\nB\nENDIF"""
        val after = """IF\n    A\nELSE\n    B\nENDIF"""
        myFixture.configureByText("a.src", before)
        myFixture.performEditorAction("ReformatCode")
        myFixture.checkResult(after)
    }

    fun testFormatCaseWhenEndcase() {
        val before = """CASE\nWHEN\nA\nWHEN\nB\nENDCASE"""
        val after = """CASE\nWHEN\n    A\nWHEN\n    B\nENDCASE"""
        myFixture.configureByText("b.src", before)
        myFixture.performEditorAction("ReformatCode")
        myFixture.checkResult(after)
    }
}

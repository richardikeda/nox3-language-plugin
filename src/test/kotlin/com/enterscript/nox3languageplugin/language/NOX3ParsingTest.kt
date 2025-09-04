package com.enterscript.nox3languageplugin.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.psi.util.PsiTreeUtil
import kotlin.test.assertFalse

class NOX3ParsingTest : BasePlatformTestCase() {
    fun testModuleFunctionVariableParsing() {
        val file = myFixture.configureByText(
            "test.nox3",
            """module Demo\nfunction foo\nend\nvar bar\nend"""
        )
        assertFalse(PsiTreeUtil.hasErrorElements(file))
    }
}

package com.enterscript.nox3languageplugin.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertTrue

class NOX3CompletionTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    fun testCompletionFromFiles() {
        myFixture.configureByFiles("completion/main.nox3", "completion/definitions.nox3")
        val result = myFixture.completeBasic().map { it.lookupString }
        assertTrue(result.contains("myVar"))
    }
}

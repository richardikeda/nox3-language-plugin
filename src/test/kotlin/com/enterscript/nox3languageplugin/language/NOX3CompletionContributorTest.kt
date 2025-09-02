package com.enterscript.nox3languageplugin.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertTrue

class NOX3CompletionContributorTest : BasePlatformTestCase() {
    fun testCompletionIncludesKeywordsFunctionsAndProperties() {
        myFixture.addFileToProject("other.nox3", "projectKey=1")
        myFixture.configureByText("test.nox3", "<caret>")
        val completions = myFixture.completeBasic().map { it.lookupString }
        assertTrue("case" in completions)
        assertTrue("user" in completions)
        assertTrue("len()" in completions)
        assertTrue("projectKey" in completions)
    }
}

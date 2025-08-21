package com.enterscript.noX3LanguagePlugin.language.psi

import com.enterscript.noX3LanguagePlugin.language.NOX3FileType
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertNotNull

class NOX3PsiCreationTest : BasePlatformTestCase() {
    private fun createFile(text: String): NOX3File {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.nox3", NOX3FileType.INSTANCE, text) as NOX3File
    }

    fun testParseModuleFunctionVariable() {
        val file = createFile("module Demo\nfunction foo\nvar bar")
        assertNotNull(PsiTreeUtil.findChildOfType(file, NOX3Module::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, NOX3Function::class.java))
        assertNotNull(PsiTreeUtil.findChildOfType(file, NOX3Variable::class.java))
    }
}

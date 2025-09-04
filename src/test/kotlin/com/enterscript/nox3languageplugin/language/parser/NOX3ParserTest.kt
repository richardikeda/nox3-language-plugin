package com.enterscript.nox3languageplugin.language.parser

import com.enterscript.nox3languageplugin.language.NOX3FileType
import com.enterscript.nox3languageplugin.language.psi.NOX3File
import com.enterscript.nox3languageplugin.language.psi.NOX3Function
import com.enterscript.nox3languageplugin.language.psi.NOX3Module
import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NOX3ParserTest : BasePlatformTestCase() {
    private fun createFile(text: String): NOX3File {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("test.nox3", NOX3FileType.INSTANCE, text) as NOX3File
    }

    fun testParseModuleFunctionVariable() {
        val file = createFile(
            """module Demo
function foo
end
var bar
end"""
        )
        val module = PsiTreeUtil.findChildOfType(file, NOX3Module::class.java)
        assertNotNull(module)
        val function = PsiTreeUtil.findChildOfType(module, NOX3Function::class.java)
        assertNotNull(function)
        assertEquals(module, PsiTreeUtil.getParentOfType(function, NOX3Module::class.java))
        val variable = PsiTreeUtil.findChildOfType(module, NOX3Variable::class.java)
        assertNotNull(variable)
        assertEquals(module, PsiTreeUtil.getParentOfType(variable, NOX3Module::class.java))
    }
}


package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.NOX3FileType
import com.enterscript.noX3LanguagePlugin.language.NOX3Util
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals

class NOX3UtilTest : BasePlatformTestCase() {

    private fun createProperty(text: String): NOX3Property {
        val file = PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.nox3", NOX3FileType.INSTANCE, text) as NOX3File
        return PsiTreeUtil.findChildOfType(file, NOX3Property::class.java)!!
    }

    fun testFindDocumentationCommentNoComment() {
        val property = createProperty("foo=42")
        val documentation = NOX3Util.findDocumentationComment(property)
        assertEquals("", documentation)
    }

    fun testFindDocumentationCommentMultipleComments() {
        val property = createProperty(
            """# First comment\n# Second comment\nfoo=42"""
        )
        val documentation = NOX3Util.findDocumentationComment(property)
        assertEquals("First comment\n Second comment", documentation)
    }

    fun testFindDocumentationCommentWithBlankLines() {
        val property = createProperty(
            """# First comment\n\nfoo=42"""
        )
        val documentation = NOX3Util.findDocumentationComment(property)
        assertEquals("First comment", documentation)
    }
}

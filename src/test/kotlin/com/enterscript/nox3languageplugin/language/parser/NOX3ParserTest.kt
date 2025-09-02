package com.enterscript.nox3languageplugin.language.parser

import com.enterscript.nox3languageplugin.language.NOX3FileType
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NOX3ParserTest : BasePlatformTestCase() {
    fun testParseProperty() {
        val file = PsiFileFactory.getInstance(project)
            .createFileFromText("a.nox3", NOX3FileType.INSTANCE, "foo:bar") as NOX3File
        val property = PsiTreeUtil.findChildOfType(file, NOX3Property::class.java)
        assertNotNull(property)
        assertEquals("foo", property.key)
        assertEquals("bar", property.value)
    }
}

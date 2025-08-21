package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class NOX3ElementFactoryTest : BasePlatformTestCase() {

    fun testCreatePropertyWithValidName() {
        val property = NOX3ElementFactory.createProperty(project, "foo")
        assertNotNull(property)
    }

    fun testCreatePropertyWithNullName() {
        assertFailsWith<IllegalArgumentException> {
            NOX3ElementFactory.createProperty(project, null)
        }
    }
}


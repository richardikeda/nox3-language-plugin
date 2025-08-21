package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class NOX3ElementFactoryTest : BasePlatformTestCase() {

    fun testCreatePropertyValid() {
        val property = NOX3ElementFactory.createProperty(project, "foo")
        assertNotNull(property)
        assertEquals("foo", property.key)
    }

    fun testCreatePropertyNullNameThrows() {
        assertFailsWith<IllegalArgumentException> {
            NOX3ElementFactory.createProperty(project, null)
        }
    }
}


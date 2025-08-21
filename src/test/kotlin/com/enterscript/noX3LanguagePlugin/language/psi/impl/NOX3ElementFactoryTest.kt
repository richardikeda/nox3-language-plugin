package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NOX3ElementFactoryTest : BasePlatformTestCase() {
    fun testCreateModule() {
        val module = NOX3ElementFactory.createModule(project, "Demo")
        assertNotNull(module)
        assertEquals("Demo", module.name)
    }

    fun testCreateFunction() {
        val function = NOX3ElementFactory.createFunction(project, "foo")
        assertNotNull(function)
        assertEquals("foo", function.name)
    }

    fun testCreateVariable() {
        val variable = NOX3ElementFactory.createVariable(project, "bar")
        assertNotNull(variable)
        assertEquals("bar", variable.name)
    }
}

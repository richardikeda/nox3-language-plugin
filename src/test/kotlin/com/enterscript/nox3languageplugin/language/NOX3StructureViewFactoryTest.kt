package com.enterscript.nox3languageplugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.nox3languageplugin.language.structure.NOX3StructureViewFactory
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertTrue

class NOX3StructureViewFactoryTest : BasePlatformTestCase() {
    fun testStructureViewListsProperties() {
        val file = myFixture.configureByText("test.nox3", "foo=1\nbar=2") as NOX3File
        val builder = NOX3StructureViewFactory().getStructureViewBuilder(file)!!
        val model = builder.createStructureViewModel(null)
        val root = model.root as StructureViewTreeElement
        val names = root.children.map { it.presentation.presentableText }
        assertTrue(names.contains("foo"))
        assertTrue(names.contains("bar"))
    }
}

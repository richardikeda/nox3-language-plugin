package com.enterscript.noX3LanguagePlugin.language.structure

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.ide.structureView.StructureViewBuilder
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.ide.structureView.impl.model.StructureViewModelBase
import com.intellij.ide.structureView.impl.model.TreeBasedStructureViewBuilder
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil

/**
 * Provides a simple structure view for X3 files allowing quick navigation
 * between properties within the file.
 */
class NOX3StructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder? {
        if (psiFile !is NOX3File) return null
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel =
                NOX3StructureViewModel(psiFile, editor)
        }
    }
}

private class NOX3StructureViewModel(file: NOX3File, editor: Editor?) :
    StructureViewModelBase(file, editor, NOX3StructureViewElement(file)),
    StructureViewModel.ElementInfoProvider {

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement) = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement) = element.value is NOX3Property
}

private class NOX3StructureViewElement(element: PsiElement) :
    PsiTreeElementBase<PsiElement>(element) {

    override fun getChildrenBase(): Collection<StructureViewTreeElement> {
        val file = element as? NOX3File ?: return emptyList()
        val properties = PsiTreeUtil.getChildrenOfType(file, NOX3Property::class.java) ?: return emptyList()
        return properties.map { NOX3StructureViewElement(it) }
    }

    override fun getPresentableText(): String? = when (val el = element) {
        is NOX3File -> el.name
        is NOX3Property -> el.key
        else -> el.text
    }
}

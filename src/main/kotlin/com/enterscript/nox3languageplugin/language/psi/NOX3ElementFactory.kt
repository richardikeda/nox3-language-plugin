package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

object NOX3ElementFactory {
    fun createProperty(project: Project, name: String): NOX3Property {
        val file = createFile(project, "$name=0")
        return file.firstChild as NOX3Property
    }

    fun createIdentifier(project: Project, name: String): PsiElement {
        val property = createProperty(project, name)
        return property.firstChild
    }

    private fun createFile(project: Project, text: String): NOX3File {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.nox3", NOX3FileType.INSTANCE, text) as NOX3File
    }
}

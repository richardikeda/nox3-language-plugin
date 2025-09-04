package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

object NOX3ElementFactory {
    private fun createFile(project: Project, text: String): NOX3File =
        PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.nox3", NOX3FileType.INSTANCE, text) as NOX3File

    fun createModule(project: Project, name: String): NOX3Module {
        val file = createFile(project, "MODULE $name\nEND")
        return file.firstChild as NOX3Module
    }

    fun createFunction(project: Project, name: String): NOX3Function {
        val file = createFile(project, "FUNCTION $name\nEND")
        return file.firstChild as NOX3Function
    }

    fun createVariable(project: Project, name: String): NOX3Variable {
        val file = createFile(project, "VAR $name")
        return file.firstChild as NOX3Variable
    }

    fun createProperty(project: Project, name: String): NOX3Property {
        val file = createFile(project, "$name=0")
        return file.firstChild as NOX3Property
    }

    fun createIdentifier(context: NOX3NamedElement, name: String): PsiElement {
        val element: NOX3NamedElement = when (context) {
            is NOX3Module -> createModule(context.project, name)
            is NOX3Function -> createFunction(context.project, name)
            is NOX3Variable -> createVariable(context.project, name)
            is NOX3Property -> createProperty(context.project, name)
            else -> throw IllegalArgumentException("Unsupported element type: ${context.javaClass}")
        }
        return element.nameIdentifier!!
    }
}

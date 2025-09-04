package com.enterscript.nox3languageplugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

/**
 * Utility factory used to create tiny PSI fragments. These helpers are
 * primarily leveraged by refactorings (e.g. rename) which need to construct a
 * new identifier and splice it into the existing tree. The functions below
 * build minimal textual representations of the different language constructs
 * and then return the relevant PSI element.
 */
object NOX3ElementFactory {

    /** Create a temporary [NOX3File] from raw [text]. */
    fun createFile(project: Project, text: String): NOX3File =
        PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.nox3", NOX3FileType.INSTANCE, text) as NOX3File

    fun createSubprog(project: Project, name: String): NOX3Subprog {
        val file = createFile(project, "SUBPROG $name\nEND")
        return file.firstChild as NOX3Subprog
    }

    fun createClass(project: Project, name: String): NOX3Class {
        val file = createFile(project, "CLASS $name\nEND")
        return file.firstChild as NOX3Class
    }

    fun createGlobalVariable(project: Project, name: String): NOX3GlobalVar {
        val file = createFile(project, "VAR $name")
        return file.firstChild as NOX3GlobalVar
    }

    fun createLocalVariable(project: Project, name: String): NOX3LocalVar {
        val file = createFile(project, "LOCAL $name")
        return file.firstChild as NOX3LocalVar
    }

    fun createInstance(project: Project, name: String): NOX3Instance {
        val file = createFile(project, "INSTANCE $name")
        return file.firstChild as NOX3Instance
    }

    fun createParameter(project: Project, name: String): NOX3Parameter {
        // Parameters cannot appear at the top level, therefore we create a
        // dummy sub-program and extract the parameter from its list.
        val file = createFile(project, "SUBPROG dummy($name)\nEND")
        val subprog = file.firstChild as NOX3Subprog
        val params = subprog.parameterList?.parameterList
        return params!!.first()
    }

    fun createProperty(project: Project, name: String): NOX3Property {
        val file = createFile(project, "$name=0")
        return file.firstChild as NOX3Property
    }

    fun createIdentifier(context: NOX3NamedElement, name: String): PsiElement {
        val element: NOX3NamedElement = when (context) {
            is NOX3Subprog -> createSubprog(context.project, name)
            is NOX3Class -> createClass(context.project, name)
            is NOX3GlobalVar -> createGlobalVariable(context.project, name)
            is NOX3LocalVar -> createLocalVariable(context.project, name)
            is NOX3Instance -> createInstance(context.project, name)
            is NOX3Parameter -> createParameter(context.project, name)
            is NOX3Property -> createProperty(context.project, name)
            else -> throw IllegalArgumentException("Unsupported element type: ${context.javaClass}")
        }
        return element.nameIdentifier!!
    }
}


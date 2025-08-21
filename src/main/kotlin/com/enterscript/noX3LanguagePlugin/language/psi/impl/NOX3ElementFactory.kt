package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.enterscript.noX3LanguagePlugin.language.NOX3FileType
import com.enterscript.noX3LanguagePlugin.language.psi.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

class NOX3ElementFactory {
    companion object {
        private fun createFile(project: Project?, text: String): NOX3File {
            val name = "dummy.nox3"
            return PsiFileFactory.getInstance(project).createFileFromText(name, NOX3FileType.INSTANCE, text) as NOX3File
        }

        fun createModule(project: Project?, name: String): NOX3Module {
            val file = createFile(project, "module $name")
            return file.firstChild as NOX3Module
        }

        fun createFunction(project: Project?, name: String): NOX3Function {
            val file = createFile(project, "function $name")
            return file.firstChild as NOX3Function
        }

        fun createVariable(project: Project?, name: String): NOX3Variable {
            val file = createFile(project, "var $name")
            return file.firstChild as NOX3Variable
        }
    }
}

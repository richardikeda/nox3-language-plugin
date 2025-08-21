package com.enterscript.noX3LanguagePlugin.language.psi.impl
import com.enterscript.noX3LanguagePlugin.language.NOX3FileType
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

class NOX3ElementFactory {


    companion object {

        private fun createFile(project: Project?, text: String?): NOX3File {
            val content = text ?: throw IllegalArgumentException("text cannot be null")
            val name = "SPEDUMMY.src"
            return PsiFileFactory.getInstance(project).createFileFromText(name, NOX3FileType.INSTANCE, content) as NOX3File
        }

        fun createProperty(project: Project?, name: String?): NOX3Property {
            val propertyName = name ?: throw IllegalArgumentException("name cannot be null")
            val file: NOX3File = createFile(project, "$propertyName=0")
            return file.firstChild as NOX3Property
        }


    }
}


package com.enterscript.noX3LanguagePlugin.language.psi.impl
import com.enterscript.noX3LanguagePlugin.language.NOX3FileType
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

class NOX3ElementFactory {


    companion object {

        private fun createFile(project: Project?, text: String?): NOX3File {
            val name = "SPEDUMMY.src"
            return PsiFileFactory.getInstance(project).createFileFromText(name, NOX3FileType.INSTANCE, text.toString()) as NOX3File
        }

        fun createProperty(project: Project?, name: String?): NOX3Property {
            val file: NOX3File = createFile(project, name)
            return file.firstChild as NOX3Property
        }


    }
}


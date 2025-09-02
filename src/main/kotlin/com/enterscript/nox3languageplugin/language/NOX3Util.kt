package com.enterscript.nox3languageplugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Variable
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

open class NOX3Util {
    companion object {
        fun findVariables(project: Project, name: String): List<NOX3Variable> {
            val result = mutableListOf<NOX3Variable>()
            val virtualFiles = FileTypeIndex.getFiles(NOX3FileType.INSTANCE, GlobalSearchScope.allScope(project))
            for (virtualFile in virtualFiles) {
                val file = PsiManager.getInstance(project).findFile(virtualFile) as? NOX3File ?: continue
                val variables = PsiTreeUtil.findChildrenOfType(file, NOX3Variable::class.java)
                variables.filterTo(result) { it.name == name }
            }
            return result
        }

        fun findVariables(project: Project): List<NOX3Variable> {
            val result = mutableListOf<NOX3Variable>()
            val virtualFiles = FileTypeIndex.getFiles(NOX3FileType.INSTANCE, GlobalSearchScope.allScope(project))
            for (virtualFile in virtualFiles) {
                val file = PsiManager.getInstance(project).findFile(virtualFile) as? NOX3File ?: continue
                val variables = PsiTreeUtil.findChildrenOfType(file, NOX3Variable::class.java)
                result.addAll(variables)
            }
            return result
        }
    }
}

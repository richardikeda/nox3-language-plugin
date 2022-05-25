package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property
import com.google.common.collect.Lists
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

open class NOX3Util {
    companion object {
        /**
         * Searches the entire project for NOX3 language files with instances of the NOX3 property with the given key.
         *
         * @param project current project
         * @param key     to check
         * @return matching properties
         */
        fun findProperties(project: Project?, key: String): List<NOX3Property> {
            val result: MutableList<NOX3Property> = ArrayList()
            val virtualFiles = FileTypeIndex.getFiles(
                NOX3FileType.INSTANCE, GlobalSearchScope.allScope(
                    project!!
                )
            )
            for (virtualFile in virtualFiles) {
                val noX3File = PsiManager.getInstance(project).findFile(virtualFile!!) as NOX3File?
                if (noX3File != null) {
                    val properties = PsiTreeUtil.getChildrenOfType(
                        noX3File,
                        NOX3Property::class.java
                    )
                    if (properties != null) {
                        for (property in properties) {
                            if (key == property.key) {
                                result.add(property)
                            }
                        }
                    }
                }
            }
            return result
        }
        fun findProperties(project: Project?): List<NOX3Property> {
            val result: MutableList<NOX3Property> = ArrayList()
            val virtualFiles = FileTypeIndex.getFiles(
                NOX3FileType.INSTANCE, GlobalSearchScope.allScope(
                    project!!
                )
            )
            for (virtualFile in virtualFiles) {
                val noX3File = PsiManager.getInstance(project).findFile(virtualFile!!) as NOX3File?
                if (noX3File != null) {
                    val properties = PsiTreeUtil.getChildrenOfType(
                        noX3File,
                        NOX3Property::class.java
                    )
                    if (properties != null) {
                        Collections.addAll(result, *properties)
                    }
                }
            }
            return result
        }

        /**
         * Attempts to collect any comment elements above the NOX3 key/value pair.
         */
        fun findDocumentationComment(property: NOX3Property): String {
            val result: MutableList<String> = LinkedList()
            var element = property.prevSibling
            while (element is PsiComment || element is PsiWhiteSpace) {
                if (element is PsiComment) {
                    val commentText = element.getText().replaceFirst("[!# ]+".toRegex(), "")
                    result.add(commentText)
                }
                element = element.prevSibling
            }
            return StringUtil.join(Lists.reverse(result), "\n ")
        }

    }
}
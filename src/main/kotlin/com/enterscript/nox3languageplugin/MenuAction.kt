package com.enterscript.nox3languageplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile

/**
 * Action that creates the X3 language package structure.
 */
class MenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return

        val organization = Messages.showInputDialog(
            project,
            "Enter organization name",
            "New X3 Language Package",
            Messages.getQuestionIcon()
        ) ?: return

        val basePath = project.basePath ?: return
        val baseDir = LocalFileSystem.getInstance().refreshAndFindFileByPath(basePath) ?: return

        runWriteAction {
            val dirs = listOf("src", "main", "kotlin", "com", organization, "x3", "language")
            var current: VirtualFile = baseDir
            for (dir in dirs) {
                current = current.findChild(dir) ?: current.createChildDirectory(this, dir)
            }
            current.findChild("Language.kt") ?: current.createChildData(this, "Language.kt").apply {
                setBinaryContent("package com.$organization.x3.language\n\nclass Language".toByteArray())
            }
        }
    }
}


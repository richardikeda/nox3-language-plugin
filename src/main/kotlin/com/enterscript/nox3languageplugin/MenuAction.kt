package com.enterscript.nox3languageplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.LocalFileSystem
import java.nio.file.Files
import java.nio.file.Path

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

        runWriteAction {
            val packagePath = Path.of(basePath, "src", "main", "kotlin", "com", organization, "x3", "language")
            Files.createDirectories(packagePath)
            val filePath = packagePath.resolve("Language.kt")
            if (!Files.exists(filePath)) {
                Files.writeString(filePath, "package com.$organization.x3.language\n\nclass Language")
            }
            LocalFileSystem.getInstance().refreshAndFindFileByPath(filePath.toString())
        }
    }
}
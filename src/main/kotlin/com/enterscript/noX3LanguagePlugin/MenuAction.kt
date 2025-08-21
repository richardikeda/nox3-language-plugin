package com.enterscript.noX3LanguagePlugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VfsUtil

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

        WriteCommandAction.runWriteCommandAction(project) {
            val srcMainKotlin = VfsUtil.createDirectoryIfMissing(project.baseDir, "src/main/kotlin")
            val packageDir = VfsUtil.createDirectoryIfMissing(srcMainKotlin, "com/$organization/x3/language")
            val file = packageDir.findChild("Language.kt") ?: packageDir.createChildData(this, "Language.kt")
            val content = "package com.$organization.x3.language\n\nclass Language"
            VfsUtil.saveText(file, content)
        }
    }
}
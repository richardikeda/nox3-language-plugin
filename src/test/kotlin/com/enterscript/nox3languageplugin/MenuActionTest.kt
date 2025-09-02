package com.enterscript.nox3languageplugin

import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.testFramework.PlatformTestCase
import com.intellij.testFramework.TestActionEvent
import java.nio.file.Files
import java.nio.file.Path

class MenuActionTest : PlatformTestCase() {
    override fun setUp() {
        super.setUp()
        runWriteAction {
            val srcPath = Path.of(project.basePath!!, "src", "main", "kotlin")
            Files.createDirectories(srcPath)
            LocalFileSystem.getInstance().refreshAndFindFileByPath(srcPath.toString())
        }
    }

    fun testCreatesPackageStructure() {
        Messages.setTestInputDialog { "acme" }
        try {
            val action = MenuAction()
            val event = TestActionEvent.createTestEvent(action)
            action.actionPerformed(event)
        } finally {
            Messages.setTestInputDialog(null)
        }
        val filePath = Path.of(project.basePath!!, "src", "main", "kotlin", "com", "acme", "x3", "language", "Language.kt")
        val file = LocalFileSystem.getInstance().refreshAndFindFileByPath(filePath.toString())
        assertNotNull("Language.kt should be created", file)
    }
}

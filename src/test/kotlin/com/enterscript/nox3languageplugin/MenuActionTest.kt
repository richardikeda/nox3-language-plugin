package com.enterscript.nox3languageplugin

import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.PlatformTestCase
import com.intellij.testFramework.TestActionEvent

class MenuActionTest : PlatformTestCase() {
    override fun setUp() {
        super.setUp()
        val basePath = project.basePath ?: return
        val baseDir = LocalFileSystem.getInstance().refreshAndFindFileByPath(basePath) ?: return

        runWriteAction {
            var current: VirtualFile = baseDir
            for (dir in listOf("src", "main", "kotlin")) {
                current = current.findChild(dir) ?: current.createChildDirectory(this, dir)
            }
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

        val basePath = project.basePath ?: return
        val baseDir = LocalFileSystem.getInstance().refreshAndFindFileByPath(basePath) ?: return
        val file = baseDir.findFileByRelativePath("src/main/kotlin/com/acme/x3/language/Language.kt")
        assertNotNull("Language.kt should be created", file)
    }
}


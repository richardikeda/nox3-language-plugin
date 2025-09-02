package com.enterscript.nox3languageplugin

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.testFramework.PlatformTestCase
import com.intellij.testFramework.TestActionEvent

class MenuActionTest : PlatformTestCase() {
    override fun setUp() {
        super.setUp()
        WriteCommandAction.runWriteCommandAction(project) {
            VfsUtil.createDirectoryIfMissing(project.baseDir, "src/main/kotlin")
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
        val file = project.baseDir.findFileByRelativePath("src/main/kotlin/com/acme/x3/language/Language.kt")
        assertNotNull("Language.kt should be created", file)
    }
}

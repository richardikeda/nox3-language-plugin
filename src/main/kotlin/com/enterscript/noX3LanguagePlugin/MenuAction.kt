package com.enterscript.noX3LanguagePlugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages


class MenuAction : AnAction() {
    // menu creation reference https://www.youtube.com/watch?v=IeqRswA9VP8
    //12m00s
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(e.project, "Non Official X3 Plugin","NO X3 Plugin", Messages.getInformationIcon())
    }
    

}
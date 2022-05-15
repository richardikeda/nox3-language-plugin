package com.enterscript.noX3LanguagePlugin.language.syntax


import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile


//class NOX3SyntaxHighlighterFactory :  SyntaxHighlighterFactory() {
//    @NotNull
//    override fun getSyntaxHighlighter(project: Project?, file: VirtualFile?): SyntaxHighlighter = NOX3SyntaxHighlighter()
//
//}

class NOX3SyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, file: VirtualFile?): SyntaxHighlighter {
        return NOX3SyntaxHighlighter()
    }
}
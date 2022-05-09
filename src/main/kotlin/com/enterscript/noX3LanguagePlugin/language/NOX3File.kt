package com.enterscript.noX3LanguagePlugin.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class NOX3File (viewProvider: FileViewProvider?) : PsiFileBase(viewProvider!!, NOX3Language) {

    override fun getFileType(): FileType {
        return NOX3FileType.INSTANCE
    }

    override fun toString(): String {
        return "NOX3 File"
    }
}
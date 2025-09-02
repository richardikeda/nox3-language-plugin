package com.enterscript.noX3LanguagePlugin.language.psi

import com.enterscript.nox3languageplugin.language.NOX3FileType
import com.enterscript.nox3languageplugin.language.NOX3Language
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

import org.jetbrains.annotations.NotNull;

class NOX3File(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, NOX3Language.INSTANCE) {
    @NotNull
    override fun getFileType(): FileType {
        return NOX3FileType.INSTANCE
    }

    override fun toString(): String {
        return "X3 File"
    }
}
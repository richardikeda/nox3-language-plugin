package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.icons.NOX3Icons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class NOX3FileType private constructor() : LanguageFileType(NOX3Language.INSTANCE) {

    override fun getName() = "X3 Language"

    override fun getDescription() = "X3 language file"

    override fun getDefaultExtension() = "src"

    override fun getIcon(): Icon? = NOX3Icons.Icon.FileType

    companion object {
        @JvmField
        val INSTANCE = NOX3FileType()
    }

}


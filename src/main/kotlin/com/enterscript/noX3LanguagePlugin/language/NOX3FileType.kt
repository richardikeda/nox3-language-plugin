package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.icons.NOX3Icons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class NOX3FileType private constructor(): LanguageFileType(NOX3Language) {

    override fun getName()= "X3 Language"

    override fun getDescription() = "X3 language file"

    override fun getDefaultExtension() = "src"

    override fun getIcon(): Icon? = NOX3Icons.Icon.FileType

    companion object {
        @JvmField
        val INSTANCE = NOX3FileType()
    }

}


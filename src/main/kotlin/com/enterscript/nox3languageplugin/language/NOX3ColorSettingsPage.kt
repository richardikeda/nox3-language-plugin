package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.icons.NOX3Icons
import com.enterscript.nox3languageplugin.language.syntax.NOX3SyntaxHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class NOX3ColorSettingsPage : ColorSettingsPage {
    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", NOX3SyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Identifier", NOX3SyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Bad value", NOX3SyntaxHighlighter.BAD_CHARACTER)
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getDisplayName(): String = "X3"
    override fun getIcon(): Icon? = NOX3Icons.Icon.FileType
    override fun getHighlighter(): SyntaxHighlighter = NOX3SyntaxHighlighter()
    override fun getDemoText(): String = "module Demo\nfunction foo\nvar bar"
    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null
}

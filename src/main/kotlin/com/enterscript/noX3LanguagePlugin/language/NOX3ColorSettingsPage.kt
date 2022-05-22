package com.enterscript.noX3LanguagePlugin.language

import com.enterscript.noX3LanguagePlugin.icons.NOX3Icons
import com.enterscript.noX3LanguagePlugin.language.syntax.NOX3SyntaxHighlighter
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class NOX3ColorSettingsPage : ColorSettingsPage {

    companion object{
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Key", NOX3SyntaxHighlighter.KEY),
            AttributesDescriptor("Separator", NOX3SyntaxHighlighter.SEPARATOR),
            AttributesDescriptor("Value", NOX3SyntaxHighlighter.VALUE),
            AttributesDescriptor("Bad value", NOX3SyntaxHighlighter.BAD_CHARACTER)
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "X3"

    override fun getIcon(): Icon? = NOX3Icons.Icon.FileType

    override fun getHighlighter(): SyntaxHighlighter = NOX3SyntaxHighlighter()

    override fun getDemoText(): String = "# You are reading the \".properties\" entry.\n" +
            "! The exclamation mark can also mark text as comments.\n" +
            "website = https://en.wikipedia.org/\n" +
            "language = English\n" +
            "# The backslash below tells the application to continue reading\n" +
            "# the value onto the next line.\n" +
            "message = Welcome to \\\n" +
            "          Wikipedia!\n" +
            "# Add spaces to the key\n" +
            "key\\ with\\ spaces = This is the value that could be looked up with the key \"key with spaces\".\n" +
            "# Unicode\n" +
            "tab : \\u0009"

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null
}
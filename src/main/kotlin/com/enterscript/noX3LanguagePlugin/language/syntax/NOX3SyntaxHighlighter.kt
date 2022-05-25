package com.enterscript.noX3LanguagePlugin.language.syntax

import com.enterscript.noX3LanguagePlugin.language.lexer.NOX3LexerAdapter
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NotNull


class NOX3SyntaxHighlighter : SyntaxHighlighterBase() {
    internal companion object {
        internal val SEPARATOR  = createTextAttributesKey("NOX3_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
//
        internal val KEY= createTextAttributesKey("NOX3_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        internal val VALUE= createTextAttributesKey("VALUE", DefaultLanguageHighlighterColors.STRING)
        private val COMMENT= createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        private val COMMENT_MULTI_LINE= createTextAttributesKey("COMMENT_MULTI_LINE", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        internal val BAD_CHARACTER = createTextAttributesKey("NOX3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
//        val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)

        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val COMMENT_MULTI_LINE_KEYS = arrayOf(COMMENT_MULTI_LINE)
//        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)


        private val keys = HashMap<IElementType, TextAttributesKey>()

        init {
            keys[TokenType.BAD_CHARACTER] = HighlighterColors.BAD_CHARACTER
            keys[NOX3Types.COMMENT] = COMMENT
//            keys[NOX3Types.COMMENT_MULTI_LINE] = COMMENT_MULTI_LINE
            keys[NOX3Types.VALUE] = VALUE
            keys[NOX3Types.KEY] = KEY
            keys[NOX3Types.SEPARATOR] = SEPARATOR

//            fillMap(COMMENT_KEYS, NOX3Types.COMMENT, COMMENT)

//            keys.put(NOX3Types.COMMENT_MULTI_LINE, BLOCK_COMMENT)

//            keys.put(NOX3Types.SECTION_NAME, SECTION_NAME)

//            keys.put(NOX3Types.TYPE_NAME, TYPE_NAME)
//            keys.put(NOX3Types.TYPE_NAME_COMPARABLE, TYPE_NAME_COMPARABLE)
//            keys.put(NOX3Types.INSTRUCTION_TOKEN, INSTRUCTION)
//            fillMap(keys, NOX3Types.MACROS, MACRO)

//            keys.put(NOX3Types.TYPE_ANNOTATION_TOKEN, TYPE_ANNOTATION)
//            keys.put(NOX3Types.VAR_ANNOTATION_TOKEN, VARIABLE_ANNOTATION)
//            keys.put(NOX3Types.FIELD_ANNOTATION_TOKEN, FIELD_ANNOTATION)

//            keys.put(NOX3Types.INT, INT_LITERAL)
//            keys.put(NOX3Types.BYTE, BYTE_LITERAL)
//            keys.put(NOX3Types.QUOTE, STRING_LITERAL)
//            keys.put(NOX3Types.STRING_CONTENT, STRING_LITERAL)
//            keys.put(NOX3Types.STRING_ESCAPE, VALID_STRING_ESCAPE)
//            keys.put(NOX3Types.STRING_ESCAPE_INVALID, ILLEGAL_STRING_ESCAPE)
//            keys.put(NOX3Types.TAG, TAG)

//            keys.put(NOX3Types.SEMI, SEMI)
//            fillMap(keys, NOX3TokenSets.PARENTHESES, PAREN)
//            fillMap(keys, NOX3TokenSets.BRACES, BRACES)
        }



    }

    @NotNull
    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = pack(keys[tokenType])

    @NotNull
    override fun getHighlightingLexer(): Lexer = NOX3LexerAdapter()

//
//    @NotNull
//    override fun getHighlightingLexer(): Lexer = NOX3LexerAdapter()
//
//    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> {
//        if (tokenType == NOX3Types.SEPARATOR) {
//            return SEPARATOR_KEYS
//        }
//        if (tokenType == NOX3Types.KEY) {
//            return KEY_KEYS
//        }
//        if (tokenType == NOX3Types.VALUE) {
//            return VALUE_KEYS
//        }
//        if (tokenType == NOX3Types.COMMENT) {
//            return COMMENT_KEYS
//        }
//        if (tokenType == TokenType.BAD_CHARACTER) {
//            return BAD_CHAR_KEYS
//        }
//
//        return EMPTY_KEYS
//    }

}
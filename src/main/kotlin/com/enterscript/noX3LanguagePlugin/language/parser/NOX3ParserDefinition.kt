package com.enterscript.noX3LanguagePlugin.language.parser

import com.enterscript.noX3LanguagePlugin.language.NOX3File
import com.enterscript.noX3LanguagePlugin.language.NOX3Language
import com.enterscript.noX3LanguagePlugin.language.NOX3LexerAdapter
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class NOX3ParserDefinition : ParserDefinition {

    private  companion object {
        private val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        private val COMMENTS = TokenSet.create(NOX3Types.COMMENT)
        private val FILE = IFileElementType("X3Lang", NOX3Language)
    }

    override fun createLexer(project: Project): Lexer {
        return NOX3LexerAdapter()
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return NOX3Parser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return NOX3File(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode): PsiElement = throw UnsupportedOperationException()




}
package com.enterscript.noX3LanguagePlugin.language.parser

import com.enterscript.noX3LanguagePlugin.language.NOX3Language
import com.enterscript.noX3LanguagePlugin.language.lexer.NOX3LexerAdapter
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3File
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types
import com.enterscript.noX3LanguagePlugin.language.psi.impl.parser.NOX3Parser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.jetbrains.annotations.NotNull

class NOX3ParserDefinition : ParserDefinition {
    companion object{
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(NOX3Types.COMMENT)
        val FILE = IFileElementType(NOX3Language.INSTANCE)

    }

    @NotNull
    override fun createLexer(project: Project) = NOX3LexerAdapter()

    @NotNull
    override fun getWhitespaceTokens(): TokenSet =  WHITE_SPACES

    @NotNull
    override fun getCommentTokens(): TokenSet = COMMENTS
    @NotNull
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    @NotNull
    override fun createParser(project: Project): PsiParser =
        NOX3Parser()

    @NotNull
    override fun getFileNodeType(): IFileElementType  = FILE

    override fun createFile(viewProvider: FileViewProvider): PsiFile = NOX3File(viewProvider)

    override fun spaceExistanceTypeBetweenTokens(first: ASTNode, second: ASTNode): ParserDefinition.SpaceRequirements = ParserDefinition.SpaceRequirements.MAY

    @NotNull
    override fun createElement(node: ASTNode?): PsiElement {
        return NOX3Types.Factory.createElement(node)
    }



}
package com.enterscript.noX3LanguagePlugin.language.parser

import com.enterscript.noX3LanguagePlugin.language.NOX3Language
import com.enterscript.noX3LanguagePlugin.language.lexer.NOX3Lexer
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

class NOX3ParserDefinition : ParserDefinition {
    companion object {
        val WHITE_SPACES: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS: TokenSet = TokenSet.EMPTY
        val FILE: IFileElementType = IFileElementType(NOX3Language.INSTANCE)
    }

    override fun createLexer(project: Project) = NOX3Lexer()
    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACES
    override fun getCommentTokens(): TokenSet = COMMENTS
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
    override fun createParser(project: Project): PsiParser = NOX3Parser()
    override fun getFileNodeType(): IFileElementType = FILE
    override fun createFile(viewProvider: FileViewProvider): PsiFile = NOX3File(viewProvider)
    override fun spaceExistanceTypeBetweenTokens(first: ASTNode, second: ASTNode) = ParserDefinition.SpaceRequirements.MAY
    override fun createElement(node: ASTNode): PsiElement = NOX3Types.Factory.createElement(node)
}

package com.enterscript.nox3languageplugin.language.parser

import com.enterscript.nox3languageplugin.language.NOX3Language
import com.enterscript.nox3languageplugin.language.lexer.NOX3LexerAdapter
import com.enterscript.nox3languageplugin.language.psi.NOX3File
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class NOX3ParserDefinition : ParserDefinition {
    companion object {
        val COMMENTS: TokenSet = TokenSet.create(NOX3Types.COMMENT)
        val FILE: IFileElementType = IFileElementType(NOX3Language.INSTANCE)
    }

    override fun createLexer(project: Project) = NOX3LexerAdapter()
    override fun getCommentTokens(): TokenSet = COMMENTS
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
    override fun getFileNodeType(): IFileElementType = FILE
    override fun createFile(viewProvider: FileViewProvider): PsiFile = NOX3File(viewProvider)
    override fun spaceExistanceTypeBetweenTokens(first: ASTNode, second: ASTNode) = ParserDefinition.SpaceRequirements.MAY
    override fun createParser(project: Project): PsiParser = NOX3Parser()
    override fun createElement(node: ASTNode) = NOX3Types.Factory.createElement(node)
}

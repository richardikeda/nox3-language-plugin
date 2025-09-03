package com.enterscript.nox3languageplugin.language.format

import com.enterscript.nox3languageplugin.language.X3RuleService
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenType

/**
 * Formatting model aligning block constructs using rule information from [X3RuleService].
 * Middle tokens such as ELSE or WHEN are aligned with their corresponding block open tokens.
 */
class NOX3FormattingModelBuilder : FormattingModelBuilder {

    private val blockInfo = loadBlockInfo()

    private data class BlockInfo(
        val open: Set<IElementType>,
        val close: Set<IElementType>,
        val middle: Set<IElementType>
    )

    private fun loadBlockInfo(): BlockInfo {
        val open = mutableSetOf<IElementType>()
        val close = mutableSetOf<IElementType>()
        val middle = mutableSetOf<IElementType>()
        for (rule in X3RuleService.blockRules()) {
            val type = findType(rule.token) ?: continue
            if (rule.blockOpen) open += type
            if (rule.blockClose) close += type
            if (rule.blockMiddle) middle += type
        }
        return BlockInfo(open, close, middle)
    }

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val block = NOX3Block(formattingContext.node, formattingContext.codeStyleSettings)
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            block,
            formattingContext.codeStyleSettings
        )
    }

    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? = null

    private inner class NOX3Block(
        node: ASTNode,
        private val settings: CodeStyleSettings,
        private val indent: Indent? = null
    ) : AbstractBlock(node, Wrap.createWrap(WrapType.NONE, false), null) {

        override fun buildChildren(): MutableList<Block> {
            val blocks = mutableListOf<Block>()
            var child = myNode.firstChildNode
            while (child != null) {
                if (child.textRange.length > 0 && child.elementType != TokenType.WHITE_SPACE) {
                    blocks += NOX3Block(child, settings, calcIndent(child))
                }
                child = child.treeNext
            }
            return blocks
        }

        private fun calcIndent(node: ASTNode): Indent? {
            val type = node.elementType
            return when {
                blockInfo.close.contains(type) -> Indent.getNoneIndent()
                blockInfo.middle.contains(type) -> Indent.getNoneIndent()
                else -> null
            }
        }

        override fun getIndent(): Indent? = indent

        override fun getSpacing(child1: Block?, child2: Block): Spacing? = null

        override fun isLeaf(): Boolean = myNode.firstChildNode == null

        override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
            val prevBlock = if (newChildIndex > 0) subBlocks[newChildIndex - 1] else null
            val prevType = (prevBlock as? NOX3Block)?.myNode?.elementType
            val openTokens = blockInfo.open + blockInfo.middle
            val indent = if (prevType != null && openTokens.contains(prevType)) {
                Indent.getNormalIndent()
            } else {
                Indent.getNoneIndent()
            }
            return ChildAttributes(indent, null)
        }
    }

    private fun findType(name: String): IElementType? {
        return try {
            val field = NOX3Types::class.java.getField(name)
            field.get(null) as? IElementType
        } catch (_: Exception) {
            null
        }
    }
}


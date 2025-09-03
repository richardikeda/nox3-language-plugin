package com.enterscript.nox3languageplugin.language.structure

import com.enterscript.nox3languageplugin.language.X3RuleService
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.tree.IElementType

/**
 * Provides folding for blocks defined in the X3 language. Folding regions are
 * determined from [X3RuleService] block information.
 */
class NOX3FoldingBuilder : FoldingBuilderEx() {

    private val pairs: List<Pair<IElementType, IElementType>> =
        X3RuleService.blockRules()
            .filter { it.blockOpen && !it.blockPair.isNullOrBlank() }
            .mapNotNull { rule ->
                val open = findType(rule.token)
                val close = findType(rule.blockPair!!) ?: findType("END${rule.token}")
                if (open != null && close != null) open to close else null
            }

    private fun findType(name: String): IElementType? {
        return try {
            val field = NOX3Types::class.java.getField(name)
            field.get(null) as? IElementType
        } catch (_: Exception) {
            null
        }
    }

    override fun buildFoldRegions(root: ASTNode, document: Document): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        collectDescriptors(root, descriptors)
        return descriptors.toTypedArray()
    }

    private fun collectDescriptors(node: ASTNode, descriptors: MutableList<FoldingDescriptor>) {
        val pair = pairs.find { it.first == node.elementType }
        if (pair != null) {
            val end = findEndNode(node.treeNext, pair.second)
            if (end != null && end.textRange.endOffset > node.startOffset) {
                descriptors += FoldingDescriptor(node, TextRange(node.startOffset, end.textRange.endOffset))
            }
        }
        var child = node.firstChildNode
        while (child != null) {
            collectDescriptors(child, descriptors)
            child = child.treeNext
        }
    }

    private fun findEndNode(start: ASTNode?, endType: IElementType): ASTNode? {
        var current = start
        while (current != null) {
            if (current.elementType == endType) return current
            current = current.treeNext
        }
        return null
    }

    override fun getPlaceholderText(node: ASTNode): String = "..."

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}


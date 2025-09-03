package com.enterscript.nox3languageplugin.language.structure

import com.enterscript.nox3languageplugin.language.X3RuleService
import com.enterscript.nox3languageplugin.language.psi.NOX3Types
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

/**
 * Provides brace matching for block constructs of the X3 language. Pairs are
 * derived from [X3RuleService] using rules where `has_block` is `true` and
 * `block_open` is `true`.
 */
class NOX3BraceMatcher : PairedBraceMatcher {

    private val pairs: Array<BracePair>

    init {
        val list = mutableListOf<BracePair>()
        for (rule in X3RuleService.blockRules().filter { it.blockOpen && !it.blockPair.isNullOrBlank() }) {
            val open = findType(rule.token)
            val close = findType(rule.blockPair!!)
                ?: findType("END${rule.token}")
            if (open != null && close != null) {
                list += BracePair(open, close, true)
            }
        }
        pairs = list.toTypedArray()
    }

    private fun findType(name: String): IElementType? {
        return try {
            val field = NOX3Types::class.java.getField(name)
            field.get(null) as? IElementType
        } catch (_: Exception) {
            null
        }
    }

    override fun getPairs(): Array<BracePair> = pairs

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}


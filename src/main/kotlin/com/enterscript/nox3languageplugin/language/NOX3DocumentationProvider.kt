package com.enterscript.nox3languageplugin.language

import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

/**
 * Documentation provider that reads markdown help files for X3 keywords.
 */
class NOX3DocumentationProvider : DocumentationProvider {
    override fun generateDoc(element: PsiElement, originalElement: PsiElement?): String? {
        val keyword = when (element) {
            is NOX3KeywordDocElement -> element.keyword
            is LeafPsiElement -> element.text
            else -> return null
        }?.lowercase() ?: return null

        val rule = X3RuleService.ruleFor(keyword) ?: return null
        if (!rule.helpMd) return null

        val resource = "docs/$keyword.md"
        val stream = this::class.java.classLoader.getResourceAsStream(resource) ?: return null
        return stream.bufferedReader().use { it.readText() }
    }
}


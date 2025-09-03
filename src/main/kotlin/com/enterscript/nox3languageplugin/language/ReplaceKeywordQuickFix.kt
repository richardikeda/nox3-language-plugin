package com.enterscript.nox3languageplugin.language

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.SmartPointerManager
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiDocumentManager

/**
 * Quick fix replacing a deprecated or internal keyword with its suggested public equivalent.
 */
class ReplaceKeywordQuickFix(element: PsiElement, private val replacement: String) : IntentionAction {

    private val elementPointer: SmartPsiElementPointer<PsiElement> =
        SmartPointerManager.createPointer(element)

    override fun getText(): String = "Replace with '$replacement'"

    override fun getFamilyName(): String = "Replace with public keyword"

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return elementPointer.element != null
    }

    override fun startInWriteAction(): Boolean = true

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        val element = elementPointer.element ?: return
        val document = editor?.document ?: return
        val range: TextRange = element.textRange
        document.replaceString(range.startOffset, range.endOffset, replacement)
        PsiDocumentManager.getInstance(project).commitDocument(document)
    }
}

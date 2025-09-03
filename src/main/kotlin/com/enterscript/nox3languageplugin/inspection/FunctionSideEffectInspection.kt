package com.enterscript.nox3languageplugin.inspection

import com.enterscript.nox3languageplugin.language.NOX3Annotator
import com.enterscript.nox3languageplugin.language.X3FunctionService
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiTreeUtil

/**
 * Flags calls to side-effecting functions inside contexts annotated as pure.
 * A very basic heuristic is used: the inspection looks for methods annotated with
 * an annotation named `Pure` or `Contract` with `pure=true`.
 */
class FunctionSideEffectInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : JavaElementVisitor() {
            override fun visitLiteralExpression(expression: PsiLiteralExpression) {
                val value = expression.value as? String ?: return
                val prefix = NOX3Annotator.NOX3_PREFIX_STR + NOX3Annotator.NOX3_SEPARATOR_STR
                if (!value.startsWith(prefix)) return

                val callPart = value.substring(prefix.length)
                val name = callPart.substringBefore("(").trim()
                if (name.isEmpty()) return

                val info = X3FunctionService.functionInfo(name) ?: return
                if (info.sideEffects != true) return
                if (!isPureContext(expression)) return

                holder.registerProblem(
                    expression,
                    "Call to side-effecting function '$name' in pure context"
                )
            }
        }
    }

    private fun isPureContext(element: PsiElement): Boolean {
        val method = PsiTreeUtil.getParentOfType(element, PsiMethod::class.java) ?: return false
        val annotations = method.modifierList.annotations
        return annotations.any { it.qualifiedName?.endsWith(".Pure") == true } ||
            annotations.any {
                it.qualifiedName == "org.jetbrains.annotations.Contract" &&
                    it.findAttributeValue("pure")?.text == "true"
            }
    }
}

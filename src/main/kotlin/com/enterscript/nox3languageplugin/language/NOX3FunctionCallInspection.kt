package com.enterscript.nox3languageplugin.language

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiLiteralExpression

/**
 * Inspection that validates NOX3 function calls inside string literals.
 * It relies on [NOX3ReferenceContributor] to resolve function names and
 * reports unresolved or ambiguous references.
 */
class NOX3FunctionCallInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : JavaElementVisitor() {
            override fun visitLiteralExpression(expression: PsiLiteralExpression) {
                val value = expression.value as? String ?: return
                val prefix = NOX3Annotator.NOX3_PREFIX_STR + NOX3Annotator.NOX3_SEPARATOR_STR
                if (!value.startsWith(prefix)) return

                val references = expression.references.filterIsInstance<NOX3Reference>()
                if (references.isEmpty()) return

                val results = references.flatMap { it.multiResolve(false).toList() }
                when {
                    results.isEmpty() -> holder.registerProblem(expression, "Unresolved function call")
                    results.size > 1 -> holder.registerProblem(expression, "Ambiguous function call")
                }
            }
        }
    }
}

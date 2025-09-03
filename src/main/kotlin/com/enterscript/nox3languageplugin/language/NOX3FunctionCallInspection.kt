package com.enterscript.nox3languageplugin.language

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiLiteralExpression
import com.enterscript.nox3languageplugin.language.X3FunctionService
import java.util.regex.Pattern

/** Regex to parse function calls like name(arg1,arg2) */
private val CALL_PATTERN: Pattern = Pattern.compile("([A-Za-z_][A-Za-z0-9_]*)\\s*(?:\\((.*)\\))?")

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

                val callPart = value.substring(prefix.length)
                val matcher = CALL_PATTERN.matcher(callPart)
                if (!matcher.matches()) return
                val name = matcher.group(1)
                val argsText = matcher.group(2) ?: ""
                val argCount = if (argsText.isBlank()) 0 else argsText.split(',').size

                val info = X3FunctionService.functionInfo(name)

                val references = expression.references.filterIsInstance<NOX3Reference>()
                if (references.isNotEmpty()) {
                    val results = references.flatMap { it.multiResolve(false).toList() }
                    when {
                        results.isEmpty() -> holder.registerProblem(expression, "Unresolved function call")
                        results.size > 1 -> holder.registerProblem(expression, "Ambiguous function call")
                    }
                }

                info?.arityMin?.let { min ->
                    if (argCount < min) {
                        holder.registerProblem(
                            expression,
                            "Too few arguments for $name (minimum $min)"
                        )
                    }
                }
                info?.arityMax?.let { max ->
                    if (argCount > max) {
                        holder.registerProblem(
                            expression,
                            "Too many arguments for $name (maximum $max)"
                        )
                    }
                }
            }
        }
    }
}

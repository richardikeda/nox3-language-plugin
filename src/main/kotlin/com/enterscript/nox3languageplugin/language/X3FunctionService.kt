package com.enterscript.nox3languageplugin.language

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Service providing function metadata such as side effects and arity information.
 */
object X3FunctionService {
    data class FunctionInfo(
        val sideEffects: Boolean?,
        val arityMin: Int?,
        val arityMax: Int?
    )

    private val functions: Map<String, FunctionInfo> by lazy { loadFunctionInfos() }

    fun functionInfo(name: String): FunctionInfo? = functions[name.uppercase()]

    private fun loadFunctionInfos(): Map<String, FunctionInfo> {
        val path = Paths.get("x3_language_rules.csv")
        if (!Files.exists(path)) return emptyMap()
        return Files.newBufferedReader(path).useLines { lines ->
            lines.drop(1).mapNotNull { line ->
                val parts = line.split(",", limit = 19)
                if (parts.size < 18) return@mapNotNull null
                val token = parts[0].trim()
                val sideEffectsText = parts[14].trim()
                val sideEffects = when {
                    sideEffectsText.equals("YES", ignoreCase = true) -> true
                    sideEffectsText.equals("NO", ignoreCase = true) -> false
                    else -> null
                }
                val arityMin = parts.getOrNull(16)?.trim()?.toIntOrNull()
                val arityMax = parts.getOrNull(17)?.trim()?.toIntOrNull()
                token.uppercase() to FunctionInfo(sideEffects, arityMin, arityMax)
            }.toMap()
        }
    }
}

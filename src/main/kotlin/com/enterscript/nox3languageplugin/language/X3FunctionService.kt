package com.enterscript.nox3languageplugin.language

/**
 * Service providing function metadata such as side effects and arity information.
 */
object X3FunctionService {
    data class FunctionInfo(
        val sideEffects: Boolean?,
        val arityMin: Int?,
        val arityMax: Int?
    )

    private val functions: Map<String, FunctionInfo> by lazy {
        KeywordDefinitions.entries.values
            .filter { it.family == KeywordFamily.FUNCTION }
            .associate { def ->
                def.token.uppercase() to FunctionInfo(def.sideEffects, def.arityMin, def.arityMax)
            }
    }

    fun functionInfo(name: String): FunctionInfo? = functions[name.uppercase()]
}

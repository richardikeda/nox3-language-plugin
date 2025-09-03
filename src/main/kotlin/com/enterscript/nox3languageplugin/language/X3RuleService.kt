package com.enterscript.nox3languageplugin.language

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Service loading X3 language rule information from the CSV file shipped with the plugin.
 * Only a very small subset of columns is required by the consumers. The service exposes
 * rules where [hasBlock] is true so clients can determine matching token pairs.
 */
object X3RuleService {
    data class Rule(
        val token: String,
        val hasBlock: Boolean,
        val blockOpen: Boolean,
        val blockClose: Boolean,
        val blockMiddle: Boolean,
        val blockPair: String?
    )

    private val rules: List<Rule> by lazy { loadRules() }

    /**
     * Returns all rules that represent block constructs in the language.
     */
    fun blockRules(): List<Rule> = rules.filter { it.hasBlock }

    private fun loadRules(): List<Rule> {
        val path = Paths.get("x3_language_rules.csv")
        if (!Files.exists(path)) return emptyList()
        return Files.newBufferedReader(path).useLines { lines ->
            lines.drop(1).mapNotNull { line ->
                // We only need the first 13 columns.
                val parts = line.split(",", limit = 14)
                if (parts.size < 13) return@mapNotNull null
                Rule(
                    token = parts[0].trim(),
                    hasBlock = parts[8].trim().equals("true", ignoreCase = true),
                    blockOpen = parts[9].trim().equals("true", ignoreCase = true),
                    blockClose = parts[10].trim().equals("true", ignoreCase = true),
                    blockMiddle = parts[11].trim().equals("true", ignoreCase = true),
                    blockPair = parts[12].trim().ifEmpty { null }
                )
            }.toList()
        }
    }
}


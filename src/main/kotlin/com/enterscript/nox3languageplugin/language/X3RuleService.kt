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

    enum class KeywordStatus {
        Public,
        Internal,
        Deprecated,
        DeprecatedClassic,
        Unknown
    }

    data class KeywordInfo(val status: KeywordStatus, val replacement: String?)

    private val keywordInfos: Map<String, KeywordInfo> by lazy { loadKeywordStatuses() }

    /**
     * Returns all rules that represent block constructs in the language.
     */
    fun blockRules(): List<Rule> = rules.filter { it.hasBlock }

    fun keywordInfo(token: String): KeywordInfo? = keywordInfos[token.lowercase()]

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

    private fun loadKeywordStatuses(): Map<String, KeywordInfo> {
        val path = Paths.get("x3_keywords_status.csv")
        if (!Files.exists(path)) return emptyMap()
        return Files.newBufferedReader(path).useLines { lines ->
            lines.drop(1).mapNotNull { line ->
                val parts = line.split(',', limit = 2)
                if (parts.size < 2) return@mapNotNull null
                val keyword = parts[0].trim().lowercase()
                val statusText = parts[1].trim().trim('"')
                val status = when {
                    statusText.startsWith("Public", ignoreCase = true) -> KeywordStatus.Public
                    statusText.startsWith("Internal", ignoreCase = true) -> KeywordStatus.Internal
                    statusText.startsWith("Deprecated Classic", ignoreCase = true) ||
                        statusText.startsWith("DeprecatedClassic", ignoreCase = true) -> KeywordStatus.DeprecatedClassic
                    statusText.startsWith("Deprecated", ignoreCase = true) -> KeywordStatus.Deprecated
                    else -> KeywordStatus.Unknown
                }
                val replacement = Regex("replaced by \\[(\\w+)\\]").find(statusText)?.groupValues?.get(1)
                keyword to KeywordInfo(status, replacement)
            }.toMap()
        }
    }
}


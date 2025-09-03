package com.enterscript.nox3languageplugin.language

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Service loading X3 language rule information from the CSV files shipped with the plugin.
 * Consumers can query keyword metadata such as family, status and documentation availability.
 */
object X3RuleService {

    enum class KeywordFamily {
        FUNCTION,
        INSTRUCTION,
        SYSVAR,
        UNKNOWN
    }

    enum class KeywordStatus {
        Public,
        New,
        Internal,
        Deprecated,
        DeprecatedClassic,
        Unknown
    }

    data class Rule(
        val token: String,
        val family: KeywordFamily,
        val hasBlock: Boolean,
        val blockOpen: Boolean,
        val blockClose: Boolean,
        val blockMiddle: Boolean,
        val blockPair: String?,
        val helpMd: Boolean
    )

    private val rules: List<Rule> by lazy { loadRules() }

    data class KeywordInfo(val status: KeywordStatus, val replacement: String?)

    private val keywordInfos: Map<String, KeywordInfo> by lazy { loadKeywordStatuses() }

    data class GlossaryEntry(
        val token: String,
        val family: KeywordFamily,
        val status: KeywordStatus,
        val helpMd: Boolean
    )

    /**
     * Returns all rules that represent block constructs in the language.
     */
    fun blockRules(): List<Rule> = rules.filter { it.hasBlock }

    fun keywordInfo(token: String): KeywordInfo? = keywordInfos[token.lowercase()]

    fun ruleFor(token: String): Rule? = rules.firstOrNull { it.token.equals(token, ignoreCase = true) }

    fun glossary(): List<GlossaryEntry> =
        rules.map { rule ->
            val status = keywordInfo(rule.token)?.status ?: KeywordStatus.Unknown
            GlossaryEntry(rule.token, rule.family, status, rule.helpMd)
        }

    private fun loadRules(): List<Rule> {
        val path = Paths.get("x3_language_rules.csv")
        if (!Files.exists(path)) return emptyList()
        val splitter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex()
        return Files.newBufferedReader(path).useLines { lines ->
            lines.drop(1).mapNotNull { line ->
                val parts = line.split(splitter)
                if (parts.size < 19) return@mapNotNull null
                Rule(
                    token = parts[0].trim(),
                    family = when (parts[2].trim().uppercase()) {
                        "FUNCTION" -> KeywordFamily.FUNCTION
                        "INSTRUCTION" -> KeywordFamily.INSTRUCTION
                        "SYSVAR" -> KeywordFamily.SYSVAR
                        else -> KeywordFamily.UNKNOWN
                    },
                    hasBlock = parts[8].trim().equals("true", ignoreCase = true),
                    blockOpen = parts[9].trim().equals("true", ignoreCase = true),
                    blockClose = parts[10].trim().equals("true", ignoreCase = true),
                    blockMiddle = parts[11].trim().equals("true", ignoreCase = true),
                    blockPair = parts[12].trim().ifEmpty { null },
                    helpMd = parts[18].trim().equals("true", ignoreCase = true)
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
                    statusText.startsWith("New", ignoreCase = true) -> KeywordStatus.New
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


package com.enterscript.nox3languageplugin.language

/**
 * Service providing X3 language rule information from in-memory definitions.
 * Consumers can query keyword metadata such as family, status and documentation availability.
 */
object X3RuleService {

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

    data class KeywordInfo(val status: KeywordStatus, val replacement: String?)

    data class GlossaryEntry(
        val token: String,
        val family: KeywordFamily,
        val status: KeywordStatus,
        val helpMd: Boolean
    )

    private val rules: List<Rule> by lazy {
        KeywordDefinitions.entries.values.map { def ->
            Rule(
                token = def.token,
                family = def.family,
                hasBlock = def.hasBlock,
                blockOpen = def.blockOpen,
                blockClose = def.blockClose,
                blockMiddle = def.blockMiddle,
                blockPair = def.blockPair,
                helpMd = def.helpMd
            )
        }
    }

    private val keywordInfos: Map<String, KeywordInfo> by lazy {
        KeywordDefinitions.entries.mapValues { (_, def) ->
            KeywordInfo(def.status, def.replacement)
        }
    }

    /**
     * Returns all rules that represent block constructs in the language.
     */
    fun blockRules(): List<Rule> = rules.filter { it.hasBlock }

    fun keywordInfo(token: String): KeywordInfo? = keywordInfos[token.lowercase()]

    fun ruleFor(token: String): Rule? = rules.firstOrNull { it.token.equals(token, ignoreCase = true) }

    fun glossary(): List<GlossaryEntry> =
        rules.map { rule ->
            val status = keywordInfos[rule.token.lowercase()]?.status ?: KeywordStatus.Unknown
            GlossaryEntry(rule.token, rule.family, status, rule.helpMd)
        }
}

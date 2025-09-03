package com.enterscript.nox3languageplugin.grammar

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.io.path.writeText

private data class X3Rule(
    val token: String,
    val reserved: Boolean,
    val hasBlock: Boolean,
    val blockOpen: Boolean,
    val blockClose: Boolean,
    val blockMiddle: Boolean,
    val blockPair: String?
)

private object X3RuleService {
    fun load(file: Path): List<X3Rule> {
        val lines = file.readLines().filter { it.isNotBlank() }
        // skip two header lines
        return lines.drop(2).mapNotNull { line ->
            val parts = line.split(',')
            if (parts.size < 13) return@mapNotNull null
            X3Rule(
                token = parts[0],
                reserved = parts[5].equals("true", true),
                hasBlock = parts[8].equals("true", true),
                blockOpen = parts[9].equals("true", true),
                blockClose = parts[10].equals("true", true),
                blockMiddle = parts[11].equals("true", true),
                blockPair = parts[12].ifBlank { null }
            )
        }
    }
}

abstract class GenerateGrammarTask : DefaultTask() {
    @get:org.gradle.api.tasks.InputFile
    val rulesFile = project.layout.projectDirectory.file("x3_language_rules.csv")

    @get:org.gradle.api.tasks.OutputFile
    val flexFile = project.layout.projectDirectory.file("src/main/grammars/NOX3.flex")

    @get:org.gradle.api.tasks.OutputFile
    val bnfFile = project.layout.projectDirectory.file("src/main/grammars/NOX3.bnf")

    @TaskAction
    fun generate() {
        val rules = X3RuleService.load(rulesFile.asFile.toPath())
        val reserved = rules.filter { it.reserved }
        generateFlex(flexFile.asFile.toPath(), reserved)
        generateBnf(bnfFile.asFile.toPath(), reserved)
    }

    private fun sanitize(token: String) =
        token.uppercase().replace(Regex("[^A-Z0-9_]+"), "_")

    private fun jflexEscape(literal: String): String {
        val sb = StringBuilder()
        literal.forEach { ch ->
            when (ch) {
                '\\', '[', ']', '(', ')', '{', '}', '.', '?', '+', '*', '|', '^', '$' -> {
                    sb.append('\\').append(ch)
                }
                ' ' -> sb.append("\\ ")
                else -> sb.append(ch)
            }
        }
        return sb.toString()
    }

    private fun generateFlex(path: Path, rules: List<X3Rule>) {
        val tokens = rules.map { sanitize(it.token) to it.token }.distinct().sortedBy { it.first }
        val builder = StringBuilder()
        builder.appendLine("package com.enterscript.nox3languageplugin.language.lexer;")
        builder.appendLine()
        builder.appendLine("import com.intellij.lexer.FlexLexer;")
        builder.appendLine("import com.intellij.psi.tree.IElementType;")
        builder.appendLine("import com.enterscript.nox3languageplugin.language.psi.NOX3Types;")
        builder.appendLine("import com.intellij.psi.TokenType;")
        builder.appendLine()
        builder.appendLine("%%")
        builder.appendLine()
        builder.appendLine("%class NOX3Lexer")
        builder.appendLine("%implements FlexLexer")
        builder.appendLine("%unicode")
        builder.appendLine("%function advance")
        builder.appendLine("%type IElementType")
        builder.appendLine("%eof{  return;")
        builder.appendLine("%eof}")
        builder.appendLine()
        builder.appendLine("CRLF=\\R")
        builder.appendLine("WHITE_SPACE=[\\ \\t\\f]")
        builder.appendLine("IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*")
        builder.appendLine("NUMBER=[0-9]+")
        builder.appendLine("""STRING=\"[^\"]*\"""")
        builder.appendLine("""COMMENT="#"[^\n]*""")
        builder.appendLine()
        tokens.forEach { (name, value) ->
            val pattern = jflexEscape(value)
            builder.appendLine("$name=(?i:$pattern)")
        }
        builder.appendLine()
        builder.appendLine("%%")
        builder.appendLine()
        builder.appendLine("{WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }")
        builder.appendLine("{CRLF}        { return NOX3Types.CRLF; }")
        builder.appendLine("{COMMENT}     { return NOX3Types.COMMENT; }")
        builder.appendLine()
        tokens.forEach { (name, _) ->
            builder.appendLine("{$name}          { return NOX3Types.$name; }")
        }
        builder.appendLine()
        builder.appendLine("\"=\"           { return NOX3Types.SEPARATOR; }")
        builder.appendLine("{STRING}      { return NOX3Types.STRING; }")
        builder.appendLine("{NUMBER}      { return NOX3Types.NUMBER; }")
        builder.appendLine("{IDENTIFIER}  { return NOX3Types.IDENTIFIER; }")
        builder.appendLine()
        builder.appendLine("[^]           { return TokenType.BAD_CHARACTER; }")
        path.writeText(builder.toString())
    }

    private fun generateBnf(path: Path, rules: List<X3Rule>) {
        val tokenNames = rules.map { sanitize(it.token) }.distinct().sorted()
        val builder = StringBuilder()
        builder.appendLine("{")
        builder.appendLine("  parserClass=\"com.enterscript.nox3languageplugin.language.psi.impl.parser.NOX3Parser\"")
        builder.appendLine()
        builder.appendLine("  extends=\"com.intellij.extapi.psi.ASTWrapperPsiElement\"")
        builder.appendLine()
        builder.appendLine("  psiClassPrefix=\"NOX3\"")
        builder.appendLine("  psiImplClassSuffix=\"Impl\"")
        builder.appendLine("  psiPackage=\"com.enterscript.nox3languageplugin.language.psi\"")
        builder.appendLine("  psiImplPackage=\"com.enterscript.nox3languageplugin.language.psi.impl\"")
        builder.appendLine()
        builder.appendLine("  elementTypeHolderClass=\"com.enterscript.nox3languageplugin.language.psi.NOX3Types\"")
        builder.appendLine("  elementTypeClass=\"com.enterscript.nox3languageplugin.language.psi.NOX3ElementType\"")
        builder.appendLine("  tokenTypeClass=\"com.enterscript.nox3languageplugin.language.psi.NOX3TokenType\"")
        builder.appendLine()
        builder.appendLine("  psiImplUtilClass=\"com.enterscript.nox3languageplugin.language.psi.impl.NOX3PsiImplUtil\"")
        builder.appendLine("}")
        builder.appendLine()
        builder.appendLine("tokens = [")
        builder.appendLine("  CRLF")
        builder.appendLine("  COMMENT")
        builder.appendLine("  STRING")
        builder.appendLine("  NUMBER")
        builder.appendLine("  IDENTIFIER")
        builder.appendLine("  SEPARATOR")
        tokenNames.forEach { builder.appendLine("  $it") }
        builder.appendLine("]")
        builder.appendLine()
        // block rules
        val openBlocks = rules.filter { it.hasBlock && it.blockOpen }
        val blockMiddles = rules.filter { it.hasBlock && it.blockMiddle }.groupBy { it.blockPair }
        builder.append("file ::= element_*\n\n")
        builder.append("private element_ ::= (property")
        openBlocks.forEach { builder.append(" | ${sanitize(it.token).lowercase()}_block") }
        builder.append(" | COMMENT | CRLF)\n\n")
        builder.append(
            "property ::= IDENTIFIER SEPARATOR value {\n" +
                "    mixin=\"com.enterscript.nox3languageplugin.language.psi.impl.NOX3NamedElementImpl\"\n" +
                "    implements=\"com.enterscript.nox3languageplugin.language.psi.NOX3NamedElement\"\n" +
                "    methods=[getKey getValue getName setName getNameIdentifier]\n" +
                "}\n\n"
        )
        openBlocks.forEach { rule ->
            val ruleName = sanitize(rule.token).lowercase() + "_block"
            val open = sanitize(rule.token)
            val close = sanitize(rule.blockPair ?: rule.token)
            val middles = blockMiddles[rule.token]?.map { sanitize(it.token) } ?: emptyList()
            builder.append("$ruleName ::= $open element_*")
            middles.forEach { middle ->
                builder.append(" ($middle element_*)?")
            }
            builder.append(" $close\n\n")
        }
        builder.append("value ::= expression\n\n")
        builder.append("function_call ::= (IDENTIFIER | PRINT | LEN | SQRT) '(' expression? ')'\n\n")
        builder.append("expression ::= NUMBER | STRING | IDENTIFIER | USER | SYSDATE | function_call\n")
        path.writeText(builder.toString())
    }
}

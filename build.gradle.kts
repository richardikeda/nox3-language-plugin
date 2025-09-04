import org.jetbrains.changelog.Changelog
import org.jetbrains.grammarkit.tasks.GenerateLexer
import org.jetbrains.grammarkit.tasks.GenerateParser

fun properties(key: String) = project.findProperty(key).toString()

plugins {
    id("java")
    alias(libs.plugins.kotlin)
    id("org.jetbrains.intellij.platform")
    alias(libs.plugins.changelog)
    alias(libs.plugins.qodana)
    alias(libs.plugins.kover)
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.opentest4j)
    intellijPlatform {
        create(type = properties("platformType"), version = properties("platformVersion"))
        intellijPlugin(properties("platformPlugins"))
    }
}

sourceSets {
    main {
        java.srcDir(layout.buildDirectory.dir("gen"))
        kotlin.srcDir("build/gen")
    }
}

val generateNox3Lexer by tasks.registering(GenerateLexer::class) {
    sourceFile.set(file("src/main/grammars/NOX3.flex"))
    targetOutputDir.set(layout.buildDirectory.dir("gen"))
    purgeOldFiles.set(true)
}

val generateNox3Parser by tasks.registering(GenerateParser::class) {
    sourceFile.set(file("src/main/grammars/NOX3.bnf"))
    targetRootOutputDir.set(layout.buildDirectory.dir("gen"))
    pathToParser.set("com/enterscript/nox3languageplugin/language/parser/NOX3Parser")
    pathToPsiRoot.set("com/enterscript/nox3languageplugin/language/psi")
    purgeOldFiles.set(true)
}

changelog {
    version.set(project.version.toString())
    path.set(file("CHANGELOG.md").absolutePath)
    header.set(project.version.toString())
    itemPrefix.set("*")
    lineSeparator.set("\n")
    groups.set(emptyList())
    repositoryUrl.set("https://github.com/richardikeda/nox3-language-plugin")
}

intellijPlatform {
    pluginConfiguration {
        name = properties("pluginName")
        version = properties("pluginVersion")
        val changelog = project.changelog
        changeNotes = provider {
            changelog.renderItem(changelog.getLatest(), Changelog.OutputType.HTML)
        }
    }
    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }
    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }
}

qodana {
    projectPath.set(projectDir.absolutePath)
    cachePath.set(layout.projectDirectory.dir(".qodana").asFile.absolutePath)
    resultsPath.set(layout.buildDirectory.dir("qodana").map { it.asFile.absolutePath })
}

kover {
    reports {
        total {
            html {
                onCheck.set(true)
            }
            xml {
                onCheck.set(true)
                xmlFile.set(layout.buildDirectory.file("reports/kover/report.xml"))
            }
        }
    }
}

tasks {
    compileKotlin {
        dependsOn(generateNox3Lexer, generateNox3Parser)
    }

    named("verifyPlugin") {
        dependsOn("test")
    }
}

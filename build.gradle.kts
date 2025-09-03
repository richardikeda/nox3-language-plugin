import org.jetbrains.changelog.Changelog
import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.grammarkit.tasks.GenerateLexerTask
import org.jetbrains.grammarkit.tasks.GenerateParserTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun properties(key: String) = project.findProperty(key).toString()

plugins {
    id("java")
    alias(libs.plugins.kotlin)
    alias(libs.plugins.intelliJPlatform)
    alias(libs.plugins.changelog)
    alias(libs.plugins.qodana)
    alias(libs.plugins.kover)
    alias(libs.plugins.grammarkit)
}

group = properties("pluginGroup")
version = properties("pluginVersion")

kotlin {
    jvmToolchain(21)
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
        create(properties("platformType"), properties("platformVersion"))
        plugins(
            providers.gradleProperty("platformPlugins").map {
                it.split(',').map(String::trim).filter(String::isNotEmpty)
            }
        )
        bundledPlugins(
            providers.gradleProperty("platformBundledPlugins").map {
                it.split(',').map(String::trim).filter(String::isNotEmpty)
            }
        )
        bundledModules(
            providers.gradleProperty("platformBundledModules").map {
                it.split(',').map(String::trim).filter(String::isNotEmpty)
            }
        )
        testFramework(TestFrameworkType.Platform)
    }
}

sourceSets["main"].kotlin.srcDir("build/gen")

val generateNOX3Lexer by tasks.registering(GenerateLexerTask::class) {
    sourceFile.set(file("src/main/grammars/NOX3.flex"))
    targetOutputDir.set(layout.buildDirectory.dir("gen/com/enterscript/nox3languageplugin/language/lexer"))
    purgeOldFiles.set(true)
}

val generateNOX3Parser by tasks.registering(GenerateParserTask::class) {
    sourceFile.set(file("src/main/grammars/NOX3.bnf"))
    targetRootOutputDir.set(layout.buildDirectory.dir("gen"))
    pathToParser.set("com/enterscript/nox3languageplugin/language/psi/impl/parser/NOX3Parser")
    pathToPsiRoot.set("com/enterscript/nox3languageplugin/language/psi")
    purgeOldFiles.set(true)
}

tasks.withType<KotlinCompile>().configureEach {
    dependsOn(generateNOX3Lexer, generateNOX3Parser)
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
    named("verifyPlugin") {
        dependsOn("test")
    }
}

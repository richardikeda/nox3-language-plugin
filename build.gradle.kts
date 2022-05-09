import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


fun properties(key: String) = project.findProperty(key).toString()

plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    // gradle-intellij-plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
    id("org.jetbrains.intellij") version "1.5.3"
    // gradle-changelog-plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
    id("org.jetbrains.changelog") version "1.3.1"
    // Gradle Qodana Plugin
    id("org.jetbrains.qodana") version "0.1.13"
    //https://github.com/JetBrains/gradle-grammar-kit-plugin
    id("org.jetbrains.grammarkit") version "2021.2.2"

}

group = properties("pluginGroup")
version = properties("pluginVersion")

// Configure project's dependencies
repositories {
    mavenCentral()

}
dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}
// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    version.set(properties("pluginVersion"))
    groups.set(emptyList())
}

// Configure Gradle Qodana Plugin - read more: https://github.com/JetBrains/gradle-qodana-plugin
qodana {
    cachePath.set(projectDir.resolve(".qodana").canonicalPath)
    reportPath.set(projectDir.resolve("build/reports/inspections").canonicalPath)
    saveReport.set(true)
    showReport.set(System.getenv("QODANA_SHOW_REPORT")?.toBoolean() ?: false)
}

grammarKit {
    // Version of IntelliJ patched JFlex (see the link below), Default is 1.7.0-1
    jflexRelease.set("1.7.0-1")

    // Release version, tag, or short commit hash of Grammar-Kit to use (see link below). Default is 2021.1.2
    grammarKitRelease.set("2021.1.2")

    // Optionally provide an IntelliJ version to build the classpath for GenerateParser/GenerateLexer tasks
    intellijRelease.set("203.7717.81")
}

tasks {
    // Set the JVM compatibility versions
    properties("javaVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = JavaVersion.VERSION_11.toString()
            targetCompatibility = JavaVersion.VERSION_11.toString()


        }
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
        }


    }
    withType<JavaExec>{
        jvmArgs(
            "--add-exports=java.base/jdk.internal.vm=ALL-UNNAMED",
            "--illegal-access=permit"
        )
    }



    wrapper {
        gradleVersion = properties("gradleVersion")
    }


    generateLexer {
        // source flex file
        source.set("grammar/NOX3.flex")

        // target directory for lexer
        targetDir.set("gen/com/enterscript/noX3LanguagePlugin/lexer")

        // target classname, target file will be targetDir/targetClass.java
        targetClass.set("NOX3Lexer")

        // optional, path to the task-specific skeleton file. Default: none
        //skeleton.set("/some/specific/skeleton")

        // if set, plugin will remove a lexer output file before generating new one. Default: false
        //purgeOldFiles.set(false)
    }

    generateParser {
        // source bnf file
        source.set("grammar/NOX3.bnf")

        // optional, task-specific root for the generated files. Default: none
        targetRoot.set("gen")

        // path to a parser file, relative to the targetRoot
        pathToParser.set("/com/enterscript/noX3LanguagePlugin/parser/X3ParserGenerated.java")

        // path to a directory with generated psi files, relative to the targetRoot
        pathToPsiRoot.set("/com/enterscript/noX3LanguagePlugin/language/psi")

        // if set, the plugin will remove a parser output file and psi output directory before generating new ones. Default: false
        purgeOldFiles.set(false)
    }

    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription.set(
            projectDir.resolve("README.md").readText().lines().run {
                val start = "<!-- Plugin description -->"
                val end = "<!-- Plugin description end -->"

                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end))
            }.joinToString("\n").run { markdownToHTML(this) }
        )

        // Get the latest available change notes from the changelog file
        changeNotes.set(provider {
            changelog.run {
                getOrNull(properties("pluginVersion")) ?: getLatest()
            }.toHTML()
        })
    }

    // Configure UI tests plugin
    // Read more: https://github.com/JetBrains/intellij-ui-test-robot
    runIdeForUiTests {
        systemProperty("robot-server.port", "8082")
        systemProperty("ide.mac.message.dialogs.as.sheets", "false")
        systemProperty("jb.privacy.policy.text", "<!--999.999-->")
        systemProperty("jb.consents.confirmation.enabled", "false")

    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token.set(System.getenv("PUBLISH_TOKEN"))
        // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels.set(listOf(properties("pluginVersion").split('-').getOrElse(1) { "default" }.split('.').first()))
    }
}

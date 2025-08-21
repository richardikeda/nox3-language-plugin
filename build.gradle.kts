// build.gradle.kts ATUALIZADO
import org.jetbrains.changelog.markdownToHTML

// As versões dos plugins foram atualizadas para as mais recentes e estáveis.
plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    id("org.jetbrains.intellij") version "1.17.2"
    id("org.jetbrains.changelog") version "2.2.0"
}

group = "com.enterscript"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

// Bloco Kotlin agora usa jvmToolchain para garantir que o JDK 17 seja usado.
// Isso corrige o erro de compilação original.
kotlin {
    jvmToolchain(17)
}

// Configure IntelliJ Platform plugin
// A versão do IntelliJ foi atualizada.
intellij {
    pluginName.set("nox3-language-plugin")
    version.set("2023.3.6") // Versão estável e recente do IntelliJ
    type.set("IC") // IC para Community Edition

    // Dependências de plugins (se houver)
    plugins.set(listOf(/* Adicione aqui se o seu plugin depender de outros, ex: "com.intellij.java" */))
}

// Configure Changelog plugin
changelog {
    version.set(project.version.toString())
    path.set(file("CHANGELOG.md").absolutePath)
    // A configuração do changelog foi mantida como estava no seu projeto.
    header.set(project.version.toString())
    itemPrefix.set("*")
    keepFutureVersions.set(true)
    lineSeparator.set("\n")
    unstyledLinks.set(false)
    groups.set(emptyList())
    repositoryUrl.set("https://github.com/richardikeda/nox3-language-plugin")
}

tasks {
    // A configuração explícita do jvmTarget não é mais necessária aqui,
    // pois estamos usando jvmToolchain no bloco kotlin {}.

    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    patchPluginXml {
        // As versões since/until agora são derivadas automaticamente da versão do IntelliJ
        // definida no bloco intellij {}. É mais seguro e menos propenso a erros.
        changeNotes.set(provider {
            changelog.get().toHTML()
        })
    }

    // O restante das suas tarefas (runIdeForUiTests, signPlugin, etc.) foi mantido.
    runIdeForUiTests {
        systemProperty("robot-server.port", "8082")
        systemProperty("ide.mac.message.dialogs.as.sheets", "false")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
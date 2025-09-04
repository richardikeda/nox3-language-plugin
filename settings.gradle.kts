import org.jetbrains.intellij.platform.gradle.extensions.IntelliJPlatformRepositoriesExtension
import org.jetbrains.intellij.platform.gradle.extensions.intellijPlatform

IntelliJPlatformRepositoriesExtension.register(settings, settings.pluginManagement.repositories)

pluginManagement {
    repositories {
        mavenCentral()
        intellijPlatform {
            releases()
            marketplace()
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        intellijPlatform {
            releases()
            marketplace()
        }
    }
}

plugins {
    id("org.jetbrains.intellij.platform") version "2.7.2"
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "nox3-language-plugin"

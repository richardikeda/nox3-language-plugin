import org.jetbrains.intellij.platform.gradle.extensions.IntelliJPlatformRepositoriesExtension
import org.jetbrains.intellij.platform.gradle.extensions.intellijPlatform
import org.gradle.api.initialization.resolve.RepositoriesMode

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
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
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

# nox3-language

![Build](https://github.com/richardikeda/nox3-language-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/com.enterscript.nox3language.svg)](https://plugins.jetbrains.com/plugin/com.enterscript.nox3language)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.enterscript.nox3language.svg)](https://plugins.jetbrains.com/plugin/com.enterscript.nox3language)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This is a new plugin for the IntelliJ Platform to allow working with X3-Language (L4J) for ERP Sage X3.

#### This is not an official plugin, it is an independent development based on the X3 plugin for Sage ERP.

Everyone can contribute.

In the future we will implement:

- A way to generate "com.example.x3.language" packages
- Function and call verification
- An unofficial way of working with code versions of .src on X3.
- Dark theme
- AutoComplete of classes, functions, subprogs, and references.

When there is a stable version, the plugin will be published.

Thanks for your contributions!

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "nox3-language"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/richardikeda/nox3-language-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---

Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

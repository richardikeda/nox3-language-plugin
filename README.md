# nox3-language

![Build](https://github.com/richardikeda/nox3-language-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/com.enterscript.nox3languageplugin.svg)](https://plugins.jetbrains.com/plugin/com.enterscript.nox3languageplugin)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.enterscript.nox3languageplugin.svg)](https://plugins.jetbrains.com/plugin/com.enterscript.nox3languageplugin)

<!-- Plugin description -->
nox3-language is an IntelliJ Platform plugin that adds support for X3-Language (4GL) used in Sage ERP X3.

#### This is not an official plugin; it is an independent development based on the X3 plugin for Sage ERP.

Everyone can contribute.

In the future we will implement:

- A way to generate `com.enterscript.nox3languageplugin` packages
- Function and call verification
- An unofficial way of working with code versions of .src on X3.
- Dark theme
- AutoComplete of classes, functions, subprogs, and references.

The plugin is available on the [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/com.enterscript.nox3languageplugin).

Thanks for your contributions!

<!-- Plugin description end -->

## Build

This project requires **JDK 17**. The Gradle wrapper is configured for Gradle
8.14 and will download it automatically. To compile and run the tests locally:

```bash
./gradlew build
```

The produced plugin distribution is available under `build/distributions`.

## Release

The release workflow relies on the GitHub secrets `PUBLISH_TOKEN`,
`CERTIFICATE_CHAIN`, `PRIVATE_KEY`, and `PRIVATE_KEY_PASSWORD`. Multi-line
values like `CERTIFICATE_CHAIN` and `PRIVATE_KEY` must be stored in Base64
format. To encode a file before adding it as a secret, run:

```bash
base64 -w0 path/to/yourfile > encoded.txt
```

Copy the single-line output and use it as the secret value. The workflow will
decode the values and supply them to the `signPlugin` and `publishPlugin`
tasks.

## Contributing

Before contributing, please read the [CONTRIBUTING](CONTRIBUTING.md) guide and our [CODE_OF_CONDUCT](CODE_OF_CONDUCT.md).

## License

This project is licensed under the terms of the [Apache License 2.0](LICENSE).


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

package com.enterscript.nox3languageplugin.language.psi

interface NOX3Property : NOX3NamedElement {
    fun getKey(): String?
    fun getValue(): String?
}

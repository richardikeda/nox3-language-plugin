package com.enterscript.noX3LanguagePlugin.language

import com.intellij.lang.Language

class  NOX3Language private constructor() : Language("X3") {
    companion object {
        @JvmField
        val INSTANCE  = NOX3Language()
    }

}



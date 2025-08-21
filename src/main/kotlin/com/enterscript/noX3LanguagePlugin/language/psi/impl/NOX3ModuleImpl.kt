package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Module
import com.intellij.lang.ASTNode

class NOX3ModuleImpl(node: ASTNode) : NOX3NamedElementImpl(node), NOX3Module

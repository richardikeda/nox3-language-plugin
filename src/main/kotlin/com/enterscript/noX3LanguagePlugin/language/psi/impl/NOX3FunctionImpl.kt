package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Function
import com.intellij.lang.ASTNode

class NOX3FunctionImpl(node: ASTNode) : NOX3NamedElementImpl(node), NOX3Function

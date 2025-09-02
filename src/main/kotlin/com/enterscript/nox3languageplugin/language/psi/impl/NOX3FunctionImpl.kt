package com.enterscript.nox3languageplugin.language.psi.impl

import com.enterscript.nox3languageplugin.language.psi.NOX3Function
import com.intellij.lang.ASTNode

class NOX3FunctionImpl(node: ASTNode) : NOX3NamedElementImpl(node), NOX3Function

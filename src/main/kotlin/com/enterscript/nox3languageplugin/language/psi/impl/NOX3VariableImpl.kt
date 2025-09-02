package com.enterscript.nox3languageplugin.language.psi.impl

import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.intellij.lang.ASTNode

class NOX3VariableImpl(node: ASTNode) : NOX3NamedElementImpl(node), NOX3Variable

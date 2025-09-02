package com.enterscript.nox3languageplugin.language.psi.impl

import com.enterscript.nox3languageplugin.language.psi.NOX3Module
import com.intellij.lang.ASTNode

class NOX3ModuleImpl(node: ASTNode) : NOX3NamedElementImpl(node), NOX3Module

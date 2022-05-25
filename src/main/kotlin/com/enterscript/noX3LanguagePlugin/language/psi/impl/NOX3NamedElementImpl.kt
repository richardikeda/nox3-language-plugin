package com.enterscript.noX3LanguagePlugin.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3NamedElement


 abstract class NOX3NamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
     NOX3NamedElement
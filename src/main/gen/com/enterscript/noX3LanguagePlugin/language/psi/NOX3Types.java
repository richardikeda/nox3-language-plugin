// This is a generated file. Not intended for manual editing.
package com.enterscript.noX3LanguagePlugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.enterscript.noX3LanguagePlugin.language.psi.impl.*;

public interface NOX3Types {

  IElementType PROPERTY = new NOX3ElementType("PROPERTY");

  IElementType COMMENT = new NOX3TokenType("COMMENT");
  IElementType CRLF = new NOX3TokenType("CRLF");
  IElementType KEY = new NOX3TokenType("KEY");
  IElementType SEPARATOR = new NOX3TokenType("SEPARATOR");
  IElementType VALUE = new NOX3TokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new NOX3PropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

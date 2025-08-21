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
  IElementType IDENTIFIER = new NOX3TokenType("IDENTIFIER");
  IElementType NUMBER = new NOX3TokenType("NUMBER");
  IElementType STRING = new NOX3TokenType("STRING");
  IElementType SEPARATOR = new NOX3TokenType("SEPARATOR");
  IElementType IF = new NOX3TokenType("IF");
  IElementType ENDIF = new NOX3TokenType("ENDIF");
  IElementType FOR = new NOX3TokenType("FOR");
  IElementType TO = new NOX3TokenType("TO");
  IElementType ENDFOR = new NOX3TokenType("ENDFOR");

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

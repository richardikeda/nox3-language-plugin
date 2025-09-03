// This is a generated file. Not intended for manual editing.
package com.enterscript.nox3languageplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.enterscript.nox3languageplugin.language.psi.impl.*;

public interface NOX3Types {

  IElementType CASE_BLOCK = new NOX3ElementType("CASE_BLOCK");
  IElementType EXPRESSION = new NOX3ElementType("EXPRESSION");
  IElementType FOR_BLOCK = new NOX3ElementType("FOR_BLOCK");
  IElementType FUNCTION_CALL = new NOX3ElementType("FUNCTION_CALL");
  IElementType IF_BLOCK = new NOX3ElementType("IF_BLOCK");
  IElementType PROPERTY = new NOX3ElementType("PROPERTY");
  IElementType REPEAT_BLOCK = new NOX3ElementType("REPEAT_BLOCK");
  IElementType VALUE = new NOX3ElementType("VALUE");
  IElementType WHILE_BLOCK = new NOX3ElementType("WHILE_BLOCK");

  IElementType CASE = new NOX3TokenType("CASE");
  IElementType COMMENT = new NOX3TokenType("COMMENT");
  IElementType CRLF = new NOX3TokenType("CRLF");
  IElementType DEFAULT = new NOX3TokenType("DEFAULT");
  IElementType ELSE = new NOX3TokenType("ELSE");
  IElementType ELSIF = new NOX3TokenType("ELSIF");
  IElementType ENDCASE = new NOX3TokenType("ENDCASE");
  IElementType ENDIF = new NOX3TokenType("ENDIF");
  IElementType FOR = new NOX3TokenType("FOR");
  IElementType IDENTIFIER = new NOX3TokenType("IDENTIFIER");
  IElementType IF = new NOX3TokenType("IF");
  IElementType LEN = new NOX3TokenType("LEN");
  IElementType NEXT = new NOX3TokenType("NEXT");
  IElementType NUMBER = new NOX3TokenType("NUMBER");
  IElementType PRINT = new NOX3TokenType("PRINT");
  IElementType REPEAT = new NOX3TokenType("REPEAT");
  IElementType SEPARATOR = new NOX3TokenType("SEPARATOR");
  IElementType SQRT = new NOX3TokenType("SQRT");
  IElementType STRING = new NOX3TokenType("STRING");
  IElementType SYSDATE = new NOX3TokenType("SYSDATE");
  IElementType UNTIL = new NOX3TokenType("UNTIL");
  IElementType USER = new NOX3TokenType("USER");
  IElementType WEND = new NOX3TokenType("WEND");
  IElementType WHEN = new NOX3TokenType("WHEN");
  IElementType WHILE = new NOX3TokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CASE_BLOCK) {
        return new NOX3CaseBlockImpl(node);
      }
      else if (type == EXPRESSION) {
        return new NOX3ExpressionImpl(node);
      }
      else if (type == FOR_BLOCK) {
        return new NOX3ForBlockImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new NOX3FunctionCallImpl(node);
      }
      else if (type == IF_BLOCK) {
        return new NOX3IfBlockImpl(node);
      }
      else if (type == PROPERTY) {
        return new NOX3PropertyImpl(node);
      }
      else if (type == REPEAT_BLOCK) {
        return new NOX3RepeatBlockImpl(node);
      }
      else if (type == VALUE) {
        return new NOX3ValueImpl(node);
      }
      else if (type == WHILE_BLOCK) {
        return new NOX3WhileBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

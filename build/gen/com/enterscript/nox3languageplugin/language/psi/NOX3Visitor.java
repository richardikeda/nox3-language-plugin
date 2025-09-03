// This is a generated file. Not intended for manual editing.
package com.enterscript.nox3languageplugin.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class NOX3Visitor extends PsiElementVisitor {

  public void visitCaseBlock(@NotNull NOX3CaseBlock o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull NOX3Expression o) {
    visitPsiElement(o);
  }

  public void visitForBlock(@NotNull NOX3ForBlock o) {
    visitPsiElement(o);
  }

  public void visitFunctionCall(@NotNull NOX3FunctionCall o) {
    visitPsiElement(o);
  }

  public void visitIfBlock(@NotNull NOX3IfBlock o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull NOX3Property o) {
    visitNamedElement(o);
  }

  public void visitRepeatBlock(@NotNull NOX3RepeatBlock o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull NOX3Value o) {
    visitPsiElement(o);
  }

  public void visitWhileBlock(@NotNull NOX3WhileBlock o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull NOX3NamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}

// This is a generated file. Not intended for manual editing.
package com.enterscript.nox3languageplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.enterscript.nox3languageplugin.language.psi.NOX3Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.enterscript.nox3languageplugin.language.psi.*;

public class NOX3ExpressionImpl extends ASTWrapperPsiElement implements NOX3Expression {

  public NOX3ExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NOX3Visitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NOX3Visitor) accept((NOX3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NOX3FunctionCall getFunctionCall() {
    return findChildByClass(NOX3FunctionCall.class);
  }

}

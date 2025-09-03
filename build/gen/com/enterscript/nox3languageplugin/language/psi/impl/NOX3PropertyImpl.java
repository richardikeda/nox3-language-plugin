// This is a generated file. Not intended for manual editing.
package com.enterscript.nox3languageplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.enterscript.nox3languageplugin.language.psi.NOX3Types.*;
import com.enterscript.nox3languageplugin.language.psi.*;

public class NOX3PropertyImpl extends NOX3NamedElementImpl implements NOX3Property {

  public NOX3PropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NOX3Visitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NOX3Visitor) accept((NOX3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public NOX3Value getValue() {
    return findNotNullChildByClass(NOX3Value.class);
  }

}

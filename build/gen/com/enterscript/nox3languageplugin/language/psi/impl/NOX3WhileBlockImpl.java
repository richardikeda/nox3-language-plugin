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

public class NOX3WhileBlockImpl extends ASTWrapperPsiElement implements NOX3WhileBlock {

  public NOX3WhileBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NOX3Visitor visitor) {
    visitor.visitWhileBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NOX3Visitor) accept((NOX3Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NOX3CaseBlock> getCaseBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NOX3CaseBlock.class);
  }

  @Override
  @NotNull
  public List<NOX3ForBlock> getForBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NOX3ForBlock.class);
  }

  @Override
  @NotNull
  public List<NOX3IfBlock> getIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NOX3IfBlock.class);
  }

  @Override
  @NotNull
  public List<NOX3Property> getPropertyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NOX3Property.class);
  }

  @Override
  @NotNull
  public List<NOX3RepeatBlock> getRepeatBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NOX3RepeatBlock.class);
  }

  @Override
  @NotNull
  public List<NOX3WhileBlock> getWhileBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NOX3WhileBlock.class);
  }

}

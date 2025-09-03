// This is a generated file. Not intended for manual editing.
package com.enterscript.nox3languageplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NOX3IfBlock extends PsiElement {

  @NotNull
  List<NOX3CaseBlock> getCaseBlockList();

  @NotNull
  List<NOX3ForBlock> getForBlockList();

  @NotNull
  List<NOX3IfBlock> getIfBlockList();

  @NotNull
  List<NOX3Property> getPropertyList();

  @NotNull
  List<NOX3RepeatBlock> getRepeatBlockList();

  @NotNull
  List<NOX3WhileBlock> getWhileBlockList();

}

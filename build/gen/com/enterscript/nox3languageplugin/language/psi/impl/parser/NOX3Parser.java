// This is a generated file. Not intended for manual editing.
package com.enterscript.nox3languageplugin.language.psi.impl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.enterscript.nox3languageplugin.language.psi.NOX3Types.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NOX3Parser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // CASE element_* (DEFAULT element_*)? (WHEN element_*)? ENDCASE
  public static boolean case_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block")) return false;
    if (!nextTokenIs(builder_, CASE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CASE);
    result_ = result_ && case_block_1(builder_, level_ + 1);
    result_ = result_ && case_block_2(builder_, level_ + 1);
    result_ = result_ && case_block_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ENDCASE);
    exit_section_(builder_, marker_, CASE_BLOCK, result_);
    return result_;
  }

  // element_*
  private static boolean case_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "case_block_1", pos_)) break;
    }
    return true;
  }

  // (DEFAULT element_*)?
  private static boolean case_block_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_2")) return false;
    case_block_2_0(builder_, level_ + 1);
    return true;
  }

  // DEFAULT element_*
  private static boolean case_block_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DEFAULT);
    result_ = result_ && case_block_2_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // element_*
  private static boolean case_block_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_2_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "case_block_2_0_1", pos_)) break;
    }
    return true;
  }

  // (WHEN element_*)?
  private static boolean case_block_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_3")) return false;
    case_block_3_0(builder_, level_ + 1);
    return true;
  }

  // WHEN element_*
  private static boolean case_block_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, WHEN);
    result_ = result_ && case_block_3_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // element_*
  private static boolean case_block_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_block_3_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "case_block_3_0_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // property | case_block | for_block | if_block | repeat_block | while_block | COMMENT | CRLF
  static boolean element_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element_")) return false;
    boolean result_;
    result_ = property(builder_, level_ + 1);
    if (!result_) result_ = case_block(builder_, level_ + 1);
    if (!result_) result_ = for_block(builder_, level_ + 1);
    if (!result_) result_ = if_block(builder_, level_ + 1);
    if (!result_) result_ = repeat_block(builder_, level_ + 1);
    if (!result_) result_ = while_block(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    return result_;
  }

  /* ********************************************************** */
  // NUMBER | STRING | IDENTIFIER | USER | SYSDATE | function_call
  public static boolean expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPRESSION, "<expression>");
    result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, USER);
    if (!result_) result_ = consumeToken(builder_, SYSDATE);
    if (!result_) result_ = function_call(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // element_*
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "file", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // FOR element_* NEXT
  public static boolean for_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "for_block")) return false;
    if (!nextTokenIs(builder_, FOR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FOR);
    result_ = result_ && for_block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEXT);
    exit_section_(builder_, marker_, FOR_BLOCK, result_);
    return result_;
  }

  // element_*
  private static boolean for_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "for_block_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "for_block_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (IDENTIFIER | PRINT | LEN | SQRT) '(' expression? ')'
  public static boolean function_call(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_call")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_CALL, "<function call>");
    result_ = function_call_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "(");
    result_ = result_ && function_call_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ")");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // IDENTIFIER | PRINT | LEN | SQRT
  private static boolean function_call_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_call_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, PRINT);
    if (!result_) result_ = consumeToken(builder_, LEN);
    if (!result_) result_ = consumeToken(builder_, SQRT);
    return result_;
  }

  // expression?
  private static boolean function_call_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_call_2")) return false;
    expression(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // IF element_* (ELSE element_*)? (ELSIF element_*)? ENDIF
  public static boolean if_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IF);
    result_ = result_ && if_block_1(builder_, level_ + 1);
    result_ = result_ && if_block_2(builder_, level_ + 1);
    result_ = result_ && if_block_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ENDIF);
    exit_section_(builder_, marker_, IF_BLOCK, result_);
    return result_;
  }

  // element_*
  private static boolean if_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "if_block_1", pos_)) break;
    }
    return true;
  }

  // (ELSE element_*)?
  private static boolean if_block_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_2")) return false;
    if_block_2_0(builder_, level_ + 1);
    return true;
  }

  // ELSE element_*
  private static boolean if_block_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ELSE);
    result_ = result_ && if_block_2_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // element_*
  private static boolean if_block_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_2_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "if_block_2_0_1", pos_)) break;
    }
    return true;
  }

  // (ELSIF element_*)?
  private static boolean if_block_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_3")) return false;
    if_block_3_0(builder_, level_ + 1);
    return true;
  }

  // ELSIF element_*
  private static boolean if_block_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ELSIF);
    result_ = result_ && if_block_3_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // element_*
  private static boolean if_block_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_block_3_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "if_block_3_0_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER SEPARATOR value
  public static boolean property(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, SEPARATOR);
    result_ = result_ && value(builder_, level_ + 1);
    exit_section_(builder_, marker_, PROPERTY, result_);
    return result_;
  }

  /* ********************************************************** */
  // REPEAT element_* UNTIL
  public static boolean repeat_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "repeat_block")) return false;
    if (!nextTokenIs(builder_, REPEAT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, REPEAT);
    result_ = result_ && repeat_block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, UNTIL);
    exit_section_(builder_, marker_, REPEAT_BLOCK, result_);
    return result_;
  }

  // element_*
  private static boolean repeat_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "repeat_block_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "repeat_block_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression
  public static boolean value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VALUE, "<value>");
    result_ = expression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // WHILE element_* WEND
  public static boolean while_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "while_block")) return false;
    if (!nextTokenIs(builder_, WHILE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, WHILE);
    result_ = result_ && while_block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, WEND);
    exit_section_(builder_, marker_, WHILE_BLOCK, result_);
    return result_;
  }

  // element_*
  private static boolean while_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "while_block_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "while_block_1", pos_)) break;
    }
    return true;
  }

}

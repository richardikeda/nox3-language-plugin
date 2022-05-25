package com.enterscript.noX3LanguagePlugin.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types;
import com.intellij.psi.TokenType;

%%

%class NOX3Lexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

//Definition of numbers
INT=-?[0-9]+

//Comments block code
COMMENT_LINE=#.*
COMMENT_MULTI_LINE="#**" !([^]* "#*!"{CRLF}[^]*)\n ("#*!")?
//END_OF_MULTI_LINE_COMMENT=[^\r\n]*
//COMMENT_MULTI_LINE_SPECIAL="#***" !([^]* "#*!" [^]*) ("#*!")?
END_OF_LINE_COMMENT=("#")[^\r\n]*

%state WAITING_VALUE

%%
<YYINITIAL> {
//    {COMMENT_MULTI_LINE_SPECIAL}  { return NOX3Types.COMMENT_MULTI_LINE_SPECIAL; }
    {COMMENT_MULTI_LINE}          { return NOX3Types.COMMENT_MULTI_LINE; }
    {COMMENT_LINE}                { return NOX3Types.COMMENT; }


}
<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(WAITING_VALUE); return NOX3Types.COMMENT; }
//<YYINITIAL> {END_OF_MULTI_LINE_COMMENT}                     { yybegin(WAITING_VALUE); return NOX3Types.COMMENT_MULTI_LINE; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return NOX3Types.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return NOX3Types.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return NOX3Types.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
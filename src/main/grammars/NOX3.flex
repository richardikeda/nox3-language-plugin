// NOX3 lexer specification. This file is maintained manually.
package com.enterscript.nox3languageplugin.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.enterscript.nox3languageplugin.language.psi.NOX3Types;
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
WHITE_SPACE=[ \t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
NUMBER=[0-9]+
STRING=\"([^\"\\]|\\.)*\"
COMMENT="#"[^\n]*

SUBPROG=(?i:Subprog)
CLASS=(?i:Class)
GLOBAL=(?i:Global)
LOCAL=(?i:Local)
INSTANCE=(?i:Instance)
USING=(?i:Using)
VALUE=(?i:Value)
VARIABLE=(?i:Variable)
CONST=(?i:Const)
IF=(?i:If)
THEN=(?i:Then)
ELSE=(?i:Else)
ENDIF=(?i:Endif)
FOR=(?i:For)
TO=(?i:To)
NEXT=(?i:Next)

CHAR=(?i:Char)
DECIMAL=(?i:Decimal)
INTEGER=(?i:Integer)
DATE=(?i:Date)

EQUAL==
PLUS=\+
MINUS=-
LPAREN=\(
RPAREN=\)
COMMA=,
DOT=\.
COLON=:

%%

{CRLF}        { return NOX3Types.CRLF; }
{WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }
{COMMENT}     { return NOX3Types.COMMENT; }

{SUBPROG}     { return NOX3Types.SUBPROG; }
{CLASS}       { return NOX3Types.CLASS; }
{GLOBAL}      { return NOX3Types.GLOBAL; }
{LOCAL}       { return NOX3Types.LOCAL; }
{INSTANCE}    { return NOX3Types.INSTANCE; }
{USING}       { return NOX3Types.USING; }
{VALUE}       { return NOX3Types.VALUE; }
{VARIABLE}    { return NOX3Types.VARIABLE; }
{CONST}       { return NOX3Types.CONST; }
{IF}          { return NOX3Types.IF; }
{THEN}        { return NOX3Types.THEN; }
{ELSE}        { return NOX3Types.ELSE; }
{ENDIF}       { return NOX3Types.ENDIF; }
{FOR}         { return NOX3Types.FOR; }
{TO}          { return NOX3Types.TO; }
{NEXT}        { return NOX3Types.NEXT; }

{CHAR}        { return NOX3Types.CHAR; }
{DECIMAL}     { return NOX3Types.DECIMAL; }
{INTEGER}     { return NOX3Types.INTEGER; }
{DATE}        { return NOX3Types.DATE; }

{EQUAL}       { return NOX3Types.SEPARATOR; }
{PLUS}        { return NOX3Types.PLUS; }
{MINUS}       { return NOX3Types.MINUS; }
{LPAREN}      { return NOX3Types.LPAREN; }
{RPAREN}      { return NOX3Types.RPAREN; }
{COMMA}       { return NOX3Types.COMMA; }
{DOT}         { return NOX3Types.DOT; }
{COLON}       { return NOX3Types.COLON; }

{STRING}      { return NOX3Types.STRING; }
{NUMBER}      { return NOX3Types.NUMBER; }
{IDENTIFIER}  { return NOX3Types.IDENTIFIER; }

[^]           { return TokenType.BAD_CHARACTER; }

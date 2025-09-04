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
LINE_COMMENT="#"[^\n]*
BLOCK_COMMENT="#\*\*\*"[^]*"\*!"
COMMENT={LINE_COMMENT}|{BLOCK_COMMENT}

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
CALL=(?i:Call)
FROM=(?i:From)
CASE=(?i:Case)
WHEN=(?i:When)
ENDCASE=(?i:Endcase)
RETURN=(?i:Return)
ONERRGO=(?i:Onerrgo)
TRBEGIN=(?i:Trbegin)
COMMIT=(?i:Commit)
ROLLBACK=(?i:Rollback)
FILTER=(?i:Filter)
READ=(?i:Read)
UPDATE=(?i:Update)
WRITE=(?i:Write)
REWRITE=(?i:Rewrite)
DELETE=(?i:Delete)
GOSUB=(?i:Gosub)
FMET=(?i:Fmet)
FUNC=(?i:Func)
L_BLOCK=(?i:\[L\])
F_BLOCK=(?i:\[F:[A-Za-z0-9]{4}\])

CHAR=(?i:Char)
DECIMAL=(?i:Decimal)
INTEGER=(?i:Integer)
DATE=(?i:Date)

EQUAL==
PLUS=\+
MINUS=-
STAR=\*
DIV=/
NEQ=<>
LBRACKET=\[
RBRACKET=\]
LPAREN=\(
RPAREN=\)
COMMA=,
ACTION=(?i:\$ACTION)
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
{CALL}        { return NOX3Types.CALL; }
{FROM}        { return NOX3Types.FROM; }
{CASE}        { return NOX3Types.CASE; }
{WHEN}        { return NOX3Types.WHEN; }
{ENDCASE}     { return NOX3Types.ENDCASE; }
{RETURN}      { return NOX3Types.RETURN; }
{ONERRGO}     { return NOX3Types.ONERRGO; }
{TRBEGIN}     { return NOX3Types.TRBEGIN; }
{COMMIT}      { return NOX3Types.COMMIT; }
{ROLLBACK}    { return NOX3Types.ROLLBACK; }
{FILTER}      { return NOX3Types.FILTER; }
{READ}        { return NOX3Types.READ; }
{UPDATE}      { return NOX3Types.UPDATE; }
{WRITE}       { return NOX3Types.WRITE; }
{REWRITE}     { return NOX3Types.REWRITE; }
{DELETE}      { return NOX3Types.DELETE; }
{GOSUB}       { return NOX3Types.GOSUB; }
{FMET}        { return NOX3Types.FMET; }
{FUNC}        { return NOX3Types.FUNC; }
{L_BLOCK}     { return NOX3Types.L_BLOCK; }
{F_BLOCK}     { return NOX3Types.F_BLOCK; }

{CHAR}        { return NOX3Types.CHAR; }
{DECIMAL}     { return NOX3Types.DECIMAL; }
{INTEGER}     { return NOX3Types.INTEGER; }
{DATE}        { return NOX3Types.DATE; }

{EQUAL}       { return NOX3Types.SEPARATOR; }
{PLUS}        { return NOX3Types.PLUS; }
{MINUS}       { return NOX3Types.MINUS; }
{STAR}        { return NOX3Types.STAR; }
{DIV}         { return NOX3Types.DIV; }
{NEQ}         { return NOX3Types.NEQ; }
{LBRACKET}    { return NOX3Types.LBRACKET; }
{RBRACKET}    { return NOX3Types.RBRACKET; }
{LPAREN}      { return NOX3Types.LPAREN; }
{RPAREN}      { return NOX3Types.RPAREN; }
{COMMA}       { return NOX3Types.COMMA; }
{ACTION}      { return NOX3Types.ACTION; }
{DOT}         { return NOX3Types.DOT; }
{COLON}       { return NOX3Types.COLON; }

{STRING}      { return NOX3Types.STRING; }
{NUMBER}      { return NOX3Types.NUMBER; }
{IDENTIFIER}  { return NOX3Types.IDENTIFIER; }

[^]           { return TokenType.BAD_CHARACTER; }

// NOX3 lexer specification for simple key-value properties
package com.enterscript.nox3languageplugin.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.enterscript.nox3languageplugin.language.psi.NOX3Types;
import com.intellij.psi.TokenType;

%%

%class NOX3Lexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \t\f]
END_OF_LINE_COMMENT=#([^\r\n]*)
SEPARATOR==
KEY_CHARACTER=[^=\ \t\f\r\n]+
VALUE_CHARACTER=[^\r\n]*

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT} { yybegin(YYINITIAL); return NOX3Types.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+ { yybegin(YYINITIAL); return NOX3Types.KEY; }

<YYINITIAL> {SEPARATOR} { yybegin(WAITING_VALUE); return NOX3Types.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+ { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {VALUE_CHARACTER}+ { yybegin(YYINITIAL); return NOX3Types.VALUE; }

({CRLF}|{WHITE_SPACE})+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^] { return TokenType.BAD_CHARACTER; }

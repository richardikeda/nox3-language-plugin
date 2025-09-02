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
WHITE_SPACE=[\ \t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
NUMBER=[0-9]+
STRING="([^"\n]|\\.)*"
COMMENT="#"[^\n]*
IF=(?i:if)
ENDIF=(?i:endif)
FOR=(?i:for)
TO=(?i:to)
ENDFOR=(?i:endfor)

%%

{WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }
{CRLF}        { return NOX3Types.CRLF; }
{COMMENT}     { return NOX3Types.COMMENT; }

{IF}          { return NOX3Types.IF; }
{ENDIF}       { return NOX3Types.ENDIF; }
{FOR}         { return NOX3Types.FOR; }
{TO}          { return NOX3Types.TO; }
{ENDFOR}      { return NOX3Types.ENDFOR; }

"="           { return NOX3Types.SEPARATOR; }
{STRING}      { return NOX3Types.STRING; }
{NUMBER}      { return NOX3Types.NUMBER; }
{IDENTIFIER}  { return NOX3Types.IDENTIFIER; }

[^]           { return TokenType.BAD_CHARACTER; }

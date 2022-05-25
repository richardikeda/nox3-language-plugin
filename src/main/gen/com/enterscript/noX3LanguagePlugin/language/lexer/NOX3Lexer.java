/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.enterscript.noX3LanguagePlugin.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Types;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>NOX3.flex</tt>
 */
class NOX3Lexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_VALUE = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\4\1\2\1\1\1\5\1\3\22\0\1\7\1\13\1\0\1\11\6\0\1\12\17\0\1\10\2\0\1"+
    "\10\36\0\1\6\50\0\1\1\242\0\2\1\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\2\1\1\2\1\3\1\4\1\5\2\6\2\7"+
    "\1\3\1\7\1\0\1\5\1\10\1\5\1\10\2\5"+
    "\1\0\1\2\2\6\1\10\1\5\1\10\1\11\1\1"+
    "\1\5\1\10\2\5\2\10\3\0\1\1\1\5\1\10"+
    "\1\5\1\10\2\0\1\1\1\5\1\10\1\5\1\10"+
    "\1\0\1\11\1\1\1\5\1\10\1\11\3\0\1\11";

  private static int [] zzUnpackAction() {
    int [] result = new int[61];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\14\0\30\0\44\0\60\0\74\0\110\0\124"+
    "\0\140\0\154\0\60\0\170\0\204\0\220\0\74\0\234"+
    "\0\250\0\264\0\300\0\314\0\330\0\204\0\154\0\344"+
    "\0\360\0\374\0\u0108\0\u0114\0\u0120\0\u012c\0\u0138\0\u0144"+
    "\0\u0150\0\u015c\0\u0168\0\u0174\0\u0180\0\u018c\0\u0198\0\u01a4"+
    "\0\u01b0\0\u01bc\0\u01c8\0\u01d4\0\u01e0\0\u01ec\0\u01f8\0\u0204"+
    "\0\u0210\0\u021c\0\u0228\0\u0234\0\u0240\0\u024c\0\u0258\0\u0264"+
    "\0\u0270\0\u0240\0\u027c\0\u0288\0\110";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[61];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\4\2\5\1\6\1\5\1\7"+
    "\1\10\2\3\1\11\1\12\1\13\1\12\1\14\1\13"+
    "\1\15\1\16\4\11\2\3\1\0\1\3\2\0\1\17"+
    "\2\0\4\3\1\4\1\5\1\4\2\5\1\17\1\5"+
    "\1\0\3\3\1\0\5\5\1\0\1\5\13\0\1\3"+
    "\20\0\1\20\1\21\1\0\1\3\1\22\1\23\1\24"+
    "\2\22\1\20\1\25\1\20\2\11\1\0\2\11\1\0"+
    "\1\26\6\11\1\27\1\5\2\27\1\5\1\26\1\27"+
    "\5\11\1\30\1\16\1\30\1\14\1\16\1\26\1\14"+
    "\7\11\1\31\10\11\1\0\1\5\1\16\1\5\2\16"+
    "\1\0\1\16\4\0\1\20\1\21\1\0\1\3\1\22"+
    "\1\23\1\24\2\22\3\20\2\21\1\0\1\3\2\23"+
    "\1\32\2\23\3\21\1\22\1\23\2\0\1\22\1\23"+
    "\6\22\2\23\2\0\10\23\1\22\1\23\2\0\1\22"+
    "\1\23\1\22\1\20\4\22\1\20\1\21\1\0\1\3"+
    "\1\22\1\23\1\24\2\22\1\20\1\33\1\20\1\11"+
    "\1\30\1\5\2\30\1\5\1\26\1\30\11\11\1\0"+
    "\1\26\5\11\2\23\2\0\3\23\1\21\4\23\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\2\37\1\42"+
    "\2\33\2\34\1\35\1\36\2\40\1\43\2\40\1\44"+
    "\2\34\2\45\1\35\6\45\1\46\2\45\2\36\1\35"+
    "\1\36\2\45\1\47\2\45\1\50\2\36\1\37\1\40"+
    "\1\35\1\45\1\37\1\40\3\37\1\51\2\37\2\40"+
    "\1\35\1\45\5\40\1\52\2\40\1\37\1\40\1\35"+
    "\1\45\1\37\1\40\1\37\1\33\1\37\1\51\2\37"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\2\37"+
    "\1\42\1\53\1\33\2\40\1\35\1\45\3\40\1\34"+
    "\1\40\1\52\2\40\2\34\1\35\1\36\2\40\1\43"+
    "\2\40\1\44\1\54\1\34\2\45\1\35\6\45\1\55"+
    "\4\45\1\35\6\45\1\55\1\56\3\45\1\35\4\45"+
    "\1\36\1\45\1\55\2\45\2\36\1\35\1\36\2\45"+
    "\1\47\2\45\1\50\1\57\1\36\1\37\1\40\1\35"+
    "\1\45\1\37\1\40\3\37\1\51\1\60\1\37\2\40"+
    "\1\35\1\45\5\40\1\52\1\61\1\40\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\2\37\1\42\1\33"+
    "\1\62\2\34\1\35\1\36\2\40\1\43\2\40\1\44"+
    "\1\34\1\63\2\45\1\35\6\45\1\55\1\64\3\45"+
    "\1\35\6\45\1\55\1\45\1\65\2\36\1\35\1\36"+
    "\2\45\1\47\2\45\1\50\1\36\1\66\1\37\1\40"+
    "\1\35\1\45\1\37\1\40\3\37\1\51\1\37\1\67"+
    "\2\40\1\35\1\45\5\40\1\52\1\40\1\70\1\33"+
    "\1\21\1\71\1\3\1\37\1\23\1\41\2\37\1\42"+
    "\2\33\1\34\1\21\1\71\1\3\1\40\1\23\1\43"+
    "\2\40\1\44\2\34\2\45\1\35\6\45\1\55\1\45"+
    "\1\72\1\45\1\0\1\71\1\0\1\45\1\0\3\45"+
    "\1\55\2\45\1\36\1\3\1\71\1\3\1\45\1\0"+
    "\1\47\2\45\1\50\2\36\1\37\1\23\1\71\1\0"+
    "\1\37\1\23\3\37\1\51\2\37\1\40\1\23\1\71"+
    "\1\0\1\40\1\23\3\40\1\52\2\40\11\0\1\73"+
    "\14\0\1\74\14\0\1\75";

  private static int [] zzUnpackTrans() {
    int [] result = new int[660];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\4\1\1\11\7\1\1\0\6\1\1\0\16\1"+
    "\3\0\5\1\2\0\5\1\1\0\5\1\3\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[61];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  NOX3Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(YYINITIAL); return NOX3Types.KEY;
            } 
            // fall through
          case 10: break;
          case 2: 
            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 11: break;
          case 3: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 12: break;
          case 4: 
            { yybegin(WAITING_VALUE); return NOX3Types.SEPARATOR;
            } 
            // fall through
          case 13: break;
          case 5: 
            { return NOX3Types.COMMENT;
            } 
            // fall through
          case 14: break;
          case 6: 
            { yybegin(YYINITIAL); return NOX3Types.VALUE;
            } 
            // fall through
          case 15: break;
          case 7: 
            { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 16: break;
          case 8: 
            { yybegin(WAITING_VALUE); return NOX3Types.COMMENT;
            } 
            // fall through
          case 17: break;
          case 9: 
            { return NOX3Types.COMMENT_MULTI_LINE;
            } 
            // fall through
          case 18: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
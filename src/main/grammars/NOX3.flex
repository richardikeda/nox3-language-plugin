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
STRING=\"[^\"]*\"
COMMENT="#"[^\n]*

ACH=(?i:ACH)
ACOS=(?i:ACOS)
ACTIHGUP=(?i:ACTIHGUP)
ACTZO=(?i:ACTZO)
ADDITM=(?i:ADDITM)
ADDMEN=(?i:ADDMEN)
ADDMONTH=(?i:ADDMONTH)
ADXCIO=(?i:ADXCIO)
ADXCPW=(?i:ADXCPW)
ADXCTX=(?i:ADXCTX)
ADXCUS=(?i:ADXCUS)
ADXDBC=(?i:ADXDBC)
ADXDBO=(?i:ADXDBO)
ADXDBX=(?i:ADXDBX)
ADXDCS=(?i:ADXDCS)
ADXDIR=(?i:ADXDIR)
ADXDLREC=(?i:ADXDLREC)
ADXDPG=(?i:ADXDPG)
ADXFMT=(?i:ADXFMT)
ADXFNAME=(?i:ADXFNAME)
ADXFTL=(?i:ADXFTL)
ADXGTB=(?i:ADXGTB)
ADXIFS=(?i:ADXIFS)
ADXIOA=(?i:ADXIOA)
ADXIRS=(?i:ADXIRS)
ADXIUM=(?i:ADXIUM)
ADXKPG=(?i:ADXKPG)
ADXKSP=(?i:ADXKSP)
ADXLIG=(?i:ADXLIG)
ADXLOG=(?i:ADXLOG)
ADXMAC=(?i:ADXMAC)
ADXMBM=(?i:ADXMBM)
ADXMDA=(?i:ADXMDA)
ADXMOTHER=(?i:ADXMOTHER)
ADXMPGPRO=(?i:ADXMPGPRO)
ADXMPGTRT=(?i:ADXMPGTRT)
ADXMPR=(?i:ADXMPR)
ADXMSO=(?i:ADXMSO)
ADXMTO=(?i:ADXMTO)
ADXMUA=(?i:ADXMUA)
ADXMXL=(?i:ADXMXL)
ADXNFS=(?i:ADXNFS)
ADXOVF=(?i:ADXOVF)
ADXOVS=(?i:ADXOVS)
ADXPAM=(?i:ADXPAM)
ADXPID=(?i:ADXPID)
ADXPNO=(?i:ADXPNO)
ADXROB=(?i:ADXROB)
ADXSAX=(?i:ADXSAX)
ADXSCA=(?i:ADXSCA)
ADXSEEK=(?i:ADXSEEK)
ADXSES=(?i:ADXSES)
ADXSQLREC=(?i:ADXSQLREC)
ADXTCP=(?i:ADXTCP)
ADXTCT=(?i:ADXTCT)
ADXTLK=(?i:ADXTLK)
ADXTMS=(?i:ADXTMS)
ADXTRL=(?i:ADXTRL)
ADXTRO=(?i:ADXTRO)
ADXTRP=(?i:ADXTRP)
ADXTUC=(?i:ADXTUC)
ADXTUL=(?i:ADXTUL)
ADXTUT=(?i:ADXTUT)
ADXTYP=(?i:ADXTYP)
ADXUID=(?i:ADXUID)
ADXUPREC=(?i:ADXUPREC)
ADXUSR=(?i:ADXUSR)
ADXWRB=(?i:ADXWRB)
AFFZO=(?i:AFFZO)
ALLOCGRP=(?i:ALLOCGRP)
ANASQL=(?i:ANASQL)
AND=(?i:AND)
ANP=(?i:ANP)
APPEND=(?i:APPEND)
AR2=(?i:AR2)
ARR=(?i:ARR)
AS=(?i:AS)
ASC=(?i:ASC)
ASCII=(?i:ASCII)
ASH=(?i:ASH)
ASIN=(?i:ASIN)
ASKUI=(?i:ASKUI)
ASSIGN=(?i:ASSIGN)
AT=(?i:AT)
ATAN=(?i:ATAN)
ATAN2=(?i:ATAN2)
ATH=(?i:ATH)
AVG=(?i:AVG)
AWEEK=(?i:AWEEK)
B64DECODE=(?i:B64DECODE)
B64ENCODE=(?i:B64ENCODE)
BLBFILE=(?i:BLBFILE)
BLK=(?i:BLK)
BOXACT=(?i:BOXACT)
BOXCLR=(?i:BOXCLR)
BOXINP=(?i:BOXINP)
BREAK=(?i:BREAK)
BUTTON=(?i:BUTTON)
BY=(?i:BY)
CALL=(?i:CALL)
CALLILOG=(?i:CALLILOG)
CALLIU=(?i:CALLIU)
CALLMET=(?i:CALLMET)
CALLOCX=(?i:CALLOCX)
CALLSTACK=(?i:CALLSTACK)
CALLUI=(?i:CALLUI)
CALLWS=(?i:CALLWS)
CASE=(?i:CASE)
CAST=(?i:CAST)
CH=(?i:CH)
CHAIN=(?i:CHAIN)
CHAR=(?i:CHAR)
CHECKIN=(?i:CHECKIN)
CHECKPATH=(?i:CHECKPATH)
CHGFMT=(?i:CHGFMT)
CHGSTL=(?i:CHGSTL)
CHGTBK=(?i:CHGTBK)
CHGTFD=(?i:CHGTFD)
CHGTZN=(?i:CHGTZN)
CHOOSE=(?i:CHOOSE)
CHR_=(?i:CHR\$)
CLACMP=(?i:CLACMP)
CLACTXNBS=(?i:CLACTXNBS)
CLACTXVAR=(?i:CLACTXVAR)
CLALEV=(?i:CLALEV)
CLANAM=(?i:CLANAM)
CLANBS=(?i:CLANBS)
CLASIZ=(?i:CLASIZ)
CLAVAR=(?i:CLAVAR)
CLBFILE=(?i:CLBFILE)
CLLDAP=(?i:CLLDAP)
CLONE=(?i:CLONE)
CLOSE=(?i:CLOSE)
CLOSECOM=(?i:CLOSECOM)
CLOSELOG=(?i:CLOSELOG)
CLOSEXML=(?i:CLOSEXML)
CNP=(?i:CNP)
CODED=(?i:CODED)
COLUMNS=(?i:COLUMNS)
COMMIT=(?i:COMMIT)
CONST=(?i:CONST)
CONVXML=(?i:CONVXML)
COP_=(?i:COP\$)
COS=(?i:COS)
CTRANS=(?i:CTRANS)
CTXINFO=(?i:CTXINFO)
CURR=(?i:CURR)
CURRBOX=(?i:CURRBOX)
CURRIND=(?i:CURRIND)
CURRLEN=(?i:CURRLEN)
DATE=(?i:DATE)
DATESYST=(?i:DATESYST)
DATETIME=(?i:DATETIME)
DATETIME_=(?i:DATETIME\$)
DATE_=(?i:DATE\$)
DAY=(?i:DAY)
DAYN=(?i:DAYN)
DAY_=(?i:DAY\$)
DBGAFF=(?i:DBGAFF)
DBGATTACH=(?i:DBGATTACH)
DBGBOX=(?i:DBGBOX)
DBGBREAKPOINTADD=(?i:DBGBREAKPOINTADD)
DBGBREAKPOINTGET=(?i:DBGBREAKPOINTGET)
DBGBREAKPOINTLIST=(?i:DBGBREAKPOINTLIST)
DBGBREAKPOINTREMOVE=(?i:DBGBREAKPOINTREMOVE)
DBGBREAKPOINTUPDATE=(?i:DBGBREAKPOINTUPDATE)
DBGCALLSTACK=(?i:DBGCALLSTACK)
DBGDURATION=(?i:DBGDURATION)
DBGEVALUE=(?i:DBGEVALUE)
DBGEVALUE2=(?i:DBGEVALUE2)
DBGEXCEPT=(?i:DBGEXCEPT)
DBGLINEOFFSET=(?i:DBGLINEOFFSET)
DBGLOG=(?i:DBGLOG)
DBGLONG=(?i:DBGLONG)
DBGMODE=(?i:DBGMODE)
DBGSTR=(?i:DBGSTR)
DCLKEY=(?i:DCLKEY)
DECIMAL=(?i:DECIMAL)
DEFAULT=(?i:DEFAULT)
DELA=(?i:DELA)
DELETE=(?i:DELETE)
DELETEBYKEY=(?i:DELETEBYKEY)
DELFILE=(?i:DELFILE)
DESC=(?i:DESC)
DIM=(?i:DIM)
DIMCTX=(?i:DIMCTX)
DIR_=(?i:DIR\$)
DISABLE=(?i:DISABLE)
DISCOMBO=(?i:DISCOMBO)
DISLBOX=(?i:DISLBOX)
DISZO=(?i:DISZO)
DLGBOX=(?i:DLGBOX)
DOUBLE=(?i:DOUBLE)
DSPZO=(?i:DSPZO)
EDI=(?i:EDI)
EFFZO=(?i:EFFZO)
ELSE=(?i:ELSE)
ELSIF=(?i:ELSIF)
ENABLE=(?i:ENABLE)
END=(?i:END)
ENDBOX=(?i:ENDBOX)
ENDCASE=(?i:ENDCASE)
ENDIF=(?i:ENDIF)
ENTETE=(?i:ENTETE)
ENVZO=(?i:ENVZO)
EOMONTH=(?i:EOMONTH)
ERRBOX=(?i:ERRBOX)
ERRL=(?i:ERRL)
ERRM=(?i:ERRM)
ERRMES_=(?i:ERRMES\$)
ERRN=(?i:ERRN)
ERRNREMOTE=(?i:ERRNREMOTE)
ERRP=(?i:ERRP)
ESCJSON=(?i:ESCJSON)
EVALUE=(?i:EVALUE)
EVALUESDATA=(?i:EVALUESDATA)
EXECSQL=(?i:EXECSQL)
EXECWS=(?i:EXECWS)
EXP=(?i:EXP)
EXTENDED=(?i:EXTENDED)
EXTERN=(?i:EXTERN)
EXTSIZE=(?i:EXTSIZE)
FAC=(?i:FAC)
FIELD=(?i:FIELD)
FILCOM=(?i:FILCOM)
FILE=(?i:FILE)
FILEABRE=(?i:FILEABRE)
FILECLA=(?i:FILECLA)
FILELEV=(?i:FILELEV)
FILENAME=(?i:FILENAME)
FILENUME=(?i:FILENUME)
FILETYP=(?i:FILETYP)
FILEXIST=(?i:FILEXIST)
FILINFO=(?i:FILINFO)
FILLBOX=(?i:FILLBOX)
FILPATH=(?i:FILPATH)
FILTER=(?i:FILTER)
FIND=(?i:FIND)
FIRST=(?i:FIRST)
FIX=(?i:FIX)
FLOAT=(?i:FLOAT)
FLUSH=(?i:FLUSH)
FMET=(?i:FMET)
FMETHOD=(?i:FMETHOD)
FOLDER=(?i:FOLDER)
FOR=(?i:FOR)
FORMAT_=(?i:FORMAT\$)
FORMULA=(?i:FORMULA)
FREEGROUP=(?i:FREEGROUP)
FREEHEAP=(?i:FREEHEAP)
FREEINSTANCE=(?i:FREEINSTANCE)
FREEMEM=(?i:FREEMEM)
FREESNAPSHOT=(?i:FREESNAPSHOT)
FREESYSSNAPSHOT=(?i:FREESYSSNAPSHOT)
FROM=(?i:FROM)
FSTAT=(?i:FSTAT)
FUNC=(?i:FUNC)
FUNCIU=(?i:FUNCIU)
FUNPROG=(?i:FUNPROG)
GDATETIME_=(?i:GDATETIME\$)
GDAT_=(?i:GDAT\$)
GETACCESSORENABLED=(?i:GETACCESSORENABLED)
GETBIT=(?i:GETBIT)
GETCHILDBYNAME=(?i:GETCHILDBYNAME)
GETCHILDBYTYPE=(?i:GETCHILDBYTYPE)
GETENV_=(?i:GETENV\$)
GETFIRSTCHILD=(?i:GETFIRSTCHILD)
GETFIRSTCHILDBYNAME=(?i:GETFIRSTCHILDBYNAME)
GETLASTCHILD=(?i:GETLASTCHILD)
GETLASTCHILDBYNAME=(?i:GETLASTCHILDBYNAME)
GETLOGNAME=(?i:GETLOGNAME)
GETMODIFIED=(?i:GETMODIFIED)
GETNBCHILD=(?i:GETNBCHILD)
GETNEXTCHILD=(?i:GETNEXTCHILD)
GETNEXTCHILDBYNAME=(?i:GETNEXTCHILDBYNAME)
GETPARENT=(?i:GETPARENT)
GETROOTELEMENT=(?i:GETROOTELEMENT)
GETSEQ=(?i:GETSEQ)
GETSYSMODIFIED=(?i:GETSYSMODIFIED)
GETUI=(?i:GETUI)
GETUUID=(?i:GETUUID)
GLOBAL=(?i:GLOBAL)
GOSUB=(?i:GOSUB)
GOTO=(?i:GOTO)
GRAPH_=(?i:GRAPH\$)
GRIZO=(?i:GRIZO)
HEAPDMP=(?i:HEAPDMP)
HINT=(?i:HINT)
HLPBOX=(?i:HLPBOX)
IF=(?i:IF)
IMAGE=(?i:IMAGE)
INDCUM=(?i:INDCUM)
INDICE=(?i:INDICE)
INFBOX=(?i:INFBOX)
INFIMG=(?i:INFIMG)
INFTXT=(?i:INFTXT)
INPBOX=(?i:INPBOX)
INPMODE=(?i:INPMODE)
INSA=(?i:INSA)
INSLI=(?i:INSLI)
INSTANCE=(?i:INSTANCE)
INSTR=(?i:INSTR)
INT=(?i:INT)
INTEGER=(?i:INTEGER)
INTER=(?i:INTER)
INVFOL=(?i:INVFOL)
IOMODE=(?i:IOMODE)
ISOMESS=(?i:ISOMESS)
ISOPENADXD=(?i:ISOPENADXD)
ISREADONLY=(?i:ISREADONLY)
JSONPROTO=(?i:JSONPROTO)
KEY=(?i:KEY)
KEYLEN=(?i:KEYLEN)
KEYNAME=(?i:KEYNAME)
KEYUNIQ=(?i:KEYUNIQ)
KILL=(?i:KILL)
LAST=(?i:LAST)
LEFTBOX=(?i:LEFTBOX)
LEFT_=(?i:LEFT\$)
LEN=(?i:LEN)
LIBELLE=(?i:LIBELLE)
LINK=(?i:LINK)
LISTBOX=(?i:LISTBOX)
LISTIMP=(?i:LISTIMP)
LN=(?i:LN)
LOBSIZE=(?i:LOBSIZE)
LOCAL=(?i:LOCAL)
LOCFSHOST=(?i:LOCFSHOST)
LOCFSQON=(?i:LOCFSQON)
LOCFSQPORT=(?i:LOCFSQPORT)
LOCK=(?i:LOCK)
LOCKWAIT=(?i:LOCKWAIT)
LOG=(?i:LOG)
LOGICCLOSE=(?i:LOGICCLOSE)
LOOK=(?i:LOOK)
MASK=(?i:MASK)
MASKABR=(?i:MASKABR)
MASKCLA=(?i:MASKCLA)
MASKCOU=(?i:MASKCOU)
MASKLEV=(?i:MASKLEV)
MASKNAM=(?i:MASKNAM)
MASKNBF=(?i:MASKNBF)
MASKRK=(?i:MASKRK)
MASKSIZ=(?i:MASKSIZ)
MAX=(?i:MAX)
MAXHEAP=(?i:MAXHEAP)
MAXMEM=(?i:MAXMEM)
MAXROWS=(?i:MAXROWS)
MAXTAB=(?i:MAXTAB)
MEN=(?i:MEN)
MENCHOIX=(?i:MENCHOIX)
MESBOX=(?i:MESBOX)
MESS=(?i:MESS)
MESSNAME=(?i:MESSNAME)
METHOD=(?i:METHOD)
MID_=(?i:MID\$)
MIN=(?i:MIN)
MKSTAT=(?i:MKSTAT)
MOD=(?i:MOD)
MODIFIED=(?i:MODIFIED)
MONTH=(?i:MONTH)
MONTH_=(?i:MONTH\$)
NAP=(?i:NAP)
NBIND=(?i:NBIND)
NBRECORD=(?i:NBRECORD)
NBRUSER=(?i:NBRUSER)
NBZON=(?i:NBZON)
NDAY=(?i:NDAY)
NDAY_=(?i:NDAY\$)
NEWINSTANCE=(?i:NEWINSTANCE)
NEXT=(?i:NEXT)
NOHINT=(?i:NOHINT)
NOINTER=(?i:NOINTER)
NOLIGN=(?i:NOLIGN)
NOLIGN1=(?i:NOLIGN1)
NOMAP=(?i:NOMAP)
NOT=(?i:NOT)
NULL=(?i:NULL)
NULLUUID=(?i:NULLUUID)
NUM_=(?i:NUM\$)
NXLDAP=(?i:NXLDAP)
NXT=(?i:NXT)
OBJECTEXIST=(?i:OBJECTEXIST)
OBJECTNBS=(?i:OBJECTNBS)
OBJECTTYPE=(?i:OBJECTTYPE)
OBJECTVAR=(?i:OBJECTVAR)
ONERRGO=(?i:ONERRGO)
ONEVENT=(?i:ONEVENT)
ONINTGO=(?i:ONINTGO)
ONKEY=(?i:ONKEY)
OPADXD=(?i:OPADXD)
OPENI=(?i:OPENI)
OPENIO=(?i:OPENIO)
OPENLOG=(?i:OPENLOG)
OPENO=(?i:OPENO)
OPLDAP=(?i:OPLDAP)
OPSOCK=(?i:OPSOCK)
OR=(?i:OR)
ORDER_BY=(?i:ORDER\ BY)
PARSE=(?i:PARSE)
PASSWORD=(?i:PASSWORD)
PAT=(?i:PAT)
PCOLOR=(?i:PCOLOR)
PI=(?i:PI)
PICK=(?i:PICK)
PICKBOX=(?i:PICKBOX)
PIKLTB=(?i:PIKLTB)
PMT=(?i:PMT)
POKLTB=(?i:POKLTB)
PRD=(?i:PRD)
PREV=(?i:PREV)
PROGCAN=(?i:PROGCAN)
PROGLDD=(?i:PROGLDD)
PROGSIZ=(?i:PROGSIZ)
PROGUSD=(?i:PROGUSD)
PULLOBJECT=(?i:PULLOBJECT)
PULLSCRIPT=(?i:PULLSCRIPT)
PUSHSCRIPT=(?i:PUSHSCRIPT)
PUTSEQ=(?i:PUTSEQ)
QSTBOX=(?i:QSTBOX)
RAZ=(?i:RAZ)
RDSEQ=(?i:RDSEQ)
READ=(?i:READ)
READLOCK=(?i:READLOCK)
REB=(?i:REB)
RECKEY=(?i:RECKEY)
RENAMEFILE=(?i:RENAMEFILE)
REPEAT=(?i:REPEAT)
REPORT=(?i:REPORT)
RESUME=(?i:RESUME)
RETURN=(?i:RETURN)
REVERTTOSNAPSHOT=(?i:REVERTTOSNAPSHOT)
REVERTTOSYSSNAPHOT=(?i:REVERTTOSYSSNAPHOT)
REVERTUPDTICK=(?i:REVERTUPDTICK)
REWRITE=(?i:REWRITE)
REWRITEBYKEY=(?i:REWRITEBYKEY)
RIGHT_=(?i:RIGHT\$)
RND=(?i:RND)
ROLLBACK=(?i:ROLLBACK)
ROWCOUNT=(?i:ROWCOUNT)
RPTFILE=(?i:RPTFILE)
RPTSTAT=(?i:RPTSTAT)
RUN=(?i:RUN)
SADMEM=(?i:SADMEM)
SAIZO=(?i:SAIZO)
SAXPARSE=(?i:SAXPARSE)
SCHAR=(?i:SCHAR)
SECMOD=(?i:SECMOD)
SEEK=(?i:SEEK)
SEG_=(?i:SEG\$)
SELDEST=(?i:SELDEST)
SELIMP=(?i:SELIMP)
SEND=(?i:SEND)
SETACCESSORENABLED=(?i:SETACCESSORENABLED)
SETBIT=(?i:SETBIT)
SETCOD=(?i:SETCOD)
SETFCT=(?i:SETFCT)
SETGUS=(?i:SETGUS)
SETINSTANCE=(?i:SETINSTANCE)
SETLBOX=(?i:SETLBOX)
SETLOB=(?i:SETLOB)
SETMDU=(?i:SETMDU)
SETMODE=(?i:SETMODE)
SETMOK=(?i:SETMOK)
SGN=(?i:SGN)
SH=(?i:SH)
SHORTINT=(?i:SHORTINT)
SIGMA=(?i:SIGMA)
SIN=(?i:SIN)
SIZED=(?i:SIZED)
SLEEP=(?i:SLEEP)
SNAPSHOT=(?i:SNAPSHOT)
SNAPSHOTENABLED=(?i:SNAPSHOTENABLED)
SORTA=(?i:SORTA)
SPACE_=(?i:SPACE\$)
SQL=(?i:SQL)
SQR=(?i:SQR)
SRLDAPBS=(?i:SRLDAPBS)
SRLDAPLV=(?i:SRLDAPLV)
SRLDAPTR=(?i:SRLDAPTR)
SSL=(?i:SSL)
STABILITY=(?i:STABILITY)
STARTING=(?i:STARTING)
STAT1=(?i:STAT1)
STATUS=(?i:STATUS)
STEP=(?i:STEP)
STRDECODE=(?i:STRDECODE)
STRENCODE=(?i:STRENCODE)
STRING_=(?i:STRING\$)
SUBPROG=(?i:SUBPROG)
SUM=(?i:SUM)
SUPLI=(?i:SUPLI)
SYRRECV=(?i:SYRRECV)
SYRSEND=(?i:SYRSEND)
SYSMODIFIED=(?i:SYSMODIFIED)
SYSSNAPSHOT=(?i:SYSSNAPSHOT)
SYSSNAPSHOTENABLED=(?i:SYSSNAPSHOTENABLED)
SYSTEM=(?i:SYSTEM)
TAB_=(?i:TAB\$)
TAIREC=(?i:TAIREC)
TAN=(?i:TAN)
TH=(?i:TH)
THEN=(?i:THEN)
THIS=(?i:THIS)
THROWERR=(?i:THROWERR)
TIME=(?i:TIME)
TIMESTAMP_=(?i:TIMESTAMP\$)
TIMEVAL=(?i:TIMEVAL)
TIME_=(?i:TIME\$)
TINYINT=(?i:TINYINT)
TITCOL=(?i:TITCOL)
TITLED=(?i:TITLED)
TITRE=(?i:TITRE)
TO=(?i:TO)
TOLOWER=(?i:TOLOWER)
TOSDATA=(?i:TOSDATA)
TOUPPER=(?i:TOUPPER)
TOUUID=(?i:TOUUID)
TRANSMASK=(?i:TRANSMASK)
TRBEGIN=(?i:TRBEGIN)
TREEBOX=(?i:TREEBOX)
TRTCOU=(?i:TRTCOU)
TYPE=(?i:TYPE)
TYPECTX=(?i:TYPECTX)
UNESCJSON=(?i:UNESCJSON)
UNI=(?i:UNI)
UNIQID=(?i:UNIQID)
UNLOCK=(?i:UNLOCK)
UNTIL=(?i:UNTIL)
UPDATE=(?i:UPDATE)
UPDTICK=(?i:UPDTICK)
USING=(?i:USING)
UUIDENT=(?i:UUIDENT)
UUID_=(?i:UUID\$)
VAL=(?i:VAL)
VALUE=(?i:VALUE)
VAR=(?i:VAR)
VARIABLE=(?i:VARIABLE)
VARINIT=(?i:VARINIT)
VARMODE=(?i:VARMODE)
VBCALL=(?i:VBCALL)
VER_=(?i:VER\$)
VIREBLC=(?i:VIREBLC)
WEEK=(?i:WEEK)
WEND=(?i:WEND)
WHEN=(?i:WHEN)
WHERE=(?i:WHERE)
WHILE=(?i:WHILE)
WITH=(?i:WITH)
WRITE=(?i:WRITE)
WRITEB=(?i:WRITEB)
WRNBOX=(?i:WRNBOX)
WRSEQ=(?i:WRSEQ)
XGETCHAR=(?i:XGETCHAR)
XOR=(?i:XOR)
YEAR=(?i:YEAR)
ZC=(?i:ZC)
ZONCOU=(?i:ZONCOU)
ZONSOR=(?i:ZONSOR)
ZONSUI=(?i:ZONSUI)

%%

{WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }
{CRLF}        { return NOX3Types.CRLF; }
{COMMENT}     { return NOX3Types.COMMENT; }

{ACH}          { return NOX3Types.ACH; }
{ACOS}          { return NOX3Types.ACOS; }
{ACTIHGUP}          { return NOX3Types.ACTIHGUP; }
{ACTZO}          { return NOX3Types.ACTZO; }
{ADDITM}          { return NOX3Types.ADDITM; }
{ADDMEN}          { return NOX3Types.ADDMEN; }
{ADDMONTH}          { return NOX3Types.ADDMONTH; }
{ADXCIO}          { return NOX3Types.ADXCIO; }
{ADXCPW}          { return NOX3Types.ADXCPW; }
{ADXCTX}          { return NOX3Types.ADXCTX; }
{ADXCUS}          { return NOX3Types.ADXCUS; }
{ADXDBC}          { return NOX3Types.ADXDBC; }
{ADXDBO}          { return NOX3Types.ADXDBO; }
{ADXDBX}          { return NOX3Types.ADXDBX; }
{ADXDCS}          { return NOX3Types.ADXDCS; }
{ADXDIR}          { return NOX3Types.ADXDIR; }
{ADXDLREC}          { return NOX3Types.ADXDLREC; }
{ADXDPG}          { return NOX3Types.ADXDPG; }
{ADXFMT}          { return NOX3Types.ADXFMT; }
{ADXFNAME}          { return NOX3Types.ADXFNAME; }
{ADXFTL}          { return NOX3Types.ADXFTL; }
{ADXGTB}          { return NOX3Types.ADXGTB; }
{ADXIFS}          { return NOX3Types.ADXIFS; }
{ADXIOA}          { return NOX3Types.ADXIOA; }
{ADXIRS}          { return NOX3Types.ADXIRS; }
{ADXIUM}          { return NOX3Types.ADXIUM; }
{ADXKPG}          { return NOX3Types.ADXKPG; }
{ADXKSP}          { return NOX3Types.ADXKSP; }
{ADXLIG}          { return NOX3Types.ADXLIG; }
{ADXLOG}          { return NOX3Types.ADXLOG; }
{ADXMAC}          { return NOX3Types.ADXMAC; }
{ADXMBM}          { return NOX3Types.ADXMBM; }
{ADXMDA}          { return NOX3Types.ADXMDA; }
{ADXMOTHER}          { return NOX3Types.ADXMOTHER; }
{ADXMPGPRO}          { return NOX3Types.ADXMPGPRO; }
{ADXMPGTRT}          { return NOX3Types.ADXMPGTRT; }
{ADXMPR}          { return NOX3Types.ADXMPR; }
{ADXMSO}          { return NOX3Types.ADXMSO; }
{ADXMTO}          { return NOX3Types.ADXMTO; }
{ADXMUA}          { return NOX3Types.ADXMUA; }
{ADXMXL}          { return NOX3Types.ADXMXL; }
{ADXNFS}          { return NOX3Types.ADXNFS; }
{ADXOVF}          { return NOX3Types.ADXOVF; }
{ADXOVS}          { return NOX3Types.ADXOVS; }
{ADXPAM}          { return NOX3Types.ADXPAM; }
{ADXPID}          { return NOX3Types.ADXPID; }
{ADXPNO}          { return NOX3Types.ADXPNO; }
{ADXROB}          { return NOX3Types.ADXROB; }
{ADXSAX}          { return NOX3Types.ADXSAX; }
{ADXSCA}          { return NOX3Types.ADXSCA; }
{ADXSEEK}          { return NOX3Types.ADXSEEK; }
{ADXSES}          { return NOX3Types.ADXSES; }
{ADXSQLREC}          { return NOX3Types.ADXSQLREC; }
{ADXTCP}          { return NOX3Types.ADXTCP; }
{ADXTCT}          { return NOX3Types.ADXTCT; }
{ADXTLK}          { return NOX3Types.ADXTLK; }
{ADXTMS}          { return NOX3Types.ADXTMS; }
{ADXTRL}          { return NOX3Types.ADXTRL; }
{ADXTRO}          { return NOX3Types.ADXTRO; }
{ADXTRP}          { return NOX3Types.ADXTRP; }
{ADXTUC}          { return NOX3Types.ADXTUC; }
{ADXTUL}          { return NOX3Types.ADXTUL; }
{ADXTUT}          { return NOX3Types.ADXTUT; }
{ADXTYP}          { return NOX3Types.ADXTYP; }
{ADXUID}          { return NOX3Types.ADXUID; }
{ADXUPREC}          { return NOX3Types.ADXUPREC; }
{ADXUSR}          { return NOX3Types.ADXUSR; }
{ADXWRB}          { return NOX3Types.ADXWRB; }
{AFFZO}          { return NOX3Types.AFFZO; }
{ALLOCGRP}          { return NOX3Types.ALLOCGRP; }
{ANASQL}          { return NOX3Types.ANASQL; }
{AND}          { return NOX3Types.AND; }
{ANP}          { return NOX3Types.ANP; }
{APPEND}          { return NOX3Types.APPEND; }
{AR2}          { return NOX3Types.AR2; }
{ARR}          { return NOX3Types.ARR; }
{AS}          { return NOX3Types.AS; }
{ASC}          { return NOX3Types.ASC; }
{ASCII}          { return NOX3Types.ASCII; }
{ASH}          { return NOX3Types.ASH; }
{ASIN}          { return NOX3Types.ASIN; }
{ASKUI}          { return NOX3Types.ASKUI; }
{ASSIGN}          { return NOX3Types.ASSIGN; }
{AT}          { return NOX3Types.AT; }
{ATAN}          { return NOX3Types.ATAN; }
{ATAN2}          { return NOX3Types.ATAN2; }
{ATH}          { return NOX3Types.ATH; }
{AVG}          { return NOX3Types.AVG; }
{AWEEK}          { return NOX3Types.AWEEK; }
{B64DECODE}          { return NOX3Types.B64DECODE; }
{B64ENCODE}          { return NOX3Types.B64ENCODE; }
{BLBFILE}          { return NOX3Types.BLBFILE; }
{BLK}          { return NOX3Types.BLK; }
{BOXACT}          { return NOX3Types.BOXACT; }
{BOXCLR}          { return NOX3Types.BOXCLR; }
{BOXINP}          { return NOX3Types.BOXINP; }
{BREAK}          { return NOX3Types.BREAK; }
{BUTTON}          { return NOX3Types.BUTTON; }
{BY}          { return NOX3Types.BY; }
{CALL}          { return NOX3Types.CALL; }
{CALLILOG}          { return NOX3Types.CALLILOG; }
{CALLIU}          { return NOX3Types.CALLIU; }
{CALLMET}          { return NOX3Types.CALLMET; }
{CALLOCX}          { return NOX3Types.CALLOCX; }
{CALLSTACK}          { return NOX3Types.CALLSTACK; }
{CALLUI}          { return NOX3Types.CALLUI; }
{CALLWS}          { return NOX3Types.CALLWS; }
{CASE}          { return NOX3Types.CASE; }
{CAST}          { return NOX3Types.CAST; }
{CH}          { return NOX3Types.CH; }
{CHAIN}          { return NOX3Types.CHAIN; }
{CHAR}          { return NOX3Types.CHAR; }
{CHECKIN}          { return NOX3Types.CHECKIN; }
{CHECKPATH}          { return NOX3Types.CHECKPATH; }
{CHGFMT}          { return NOX3Types.CHGFMT; }
{CHGSTL}          { return NOX3Types.CHGSTL; }
{CHGTBK}          { return NOX3Types.CHGTBK; }
{CHGTFD}          { return NOX3Types.CHGTFD; }
{CHGTZN}          { return NOX3Types.CHGTZN; }
{CHOOSE}          { return NOX3Types.CHOOSE; }
{CHR_}          { return NOX3Types.CHR_; }
{CLACMP}          { return NOX3Types.CLACMP; }
{CLACTXNBS}          { return NOX3Types.CLACTXNBS; }
{CLACTXVAR}          { return NOX3Types.CLACTXVAR; }
{CLALEV}          { return NOX3Types.CLALEV; }
{CLANAM}          { return NOX3Types.CLANAM; }
{CLANBS}          { return NOX3Types.CLANBS; }
{CLASIZ}          { return NOX3Types.CLASIZ; }
{CLAVAR}          { return NOX3Types.CLAVAR; }
{CLBFILE}          { return NOX3Types.CLBFILE; }
{CLLDAP}          { return NOX3Types.CLLDAP; }
{CLONE}          { return NOX3Types.CLONE; }
{CLOSE}          { return NOX3Types.CLOSE; }
{CLOSECOM}          { return NOX3Types.CLOSECOM; }
{CLOSELOG}          { return NOX3Types.CLOSELOG; }
{CLOSEXML}          { return NOX3Types.CLOSEXML; }
{CNP}          { return NOX3Types.CNP; }
{CODED}          { return NOX3Types.CODED; }
{COLUMNS}          { return NOX3Types.COLUMNS; }
{COMMIT}          { return NOX3Types.COMMIT; }
{CONST}          { return NOX3Types.CONST; }
{CONVXML}          { return NOX3Types.CONVXML; }
{COP_}          { return NOX3Types.COP_; }
{COS}          { return NOX3Types.COS; }
{CTRANS}          { return NOX3Types.CTRANS; }
{CTXINFO}          { return NOX3Types.CTXINFO; }
{CURR}          { return NOX3Types.CURR; }
{CURRBOX}          { return NOX3Types.CURRBOX; }
{CURRIND}          { return NOX3Types.CURRIND; }
{CURRLEN}          { return NOX3Types.CURRLEN; }
{DATE}          { return NOX3Types.DATE; }
{DATESYST}          { return NOX3Types.DATESYST; }
{DATETIME}          { return NOX3Types.DATETIME; }
{DATETIME_}          { return NOX3Types.DATETIME_; }
{DATE_}          { return NOX3Types.DATE_; }
{DAY}          { return NOX3Types.DAY; }
{DAYN}          { return NOX3Types.DAYN; }
{DAY_}          { return NOX3Types.DAY_; }
{DBGAFF}          { return NOX3Types.DBGAFF; }
{DBGATTACH}          { return NOX3Types.DBGATTACH; }
{DBGBOX}          { return NOX3Types.DBGBOX; }
{DBGBREAKPOINTADD}          { return NOX3Types.DBGBREAKPOINTADD; }
{DBGBREAKPOINTGET}          { return NOX3Types.DBGBREAKPOINTGET; }
{DBGBREAKPOINTLIST}          { return NOX3Types.DBGBREAKPOINTLIST; }
{DBGBREAKPOINTREMOVE}          { return NOX3Types.DBGBREAKPOINTREMOVE; }
{DBGBREAKPOINTUPDATE}          { return NOX3Types.DBGBREAKPOINTUPDATE; }
{DBGCALLSTACK}          { return NOX3Types.DBGCALLSTACK; }
{DBGDURATION}          { return NOX3Types.DBGDURATION; }
{DBGEVALUE}          { return NOX3Types.DBGEVALUE; }
{DBGEVALUE2}          { return NOX3Types.DBGEVALUE2; }
{DBGEXCEPT}          { return NOX3Types.DBGEXCEPT; }
{DBGLINEOFFSET}          { return NOX3Types.DBGLINEOFFSET; }
{DBGLOG}          { return NOX3Types.DBGLOG; }
{DBGLONG}          { return NOX3Types.DBGLONG; }
{DBGMODE}          { return NOX3Types.DBGMODE; }
{DBGSTR}          { return NOX3Types.DBGSTR; }
{DCLKEY}          { return NOX3Types.DCLKEY; }
{DECIMAL}          { return NOX3Types.DECIMAL; }
{DEFAULT}          { return NOX3Types.DEFAULT; }
{DELA}          { return NOX3Types.DELA; }
{DELETE}          { return NOX3Types.DELETE; }
{DELETEBYKEY}          { return NOX3Types.DELETEBYKEY; }
{DELFILE}          { return NOX3Types.DELFILE; }
{DESC}          { return NOX3Types.DESC; }
{DIM}          { return NOX3Types.DIM; }
{DIMCTX}          { return NOX3Types.DIMCTX; }
{DIR_}          { return NOX3Types.DIR_; }
{DISABLE}          { return NOX3Types.DISABLE; }
{DISCOMBO}          { return NOX3Types.DISCOMBO; }
{DISLBOX}          { return NOX3Types.DISLBOX; }
{DISZO}          { return NOX3Types.DISZO; }
{DLGBOX}          { return NOX3Types.DLGBOX; }
{DOUBLE}          { return NOX3Types.DOUBLE; }
{DSPZO}          { return NOX3Types.DSPZO; }
{EDI}          { return NOX3Types.EDI; }
{EFFZO}          { return NOX3Types.EFFZO; }
{ELSE}          { return NOX3Types.ELSE; }
{ELSIF}          { return NOX3Types.ELSIF; }
{ENABLE}          { return NOX3Types.ENABLE; }
{END}          { return NOX3Types.END; }
{ENDBOX}          { return NOX3Types.ENDBOX; }
{ENDCASE}          { return NOX3Types.ENDCASE; }
{ENDIF}          { return NOX3Types.ENDIF; }
{ENTETE}          { return NOX3Types.ENTETE; }
{ENVZO}          { return NOX3Types.ENVZO; }
{EOMONTH}          { return NOX3Types.EOMONTH; }
{ERRBOX}          { return NOX3Types.ERRBOX; }
{ERRL}          { return NOX3Types.ERRL; }
{ERRM}          { return NOX3Types.ERRM; }
{ERRMES_}          { return NOX3Types.ERRMES_; }
{ERRN}          { return NOX3Types.ERRN; }
{ERRNREMOTE}          { return NOX3Types.ERRNREMOTE; }
{ERRP}          { return NOX3Types.ERRP; }
{ESCJSON}          { return NOX3Types.ESCJSON; }
{EVALUE}          { return NOX3Types.EVALUE; }
{EVALUESDATA}          { return NOX3Types.EVALUESDATA; }
{EXECSQL}          { return NOX3Types.EXECSQL; }
{EXECWS}          { return NOX3Types.EXECWS; }
{EXP}          { return NOX3Types.EXP; }
{EXTENDED}          { return NOX3Types.EXTENDED; }
{EXTERN}          { return NOX3Types.EXTERN; }
{EXTSIZE}          { return NOX3Types.EXTSIZE; }
{FAC}          { return NOX3Types.FAC; }
{FIELD}          { return NOX3Types.FIELD; }
{FILCOM}          { return NOX3Types.FILCOM; }
{FILE}          { return NOX3Types.FILE; }
{FILEABRE}          { return NOX3Types.FILEABRE; }
{FILECLA}          { return NOX3Types.FILECLA; }
{FILELEV}          { return NOX3Types.FILELEV; }
{FILENAME}          { return NOX3Types.FILENAME; }
{FILENUME}          { return NOX3Types.FILENUME; }
{FILETYP}          { return NOX3Types.FILETYP; }
{FILEXIST}          { return NOX3Types.FILEXIST; }
{FILINFO}          { return NOX3Types.FILINFO; }
{FILLBOX}          { return NOX3Types.FILLBOX; }
{FILPATH}          { return NOX3Types.FILPATH; }
{FILTER}          { return NOX3Types.FILTER; }
{FIND}          { return NOX3Types.FIND; }
{FIRST}          { return NOX3Types.FIRST; }
{FIX}          { return NOX3Types.FIX; }
{FLOAT}          { return NOX3Types.FLOAT; }
{FLUSH}          { return NOX3Types.FLUSH; }
{FMET}          { return NOX3Types.FMET; }
{FMETHOD}          { return NOX3Types.FMETHOD; }
{FOLDER}          { return NOX3Types.FOLDER; }
{FOR}          { return NOX3Types.FOR; }
{FORMAT_}          { return NOX3Types.FORMAT_; }
{FORMULA}          { return NOX3Types.FORMULA; }
{FREEGROUP}          { return NOX3Types.FREEGROUP; }
{FREEHEAP}          { return NOX3Types.FREEHEAP; }
{FREEINSTANCE}          { return NOX3Types.FREEINSTANCE; }
{FREEMEM}          { return NOX3Types.FREEMEM; }
{FREESNAPSHOT}          { return NOX3Types.FREESNAPSHOT; }
{FREESYSSNAPSHOT}          { return NOX3Types.FREESYSSNAPSHOT; }
{FROM}          { return NOX3Types.FROM; }
{FSTAT}          { return NOX3Types.FSTAT; }
{FUNC}          { return NOX3Types.FUNC; }
{FUNCIU}          { return NOX3Types.FUNCIU; }
{FUNPROG}          { return NOX3Types.FUNPROG; }
{GDATETIME_}          { return NOX3Types.GDATETIME_; }
{GDAT_}          { return NOX3Types.GDAT_; }
{GETACCESSORENABLED}          { return NOX3Types.GETACCESSORENABLED; }
{GETBIT}          { return NOX3Types.GETBIT; }
{GETCHILDBYNAME}          { return NOX3Types.GETCHILDBYNAME; }
{GETCHILDBYTYPE}          { return NOX3Types.GETCHILDBYTYPE; }
{GETENV_}          { return NOX3Types.GETENV_; }
{GETFIRSTCHILD}          { return NOX3Types.GETFIRSTCHILD; }
{GETFIRSTCHILDBYNAME}          { return NOX3Types.GETFIRSTCHILDBYNAME; }
{GETLASTCHILD}          { return NOX3Types.GETLASTCHILD; }
{GETLASTCHILDBYNAME}          { return NOX3Types.GETLASTCHILDBYNAME; }
{GETLOGNAME}          { return NOX3Types.GETLOGNAME; }
{GETMODIFIED}          { return NOX3Types.GETMODIFIED; }
{GETNBCHILD}          { return NOX3Types.GETNBCHILD; }
{GETNEXTCHILD}          { return NOX3Types.GETNEXTCHILD; }
{GETNEXTCHILDBYNAME}          { return NOX3Types.GETNEXTCHILDBYNAME; }
{GETPARENT}          { return NOX3Types.GETPARENT; }
{GETROOTELEMENT}          { return NOX3Types.GETROOTELEMENT; }
{GETSEQ}          { return NOX3Types.GETSEQ; }
{GETSYSMODIFIED}          { return NOX3Types.GETSYSMODIFIED; }
{GETUI}          { return NOX3Types.GETUI; }
{GETUUID}          { return NOX3Types.GETUUID; }
{GLOBAL}          { return NOX3Types.GLOBAL; }
{GOSUB}          { return NOX3Types.GOSUB; }
{GOTO}          { return NOX3Types.GOTO; }
{GRAPH_}          { return NOX3Types.GRAPH_; }
{GRIZO}          { return NOX3Types.GRIZO; }
{HEAPDMP}          { return NOX3Types.HEAPDMP; }
{HINT}          { return NOX3Types.HINT; }
{HLPBOX}          { return NOX3Types.HLPBOX; }
{IF}          { return NOX3Types.IF; }
{IMAGE}          { return NOX3Types.IMAGE; }
{INDCUM}          { return NOX3Types.INDCUM; }
{INDICE}          { return NOX3Types.INDICE; }
{INFBOX}          { return NOX3Types.INFBOX; }
{INFIMG}          { return NOX3Types.INFIMG; }
{INFTXT}          { return NOX3Types.INFTXT; }
{INPBOX}          { return NOX3Types.INPBOX; }
{INPMODE}          { return NOX3Types.INPMODE; }
{INSA}          { return NOX3Types.INSA; }
{INSLI}          { return NOX3Types.INSLI; }
{INSTANCE}          { return NOX3Types.INSTANCE; }
{INSTR}          { return NOX3Types.INSTR; }
{INT}          { return NOX3Types.INT; }
{INTEGER}          { return NOX3Types.INTEGER; }
{INTER}          { return NOX3Types.INTER; }
{INVFOL}          { return NOX3Types.INVFOL; }
{IOMODE}          { return NOX3Types.IOMODE; }
{ISOMESS}          { return NOX3Types.ISOMESS; }
{ISOPENADXD}          { return NOX3Types.ISOPENADXD; }
{ISREADONLY}          { return NOX3Types.ISREADONLY; }
{JSONPROTO}          { return NOX3Types.JSONPROTO; }
{KEY}          { return NOX3Types.KEY; }
{KEYLEN}          { return NOX3Types.KEYLEN; }
{KEYNAME}          { return NOX3Types.KEYNAME; }
{KEYUNIQ}          { return NOX3Types.KEYUNIQ; }
{KILL}          { return NOX3Types.KILL; }
{LAST}          { return NOX3Types.LAST; }
{LEFTBOX}          { return NOX3Types.LEFTBOX; }
{LEFT_}          { return NOX3Types.LEFT_; }
{LEN}          { return NOX3Types.LEN; }
{LIBELLE}          { return NOX3Types.LIBELLE; }
{LINK}          { return NOX3Types.LINK; }
{LISTBOX}          { return NOX3Types.LISTBOX; }
{LISTIMP}          { return NOX3Types.LISTIMP; }
{LN}          { return NOX3Types.LN; }
{LOBSIZE}          { return NOX3Types.LOBSIZE; }
{LOCAL}          { return NOX3Types.LOCAL; }
{LOCFSHOST}          { return NOX3Types.LOCFSHOST; }
{LOCFSQON}          { return NOX3Types.LOCFSQON; }
{LOCFSQPORT}          { return NOX3Types.LOCFSQPORT; }
{LOCK}          { return NOX3Types.LOCK; }
{LOCKWAIT}          { return NOX3Types.LOCKWAIT; }
{LOG}          { return NOX3Types.LOG; }
{LOGICCLOSE}          { return NOX3Types.LOGICCLOSE; }
{LOOK}          { return NOX3Types.LOOK; }
{MASK}          { return NOX3Types.MASK; }
{MASKABR}          { return NOX3Types.MASKABR; }
{MASKCLA}          { return NOX3Types.MASKCLA; }
{MASKCOU}          { return NOX3Types.MASKCOU; }
{MASKLEV}          { return NOX3Types.MASKLEV; }
{MASKNAM}          { return NOX3Types.MASKNAM; }
{MASKNBF}          { return NOX3Types.MASKNBF; }
{MASKRK}          { return NOX3Types.MASKRK; }
{MASKSIZ}          { return NOX3Types.MASKSIZ; }
{MAX}          { return NOX3Types.MAX; }
{MAXHEAP}          { return NOX3Types.MAXHEAP; }
{MAXMEM}          { return NOX3Types.MAXMEM; }
{MAXROWS}          { return NOX3Types.MAXROWS; }
{MAXTAB}          { return NOX3Types.MAXTAB; }
{MEN}          { return NOX3Types.MEN; }
{MENCHOIX}          { return NOX3Types.MENCHOIX; }
{MESBOX}          { return NOX3Types.MESBOX; }
{MESS}          { return NOX3Types.MESS; }
{MESSNAME}          { return NOX3Types.MESSNAME; }
{METHOD}          { return NOX3Types.METHOD; }
{MID_}          { return NOX3Types.MID_; }
{MIN}          { return NOX3Types.MIN; }
{MKSTAT}          { return NOX3Types.MKSTAT; }
{MOD}          { return NOX3Types.MOD; }
{MODIFIED}          { return NOX3Types.MODIFIED; }
{MONTH}          { return NOX3Types.MONTH; }
{MONTH_}          { return NOX3Types.MONTH_; }
{NAP}          { return NOX3Types.NAP; }
{NBIND}          { return NOX3Types.NBIND; }
{NBRECORD}          { return NOX3Types.NBRECORD; }
{NBRUSER}          { return NOX3Types.NBRUSER; }
{NBZON}          { return NOX3Types.NBZON; }
{NDAY}          { return NOX3Types.NDAY; }
{NDAY_}          { return NOX3Types.NDAY_; }
{NEWINSTANCE}          { return NOX3Types.NEWINSTANCE; }
{NEXT}          { return NOX3Types.NEXT; }
{NOHINT}          { return NOX3Types.NOHINT; }
{NOINTER}          { return NOX3Types.NOINTER; }
{NOLIGN}          { return NOX3Types.NOLIGN; }
{NOLIGN1}          { return NOX3Types.NOLIGN1; }
{NOMAP}          { return NOX3Types.NOMAP; }
{NOT}          { return NOX3Types.NOT; }
{NULL}          { return NOX3Types.NULL; }
{NULLUUID}          { return NOX3Types.NULLUUID; }
{NUM_}          { return NOX3Types.NUM_; }
{NXLDAP}          { return NOX3Types.NXLDAP; }
{NXT}          { return NOX3Types.NXT; }
{OBJECTEXIST}          { return NOX3Types.OBJECTEXIST; }
{OBJECTNBS}          { return NOX3Types.OBJECTNBS; }
{OBJECTTYPE}          { return NOX3Types.OBJECTTYPE; }
{OBJECTVAR}          { return NOX3Types.OBJECTVAR; }
{ONERRGO}          { return NOX3Types.ONERRGO; }
{ONEVENT}          { return NOX3Types.ONEVENT; }
{ONINTGO}          { return NOX3Types.ONINTGO; }
{ONKEY}          { return NOX3Types.ONKEY; }
{OPADXD}          { return NOX3Types.OPADXD; }
{OPENI}          { return NOX3Types.OPENI; }
{OPENIO}          { return NOX3Types.OPENIO; }
{OPENLOG}          { return NOX3Types.OPENLOG; }
{OPENO}          { return NOX3Types.OPENO; }
{OPLDAP}          { return NOX3Types.OPLDAP; }
{OPSOCK}          { return NOX3Types.OPSOCK; }
{OR}          { return NOX3Types.OR; }
{ORDER_BY}          { return NOX3Types.ORDER_BY; }
{PARSE}          { return NOX3Types.PARSE; }
{PASSWORD}          { return NOX3Types.PASSWORD; }
{PAT}          { return NOX3Types.PAT; }
{PCOLOR}          { return NOX3Types.PCOLOR; }
{PI}          { return NOX3Types.PI; }
{PICK}          { return NOX3Types.PICK; }
{PICKBOX}          { return NOX3Types.PICKBOX; }
{PIKLTB}          { return NOX3Types.PIKLTB; }
{PMT}          { return NOX3Types.PMT; }
{POKLTB}          { return NOX3Types.POKLTB; }
{PRD}          { return NOX3Types.PRD; }
{PREV}          { return NOX3Types.PREV; }
{PROGCAN}          { return NOX3Types.PROGCAN; }
{PROGLDD}          { return NOX3Types.PROGLDD; }
{PROGSIZ}          { return NOX3Types.PROGSIZ; }
{PROGUSD}          { return NOX3Types.PROGUSD; }
{PULLOBJECT}          { return NOX3Types.PULLOBJECT; }
{PULLSCRIPT}          { return NOX3Types.PULLSCRIPT; }
{PUSHSCRIPT}          { return NOX3Types.PUSHSCRIPT; }
{PUTSEQ}          { return NOX3Types.PUTSEQ; }
{QSTBOX}          { return NOX3Types.QSTBOX; }
{RAZ}          { return NOX3Types.RAZ; }
{RDSEQ}          { return NOX3Types.RDSEQ; }
{READ}          { return NOX3Types.READ; }
{READLOCK}          { return NOX3Types.READLOCK; }
{REB}          { return NOX3Types.REB; }
{RECKEY}          { return NOX3Types.RECKEY; }
{RENAMEFILE}          { return NOX3Types.RENAMEFILE; }
{REPEAT}          { return NOX3Types.REPEAT; }
{REPORT}          { return NOX3Types.REPORT; }
{RESUME}          { return NOX3Types.RESUME; }
{RETURN}          { return NOX3Types.RETURN; }
{REVERTTOSNAPSHOT}          { return NOX3Types.REVERTTOSNAPSHOT; }
{REVERTTOSYSSNAPHOT}          { return NOX3Types.REVERTTOSYSSNAPHOT; }
{REVERTUPDTICK}          { return NOX3Types.REVERTUPDTICK; }
{REWRITE}          { return NOX3Types.REWRITE; }
{REWRITEBYKEY}          { return NOX3Types.REWRITEBYKEY; }
{RIGHT_}          { return NOX3Types.RIGHT_; }
{RND}          { return NOX3Types.RND; }
{ROLLBACK}          { return NOX3Types.ROLLBACK; }
{ROWCOUNT}          { return NOX3Types.ROWCOUNT; }
{RPTFILE}          { return NOX3Types.RPTFILE; }
{RPTSTAT}          { return NOX3Types.RPTSTAT; }
{RUN}          { return NOX3Types.RUN; }
{SADMEM}          { return NOX3Types.SADMEM; }
{SAIZO}          { return NOX3Types.SAIZO; }
{SAXPARSE}          { return NOX3Types.SAXPARSE; }
{SCHAR}          { return NOX3Types.SCHAR; }
{SECMOD}          { return NOX3Types.SECMOD; }
{SEEK}          { return NOX3Types.SEEK; }
{SEG_}          { return NOX3Types.SEG_; }
{SELDEST}          { return NOX3Types.SELDEST; }
{SELIMP}          { return NOX3Types.SELIMP; }
{SEND}          { return NOX3Types.SEND; }
{SETACCESSORENABLED}          { return NOX3Types.SETACCESSORENABLED; }
{SETBIT}          { return NOX3Types.SETBIT; }
{SETCOD}          { return NOX3Types.SETCOD; }
{SETFCT}          { return NOX3Types.SETFCT; }
{SETGUS}          { return NOX3Types.SETGUS; }
{SETINSTANCE}          { return NOX3Types.SETINSTANCE; }
{SETLBOX}          { return NOX3Types.SETLBOX; }
{SETLOB}          { return NOX3Types.SETLOB; }
{SETMDU}          { return NOX3Types.SETMDU; }
{SETMODE}          { return NOX3Types.SETMODE; }
{SETMOK}          { return NOX3Types.SETMOK; }
{SGN}          { return NOX3Types.SGN; }
{SH}          { return NOX3Types.SH; }
{SHORTINT}          { return NOX3Types.SHORTINT; }
{SIGMA}          { return NOX3Types.SIGMA; }
{SIN}          { return NOX3Types.SIN; }
{SIZED}          { return NOX3Types.SIZED; }
{SLEEP}          { return NOX3Types.SLEEP; }
{SNAPSHOT}          { return NOX3Types.SNAPSHOT; }
{SNAPSHOTENABLED}          { return NOX3Types.SNAPSHOTENABLED; }
{SORTA}          { return NOX3Types.SORTA; }
{SPACE_}          { return NOX3Types.SPACE_; }
{SQL}          { return NOX3Types.SQL; }
{SQR}          { return NOX3Types.SQR; }
{SRLDAPBS}          { return NOX3Types.SRLDAPBS; }
{SRLDAPLV}          { return NOX3Types.SRLDAPLV; }
{SRLDAPTR}          { return NOX3Types.SRLDAPTR; }
{SSL}          { return NOX3Types.SSL; }
{STABILITY}          { return NOX3Types.STABILITY; }
{STARTING}          { return NOX3Types.STARTING; }
{STAT1}          { return NOX3Types.STAT1; }
{STATUS}          { return NOX3Types.STATUS; }
{STEP}          { return NOX3Types.STEP; }
{STRDECODE}          { return NOX3Types.STRDECODE; }
{STRENCODE}          { return NOX3Types.STRENCODE; }
{STRING_}          { return NOX3Types.STRING_; }
{SUBPROG}          { return NOX3Types.SUBPROG; }
{SUM}          { return NOX3Types.SUM; }
{SUPLI}          { return NOX3Types.SUPLI; }
{SYRRECV}          { return NOX3Types.SYRRECV; }
{SYRSEND}          { return NOX3Types.SYRSEND; }
{SYSMODIFIED}          { return NOX3Types.SYSMODIFIED; }
{SYSSNAPSHOT}          { return NOX3Types.SYSSNAPSHOT; }
{SYSSNAPSHOTENABLED}          { return NOX3Types.SYSSNAPSHOTENABLED; }
{SYSTEM}          { return NOX3Types.SYSTEM; }
{TAB_}          { return NOX3Types.TAB_; }
{TAIREC}          { return NOX3Types.TAIREC; }
{TAN}          { return NOX3Types.TAN; }
{TH}          { return NOX3Types.TH; }
{THEN}          { return NOX3Types.THEN; }
{THIS}          { return NOX3Types.THIS; }
{THROWERR}          { return NOX3Types.THROWERR; }
{TIME}          { return NOX3Types.TIME; }
{TIMESTAMP_}          { return NOX3Types.TIMESTAMP_; }
{TIMEVAL}          { return NOX3Types.TIMEVAL; }
{TIME_}          { return NOX3Types.TIME_; }
{TINYINT}          { return NOX3Types.TINYINT; }
{TITCOL}          { return NOX3Types.TITCOL; }
{TITLED}          { return NOX3Types.TITLED; }
{TITRE}          { return NOX3Types.TITRE; }
{TO}          { return NOX3Types.TO; }
{TOLOWER}          { return NOX3Types.TOLOWER; }
{TOSDATA}          { return NOX3Types.TOSDATA; }
{TOUPPER}          { return NOX3Types.TOUPPER; }
{TOUUID}          { return NOX3Types.TOUUID; }
{TRANSMASK}          { return NOX3Types.TRANSMASK; }
{TRBEGIN}          { return NOX3Types.TRBEGIN; }
{TREEBOX}          { return NOX3Types.TREEBOX; }
{TRTCOU}          { return NOX3Types.TRTCOU; }
{TYPE}          { return NOX3Types.TYPE; }
{TYPECTX}          { return NOX3Types.TYPECTX; }
{UNESCJSON}          { return NOX3Types.UNESCJSON; }
{UNI}          { return NOX3Types.UNI; }
{UNIQID}          { return NOX3Types.UNIQID; }
{UNLOCK}          { return NOX3Types.UNLOCK; }
{UNTIL}          { return NOX3Types.UNTIL; }
{UPDATE}          { return NOX3Types.UPDATE; }
{UPDTICK}          { return NOX3Types.UPDTICK; }
{USING}          { return NOX3Types.USING; }
{UUIDENT}          { return NOX3Types.UUIDENT; }
{UUID_}          { return NOX3Types.UUID_; }
{VAL}          { return NOX3Types.VAL; }
{VALUE}          { return NOX3Types.VALUE; }
{VAR}          { return NOX3Types.VAR; }
{VARIABLE}          { return NOX3Types.VARIABLE; }
{VARINIT}          { return NOX3Types.VARINIT; }
{VARMODE}          { return NOX3Types.VARMODE; }
{VBCALL}          { return NOX3Types.VBCALL; }
{VER_}          { return NOX3Types.VER_; }
{VIREBLC}          { return NOX3Types.VIREBLC; }
{WEEK}          { return NOX3Types.WEEK; }
{WEND}          { return NOX3Types.WEND; }
{WHEN}          { return NOX3Types.WHEN; }
{WHERE}          { return NOX3Types.WHERE; }
{WHILE}          { return NOX3Types.WHILE; }
{WITH}          { return NOX3Types.WITH; }
{WRITE}          { return NOX3Types.WRITE; }
{WRITEB}          { return NOX3Types.WRITEB; }
{WRNBOX}          { return NOX3Types.WRNBOX; }
{WRSEQ}          { return NOX3Types.WRSEQ; }
{XGETCHAR}          { return NOX3Types.XGETCHAR; }
{XOR}          { return NOX3Types.XOR; }
{YEAR}          { return NOX3Types.YEAR; }
{ZC}          { return NOX3Types.ZC; }
{ZONCOU}          { return NOX3Types.ZONCOU; }
{ZONSOR}          { return NOX3Types.ZONSOR; }
{ZONSUI}          { return NOX3Types.ZONSUI; }

"="           { return NOX3Types.SEPARATOR; }
{STRING}      { return NOX3Types.STRING; }
{NUMBER}      { return NOX3Types.NUMBER; }
{IDENTIFIER}  { return NOX3Types.IDENTIFIER; }

[^]           { return TokenType.BAD_CHARACTER; }

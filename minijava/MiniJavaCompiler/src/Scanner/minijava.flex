package Scanner;

import java_cup.runtime.*;
import Parser.sym;

%%

%public
%final
%class scanner
%unicode
%cup
%line
%column

%{

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  public String symbolToString(Symbol s) {
    switch (s.sym) {
      case sym.PROTECTED: return "PROTECTED";
      case sym.PRIVATE: return "PRIVATE";
      case sym.INSTANCEOF: return "INSTANCEOF";
      case sym.DIFBECOMES: return "DIFBECOMES";
      case sym.SUPER: return "SUPER";
      case sym.BECOMESBECOMES: return "BECOMESBECOMES";
      case sym.BECOMES: return "BECOMES";
      case sym.SEMICOLON: return "SEMICOLON";
      case sym.PLUS: return "PLUS";
      case sym.MINUS: return "MINUS";
      case sym.TIMES: return "TIMES";
      case sym.AND: return "AND";
      case sym.LT: return "LT";
      case sym.RT: return "RT";
      case sym.RTEQ: return "RTEQ";
      case sym.LTEQ: return "LTEQ";
      case sym.LPAREN: return "LPAREN";
      case sym.RPAREN: return "RPAREN";
      case sym.LBRACKET: return "LBRACKET";
      case sym.RBRACKET: return "RBRACKET";
      case sym.LBRACE: return "LBRACE";
      case sym.RBRACE: return "RBRACE";
      case sym.RETURN: return "RETURN";
      case sym.IDENTIFIER: return "ID(" + (String)s.value + ")";
      case sym.INTEGER_LITERAL: return "INTEGER_LITERAL(" + s.value + ")";
      case sym.BOOLEAN_TYPE: return "BOOLEAN";
      case sym.INTEGER_TYPE: return "INTEGER";
      case sym.IF: return "IF";
      case sym.NOT: return "NOT";
      case sym.DOT: return "DOT";
      case sym.COMMA: return "COMMA";
      case sym.STRING: return "STRING";
      case sym.SYSTEM_OUT_PRINTLN: return "SYSTEM_OUT_PRINTLN";
      case sym.ELSE: return "ELSE";
      case sym.WHILE: return "WHILE";
      case sym.CLASS: return "CLASS";
      case sym.EXTENDS: return "EXTENDS";
      case sym.PUBLIC: return "PUBLIC";
      case sym.STATIC: return "STATIC";
      case sym.VOID: return "VOID";
      case sym.MAIN: return "MAIN";
      case sym.TRUE: return "TRUE";
      case sym.FALSE: return "FALSE";
      case sym.LENGTH: return "LENGTH";
      case sym.THIS: return "THIS";
      case sym.NEW: return "NEW";
      case sym.EOF: return "<EOF>";
      case sym.error: return "<ERROR>";
      default: return "<UNEXPECTED TOKEN " + s.toString() + ">";
    }
  }
%}

/* Letra, digitos, espa�o em branco, entrer e quebra de linha */
letter = [a-zA-Z]
digit = [0-9]
eol = [\r\n]
not_eol = [^\r\n]

/* tab com quebra de linha*/
white = {eol}|[ \t]

/* Comentarios */
start_comment = "/*"
comment_contents = ([^*]|\*[^/])
end_comment = "*/"

%%

/* Token definitions */

/* not eol varias vezes ou eol */
"//"{not_eol}*{eol} { /* do nothing */ }


/* Comentarios */
{start_comment}{comment_contents}*{end_comment} { /* do nothing */ }

/* Palavras reservadas */

/* Tipos*/
"boolean" { return symbol(sym.BOOLEAN_TYPE); }
"int" { return symbol(sym.INTEGER_TYPE); }
"true" { return symbol(sym.TRUE); }
"false" { return symbol(sym.FALSE); }
"String" { return symbol(sym.STRING); }

/* control flow */
"if" { return symbol(sym.IF); }
"else" { return symbol(sym.ELSE); }
"while" { return symbol(sym.WHILE); }
"return" { return symbol(sym.RETURN); }
"System"{white}*"."{white}*"out"{white}*"."{white}*"println" {
    return symbol(sym.SYSTEM_OUT_PRINTLN);
}

/* Declaracoes */
"class" { return symbol(sym.CLASS); }
"extends" { return symbol(sym.EXTENDS); }
"public" { return symbol(sym.PUBLIC); }
"static" { return symbol(sym.STATIC); }
"void" { return symbol(sym.VOID); }
"main" { return symbol(sym.MAIN); }
"length" { return symbol(sym.LENGTH); }
"this" { return symbol(sym.THIS); }
"new" { return symbol(sym.NEW); }
"super" { return symbol(sym.SUPER); }
"instanceof" { return symbol(sym.INSTANCEOF); }
"private" { return symbol(sym.PRIVATE); }
"protected" { return symbol(sym.PROTECTED); }

/* literals */
{digit}+ { return symbol(sym.INTEGER_LITERAL, new Integer(yytext())); }


/* Operadoes */
"+" { return symbol(sym.PLUS); }
"-" { return symbol(sym.MINUS); }
"*" { return symbol(sym.TIMES); }
"&&" { return symbol(sym.AND); }
"<" { return symbol(sym.LT); }
">" { return symbol(sym.RT); }
"!" { return symbol(sym.NOT); }
"." { return symbol(sym.DOT); }
"," { return symbol(sym.COMMA); }
"=" { return symbol(sym.BECOMES); }
"==" { return symbol(sym.BECOMESBECOMES); }



/* Delimitadores */
"(" { return symbol(sym.LPAREN); }
")" { return symbol(sym.RPAREN); }
"[" { return symbol(sym.LBRACKET); }
"]" { return symbol(sym.RBRACKET); }
"{" { return symbol(sym.LBRACE); }
"}" { return symbol(sym.RBRACE); }
";" { return symbol(sym.SEMICOLON); }

/* Indentificadores */
{letter} ({letter}|{digit}|_)* { return symbol(sym.IDENTIFIER, yytext()); }


/* Espaco em branco */
{white}+ { /* ignore whitespace */ }

. {
    System.err.println(
        "Warning: ignoring invalid token at line " +
        (yyline + 1) +
        ", column " +
        (yycolumn + 1) +
        "."
    );
}
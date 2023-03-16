lexer grammar ExprLexer;

@header {
package com.wjd.lr.expr.antlr;
}

// 模板
TEMPLATEBRACE: '${';

// 符号
SEMI:          ';';
COMMA:         ',';
DOT:           '.';
QUESTION:      '?';
COLON:         ':';
SHARP:         '#';
AT:            '@';
BANG :         '!';
OPENBRACKET:   '[';
CLOSEBRACKET:  ']';
OPEN_PAR:      '(';
CLOSE_PAR:     ')';
OPENBRACE:     '{';
CLOSEBRACE:    '}';

// 操作符
ASSIGN:        '=';
STAR:          '*';
PLUS:          '+';
MINUS:         '-';
TILDE:         '~';
PIPE2:         '||';
AND:           '&&';
DIV:           '/';
MOD:           '%';
LT:            '<';
LT_EQ:         '<=';
GT:            '>';
GT_EQ:         '>=';
EQ:            '==';
NOT_EQ1:       '!=';
NOT_EQ2:       '<>';
BITOR:         '|';
CARET:         '^';
BITAND:        '&';

// 关键字
AND_:     A N D;
BETWEEN_: B E T W E E N;
CASE_:    C A S E;
ELSE_:    E L S E;
END_:     E N D;
FALSE_:   F A L S E;
IN_:      I N;
IS_:      I S;
ISNULL_:  I S N U L L;
LIKE_:    L I K E;
NOT_:     N O T;
NOTNULL_: N O T N U L L;
NULL_:    N U L L;
OR_:      O R;
THEN_:    T H E N;
TRUE_:    T R U E;
WHEN_:    W H E N;

// 数值常量
NUMERIC_LITERAL: 
    ((DIGIT+ ('.' DIGIT*)?) | ('.' DIGIT+))
;

// 字符串常量
STRING_LITERAL:
    '\'' ( ~'\'' | '\'\'')* '\''
;

// 引用标识符
REF_ID:
    '[' ~']'* ']'
;

// 关键字标识符
KEY_ID:
    '"' (~'"' | '""')* '"'
    | '`' (~'`' | '``')* '`'
    | LETTER (LETTER | SPECIAL_LETTER | DIGIT)*
;

// 单行注释
SINGLE_LINE_COMMENT:
    '--' ~[\r\n]* (('\r'? '\n') | EOF) -> channel(HIDDEN)
;

// 多行注释
MULTILINE_COMMENT: 
    '/*' .*? '*/' -> channel(HIDDEN)
;

// 空格换行
SPACES: 
    [ \u000B\t\r\n] -> channel(HIDDEN)
;

// 字符
fragment LETTER : [a-zA-Z\u0080-\uFFFF_$];

// 特殊字符
fragment SPECIAL_LETTER : [\-];

// 数字
fragment DIGIT: [0-9];

/* 字母忽略大小写 */
fragment A: ('a'|'A');
fragment B: ('b'|'B');
fragment C: ('c'|'C');
fragment D: ('d'|'D');
fragment E: ('e'|'E');
fragment F: ('f'|'F');
fragment G: ('g'|'G');
fragment H: ('h'|'H');
fragment I: ('i'|'I');
fragment J: ('j'|'J');
fragment K: ('k'|'K');
fragment L: ('l'|'L');
fragment M: ('m'|'M');
fragment N: ('n'|'N');
fragment O: ('o'|'O');
fragment P: ('p'|'P');
fragment Q: ('q'|'Q');
fragment R: ('r'|'R');
fragment S: ('s'|'S');
fragment T: ('t'|'T');
fragment U: ('u'|'U');
fragment V: ('v'|'V');
fragment W: ('w'|'W');
fragment X: ('x'|'X');
fragment Y: ('y'|'Y');
fragment Z: ('z'|'Z');

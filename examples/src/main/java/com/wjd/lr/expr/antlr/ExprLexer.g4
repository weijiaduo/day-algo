lexer grammar ExprLexer;

@header {
package com.wjd.lr.expr.antlr;
}

// 模板
TEMPLATEBRACE: '${';

// 操作符
DOT:           '.';
OPENBRACKET:   '[';
CLOSEBRACKET:  ']';
OPEN_PAR:      '(';
CLOSE_PAR:     ')';
OPENBRACE:     '{';
CLOSEBRACE:    '}';
SHARP:         '#';
AT:            '@';
COMMA:         ',';
ASSIGN:        '=';
STAR:          '*';
PLUS:          '+';
MINUS:         '-';
TILDE:         '~';
PIPE2:         '||';
DIV:           '/';
MOD:           '%';
LT:            '<';
LT_EQ:         '<=';
GT:            '>';
GT_EQ:         '>=';
EQ:            '==';
NOT_EQ1:       '!=';
NOT_EQ2:       '<>';

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

// 标识符
IDENTIFIER:
    '"' (~'"' | '""')* '"'
    | '`' (~'`' | '``')* '`'
    | (ID | UNICODE_ID) (ID | UNICODE_ID | DIGIT)*
;

// 标识符
ID:
    [A-Za-z_\u0080-\uFFFF\-]
;

// Unicode 编码标识符
UNICODE_ID:
    [\p{Alpha}\p{General_Category=Other_Letter}]
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

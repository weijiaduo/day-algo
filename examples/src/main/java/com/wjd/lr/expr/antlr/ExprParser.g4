parser grammar ExprParser;

options {
    tokenVocab = ExprLexer;
}

@header {
package com.wjd.lr.expr.antlr;
}

parse: expr EOF
;

expr:
    literal                                    // 'abc', 1, true, null
    | columnRef                                // [table].[Field]
    | template                                 // ${userId}, ${param.city}, ${getCurrentUser()}
    | unaryOperator expr                       // -1, +1, -[table].[Field1], ~ABS(Field)
    | expr ( STAR | DIV | MOD) expr            // 2 * 3, Table.Field2 / 2, ABS(...) % 3
    | expr ( PLUS | MINUS) expr                // 1 + 2, 10 - 2
    | expr ( LT | LT_EQ | GT | GT_EQ) expr     // 1 < 2, 3 >= 0
    | expr (
        EQ
        | NOT_EQ1
        | NOT_EQ2
        | IS_
        | IS_ NOT_
        | IN_
        | LIKE_
      ) expr                                   // Field == '1'
    | expr AND_ expr                           // (Field > 0) AND (Field < 10)
    | expr OR_ expr                            // (Field > 0) OR (Field < 10)
    | generalFunc                              // ABS(Field)
    | nativeFunc                               // @ABS(Field)
    | expr (ISNULL_ | NOTNULL_ | NOT_ NULL_)   // Field is null
    | expr IS_ NOT_? expr
    | expr NOT_? BETWEEN_ expr AND_ expr              
    | OPEN_PAR expr CLOSE_PAR                  // (1 + 2)
    | CASE_ expr? 
      (WHEN_ expr THEN_ expr)+ 
      (ELSE_ expr)? END_
;

unaryOperator:
    MINUS
    | PLUS
    | TILDE
    | NOT_
;

// 字面量
literal:
    NUMERIC_LITERAL
    | STRING_LITERAL
    | NULL_
    | TRUE_
    | FALSE_
;

// 模板
template:
    TEMPLATEBRACE .*? CLOSEBRACE
;

// 列引用
columnRef:
    ((OPENBRACKET schemaName CLOSEBRACKET DOT)? 
    OPENBRACKET tableName CLOSEBRACKET DOT)? 
    OPENBRACKET columnName CLOSEBRACKET
;

// 统一函数
generalFunc:
    funcName OPEN_PAR ((expr (COMMA expr)*) | STAR)? CLOSE_PAR
;

// 原生函数
nativeFunc:
    AT funcName OPEN_PAR ((expr (COMMA expr)*) | STAR)? CLOSE_PAR
;

funcName:
    anyName
;

schemaName:
    anyName
;

tableName:
    anyName
;

columnName:
    anyName
;

anyName:
    IDENTIFIER
    | STRING_LITERAL
;
parser grammar ExprParser;

options {
    tokenVocab = ExprLexer;
}

@header {
package com.wjd.lr.expr.antlr;
}

parse:
    expr EOF
;

expr:
    literal                                    # value       // 'abc', 1, true, null
    | columnRef                                # column      // [table].[Field]
    | template                                 # script      // ${userId}, ${param.city}, ${getUserName()}
    | (MINUS | PLUS | TILDE | NOT_) expr       # unary       // -1, +1, -[table].[Field1], ~ABS(Field)
    | expr (STAR | DIV | MOD) expr             # arithmetic  // 2 * 3, Table.Field2 / 2, ABS(...) % 3
    | expr (PLUS | MINUS) expr                 # arithmetic  // 1 + 2, 10 - 2
    | expr (LT | LT_EQ | GT | GT_EQ) expr      # compare     // 1 < 2, 3 >= 0
    | expr (
        EQ
        | NOT_EQ1
        | NOT_EQ2
        | IS_
        | IS_ NOT_
        | IN_
        | LIKE_
      ) expr                                   # compare     // Field == '1'
    | expr AND_ expr                           # logic       // (Field > 0) AND (Field < 10)
    | expr OR_ expr                            # logic       // (Field > 0) OR (Field < 10)
    | generalFunc                              # function    // ABS(Field)
    | nativeFunc                               # function    // @ABS(Field)
    | expr (ISNULL_ | NOTNULL_ | NOT_ NULL_)   # compare     // Field is null
    | expr NOT_? BETWEEN_ expr AND_ expr       # between
    | OPEN_PAR expr CLOSE_PAR                  # wrap        // (1 + 2)
    | CASE_ expr? 
      (WHEN_ expr THEN_ expr)+ 
      (ELSE_ expr)? END_                       # caseWhen
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
    (tableName DOT)? columnName
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

tableName:
    refName
;

columnName:
    refName
;

refName:
    REF_ID
;

anyName:
    KEY_ID
    | OPEN_PAR anyName CLOSE_PAR
;
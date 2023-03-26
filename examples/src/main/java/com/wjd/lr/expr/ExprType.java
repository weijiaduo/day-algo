package com.wjd.lr.expr;

/**
 * 表达式类型
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public enum ExprType {

    /** null */
    NULL,
    /** Bool */
    BOOL,
    /** Numeric */
    NUMERIC,
    /** String */
    STRING,
    /** DateTime */
    DATETIME,
    /** Unary Expr */
    UNARY,
    /** Logic Expr */
    LOGICAL,
    /** Compare Expr */
    COMPARE,
    /** Arithmetic Expr */
    ARITHMETIC,
    /** Text */
    TEXT,
    /** Column */
    COLUMN,
    /** Function */
    FUNCTION,
    /** Template */
    TEMPLATE,
    /** Unknown */
    UNKNOWN;

}

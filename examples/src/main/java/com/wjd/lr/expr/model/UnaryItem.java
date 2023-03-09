package com.wjd.lr.expr.model;

/**
 * 一元表达式
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class UnaryItem extends ExprItem {

    /**
     * operator
     */
    private final String op;
    /**
     * expression
     */
    private final String expr;

    public UnaryItem(String op, String expr) {
        this.op = op;
        this.expr = expr;
    }

    public String getOp() {
        return op;
    }

    public String getExpr() {
        return expr;
    }
}

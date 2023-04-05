package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

/**
 * 一元表达式
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class UnaryExpr extends AbstractExpr {

    /**
     * operator
     */
    private final String op;
    /**
     * operand
     */
    private final Expr operand;

    /**
     * Instantiates a new Unary expr.
     *
     * @param op      the op
     * @param operand the operand
     */
    public UnaryExpr(String op, Expr operand) {
        this.op = op;
        this.operand = operand;
    }

    @Override
    public ExprType getType() {
        return ExprType.UNARY;
    }

    @Override
    public ValueType getValueType() {
        ValueType valueType = operand.getValueType();
        switch (op.toUpperCase()) {
            case "+":
            case "-":
                valueType = ValueType.NUMERIC;
                break;
            case "~":
            case "NOT":
                valueType = ValueType.BOOL;
                break;
            default:
                break;
        }
        return valueType;
    }

    @Override
    public String toStr(ExprContext context) {
        String opStr = op;
        if ("not".equalsIgnoreCase(opStr)) {
            opStr = "not ";
        }
        return String.format("%s%s", opStr, operand.toStr(context));
    }

}

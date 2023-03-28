package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

import java.util.List;

/**
 * 算术表达式
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class ArithmeticExpr extends AbstractExpr {

    /**
     * operator
     */
    private final String op;
    /**
     * operands
     */
    private final List<Expr> operands;

    /**
     * Instantiates a new Arithmetic expr.
     *
     * @param op       the op
     * @param operands the operands
     */
    public ArithmeticExpr(String op, List<Expr> operands) {
        this.op = op;
        this.operands = operands;
    }

    @Override
    public ExprType getType() {
        return ExprType.ARITHMETIC;
    }

    @Override
    public ValueType getValueType() {
        for (Expr expr : operands) {
            ValueType valueType = expr.getValueType();
            if (valueType != null
                    && valueType != ValueType.NUMERIC) {
                return ValueType.STRING;
            }
        }
        return ValueType.NUMERIC;
    }

    @Override
    public String toSql(ExprContext context) {
        String[] exprStrings = operands.stream()
                .map(e -> e.toSql(context))
                .toList()
                .toArray(new String[0]);
        return String.join(" " + op + " ", exprStrings);
    }

}
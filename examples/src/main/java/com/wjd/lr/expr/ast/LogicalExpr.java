package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

import java.util.List;

/**
 * 逻辑表达式
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class LogicalExpr extends AbstractExpr {

    /**
     * operator
     */
    private final String op;
    /**
     * operands
     */
    private final List<Expr> operands;

    /**
     * Instantiates a new Logical expr.
     *
     * @param op       the op
     * @param operands the operands
     */
    public LogicalExpr(String op, List<Expr> operands) {
        this.op = op;
        this.operands = operands;
    }

    @Override
    public ExprType getType() {
        return ExprType.LOGICAL;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.BOOL;
    }

    @Override
    public String toStr(ExprContext context) {
        String[] exprStrings = operands.stream()
                .map(e -> e.toStr(context))
                .toList()
                .toArray(new String[0]);
        return String.join(" " + op + " ", exprStrings);
    }

}

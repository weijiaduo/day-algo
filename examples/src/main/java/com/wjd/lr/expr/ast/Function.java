package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;

import java.util.List;

/**
 * 函数表达式
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class Function extends AbstractExpr {

    /**
     * function name
     */
    protected final String name;
    /**
     * function parameters
     */
    protected final List<Expr> params;

    /**
     * Instantiates a new Function.
     *
     * @param name   the name
     * @param params the params
     */
    public Function(String name, List<Expr> params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public ExprType getType() {
        return ExprType.FUNCTION;
    }

    @Override
    public String toSql(ExprContext context) {
        String[] exprStrings = params.stream()
                .map(e -> e.toSql(context))
                .toList()
                .toArray(new String[0]);
        return String.format("%s(%s)", name, String.join(", ", exprStrings));
    }

    /**
     * @return function name
     */
    public String getName() {
        return name;
    }

    /**
     * @return function parameters
     */
    public List<Expr> getParams() {
        return params;
    }

}

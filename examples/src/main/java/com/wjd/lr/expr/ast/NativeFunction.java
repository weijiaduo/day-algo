package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;

import java.util.List;

/**
 * 本地函数表达式
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class NativeFunction extends Function {

    /**
     * Instantiates a new Native function.
     *
     * @param name   the name
     * @param params the params
     */
    public NativeFunction(String name, List<Expr> params) {
        super(name, params);
    }

    @Override
    public String toSql(ExprContext context) {
        String[] exprStrings = params.stream()
                .map(e -> e.toSql(context))
                .toList()
                .toArray(new String[0]);
        return String.format("%s(%s)", name, String.join(", ", exprStrings));
    }

}

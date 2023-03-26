package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;

import java.util.List;

/**
 * 通用函数表达式
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class GeneralFunction extends Function {

    /**
     * Instantiates a new General function.
     *
     * @param name   the name
     * @param params the params
     */
    public GeneralFunction(String name, List<Expr> params) {
        super(name, params);
    }

    @Override
    public String toSql(ExprContext context) {
        return context.sqlFunction(this);
    }

}

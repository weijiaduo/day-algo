package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.Function;

/**
 * 通用函数处理器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public abstract class FunctionHandler implements ExprHandler<Function> {

    @Override
    public boolean accept(Expr expr) {
        return expr instanceof Function;
    }

    @Override
    public abstract Expr handle(Function function);

}

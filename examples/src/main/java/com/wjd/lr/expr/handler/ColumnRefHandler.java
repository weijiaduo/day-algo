package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.ColumnRef;

/**
 * 列引用处理器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public abstract class ColumnRefHandler implements ExprHandler<ColumnRef> {

    @Override
    public boolean accept(Expr expr) {
        return expr instanceof ColumnRef;
    }

    @Override
    public abstract Expr handle(ColumnRef columnRef);

}

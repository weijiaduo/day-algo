package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.ExprType;

import java.util.List;

/**
 * 值包装表达式
 *
 * @author weijiaduo
 * @since 2023/3/30
 */
public class WrapExpr extends AbstractExpr {

    /**
     * 值列表
     */
    private final List<Expr> values;

    public WrapExpr(List<Expr> values) {
        this.values = values;
    }

    @Override
    public ExprType getType() {
        return ExprType.WRAP;
    }

    @Override
    public String toSql(ExprContext context) {
        String[] valueSqls = values.stream()
                .map(e -> e.toSql(context))
                .toList()
                .toArray(new String[0]);
        return String.format("(%s)", String.join(", ", valueSqls));
    }

}

package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

/**
 * Null 字面量
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class NullValue extends AbstractExpr {

    @Override
    public ExprType getType() {
        return ExprType.NULL;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.NULL;
    }

    @Override
    public String toStr(ExprContext context) {
        return "null";
    }

}

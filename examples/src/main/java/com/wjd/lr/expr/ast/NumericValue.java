package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

/**
 * 数值字面量
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class NumericValue extends AbstractExpr {

    /**
     * value
     */
    private final Object value;

    /**
     * Instantiates a new Numeric value.
     *
     * @param value the value
     */
    public NumericValue(Object value) {
        this.value = value;
    }

    @Override
    public ExprType getType() {
        return ExprType.NUMERIC;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.NUMERIC;
    }

    @Override
    public String toStr(ExprContext context) {
        return String.valueOf(value);
    }

    /**
     * @return value
     */
    public Object getValue() {
        return value;
    }

}

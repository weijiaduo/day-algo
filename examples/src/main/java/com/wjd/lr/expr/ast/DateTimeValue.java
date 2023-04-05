package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

/**
 * Date Time value
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class DateTimeValue extends AbstractExpr {

    /**
     * value
     */
    private final Object value;

    /**
     * Instantiates a new Date time value.
     *
     * @param value the value
     */
    public DateTimeValue(Object value) {
        this.value = value;
    }

    @Override
    public ExprType getType() {
        return ExprType.DATETIME;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.DATETIME;
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

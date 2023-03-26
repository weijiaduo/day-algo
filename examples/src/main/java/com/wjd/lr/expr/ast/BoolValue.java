package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

/**
 * Bool 字面量
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class BoolValue extends AbstractExpr {

    /**
     * bool value
     */
    private final Boolean value;

    /**
     * Instantiates a new Bool value.
     *
     * @param value the value
     */
    public BoolValue(Boolean value) {
        this.value = value;
    }

    @Override
    public ExprType getType() {
        return ExprType.BOOL;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.BOOL;
    }

    @Override
    public String toSql(ExprContext context) {
        return String.valueOf(value);
    }

    /**
     * @return value
     */
    public Boolean getValue() {
        return value;
    }

}

package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

/**
 * 字符串字面量
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class StringValue extends AbstractExpr {

    /**
     * String
     */
    private final String value;

    /**
     * Instantiates a new String value.
     *
     * @param value the value
     */
    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public ExprType getType() {
        return ExprType.STRING;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.STRING;
    }

    @Override
    public String toSql(ExprContext context) {
        return value;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

}

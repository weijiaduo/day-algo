package com.wjd.lr.expr;

import com.wjd.lr.expr.type.ValueType;

/**
 * @author weijiaduo
 * @since 2023/3/24
 */
public abstract class AbstractExpr implements Expr {

    /**
     * 表达式值类型
     */
    protected ValueType valueType;

    @Override
    public ValueType getValueType() {
        return valueType;
    }

    /**
     * Sets ValueType.
     *
     * @param valueType the ValueType
     */
    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    @Override
    public String toString() {
        return String.format("ExprType: %s, ValueType: %s", getType(), getValueType());
    }

}

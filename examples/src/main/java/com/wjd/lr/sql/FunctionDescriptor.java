package com.wjd.lr.sql;

import com.wjd.lr.expr.type.ValueType;

import java.util.List;

/**
 * 函数签名
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class FunctionDescriptor {

    /**
     * 函数名
     */
    private final String name;
    /**
     * 参数类型
     */
    private final List<ValueType> paramsType;
    /**
     * 返回值类型
     */
    private final ValueType returnType;

    /**
     * Instantiates a new Function descriptor.
     *
     * @param name       the name
     * @param paramsType the params type
     * @param returnType the return type
     */
    public FunctionDescriptor(String name, List<ValueType> paramsType, ValueType returnType) {
        this.name = name;
        this.paramsType = paramsType;
        this.returnType = returnType;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return return type
     */
    public ValueType getReturnType() {
        return returnType;
    }

    /**
     * @return parameters types
     */
    public List<ValueType> getParamsType() {
        return paramsType;
    }

}

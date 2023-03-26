package com.wjd.lr.impl.function.definition;

import com.wjd.lr.expr.type.ValueType;

import java.util.List;

/**
 * 函数定义
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class FunctionDescriptor {

    /**
     * 函数名
     */
    private String name;
    /**
     * 返回值类型
     */
    private ValueType returnType;
    /**
     * 参数类型
     */
    private List<ValueType> paramsType;

    /**
     * @param name function name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param returnType function return type
     */
    public void setReturnType(ValueType returnType) {
        this.returnType = returnType;
    }

    /**
     * @return return type
     */
    public ValueType getReturnType() {
        return returnType;
    }

    /**
     * @param paramsType function parameters types
     */
    public void setParamsType(List<ValueType> paramsType) {
        this.paramsType = paramsType;
    }

    /**
     * @return parameters types
     */
    public List<ValueType> getParamsType() {
        return paramsType;
    }

}

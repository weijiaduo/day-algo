package com.wjd.lr.expr.builder.template.fucntion;

import java.lang.reflect.Method;

/**
 * 函数模板
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class FunctionStub {

    /**
     * function name
     */
    private final String name;
    /**
     * method
     */
    private final Method method;

    public FunctionStub(String name, Method method) {
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public Method getMethod() {
        return method;
    }

}

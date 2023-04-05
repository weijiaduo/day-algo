package com.wjd.lr.template.fucntion;

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

    /**
     * Instantiates a new Function stub.
     *
     * @param name   the name
     * @param method the method
     */
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

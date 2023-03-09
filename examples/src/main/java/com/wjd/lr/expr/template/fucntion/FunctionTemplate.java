package com.wjd.lr.expr.template.fucntion;

import java.lang.reflect.Method;

/**
 * 函数模板
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class FunctionTemplate {

    /**
     * function name
     */
    private final String name;
    /**
     * method
     */
    private final Method method;

    public FunctionTemplate(String name, Method method) {
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

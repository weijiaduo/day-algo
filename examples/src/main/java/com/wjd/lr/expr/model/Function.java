package com.wjd.lr.expr.model;

import java.util.List;

/**
 * 函数
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class Function extends ExprItem {

    /**
     * name
     */
    private final String name;
    /**
     * params
     */
    private final List<String> params;

    public Function(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }

}

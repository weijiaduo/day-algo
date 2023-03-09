package com.wjd.lr.expr.builder.function;

import com.wjd.lr.expr.model.Function;

/**
 * 本地函数构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class NativeFuncBuilder implements FunctionBuilder {

    @Override
    public String build(Function function) {
        return buildDefault(function);
    }

    /**
     * 函数构建的默认实现
     *
     * @param function 函数
     * @return 函数表达式字符串
     */
    protected String buildDefault(Function function) {
        return function.getName() + "(" + String.join(", ", function.getParams()) + ")";
    }

}

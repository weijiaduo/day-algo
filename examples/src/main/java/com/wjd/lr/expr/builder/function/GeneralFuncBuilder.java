package com.wjd.lr.expr.builder.function;

import com.wjd.lr.expr.model.Function;

/**
 * 默认的 SQL 函数构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class GeneralFuncBuilder implements FunctionBuilder {

    /**
     * 函数构建的默认实现
     *
     * @param function 函数
     * @return 函数表达式字符串
     */
    protected String buildDefault(Function function) {
        return function.getName() + "(" + String.join(", ", function.getParams()) + ")";
    }

    @Override
    public String lower(Function function) {
        return buildDefault(function);
    }

    @Override
    public String max(Function function) {
        return buildDefault(function);
    }

    @Override
    public String min(Function function) {
        return buildDefault(function);
    }

    @Override
    public String replace(Function function) {
        return buildDefault(function);
    }

    @Override
    public String substring(Function function) {
        return buildDefault(function);
    }

    @Override
    public String upper(Function function) {
        return buildDefault(function);
    }

    @Override
    public String day(Function function) {
        return buildDefault(function);
    }

    @Override
    public String month(Function function) {
        return buildDefault(function);
    }

    @Override
    public String year(Function function) {
        return buildDefault(function);
    }

    @Override
    public String abs(Function function) {
        return buildDefault(function);
    }

    @Override
    public String avg(Function function) {
        return buildDefault(function);
    }

    @Override
    public String ceil(Function function) {
        return buildDefault(function);
    }

    @Override
    public String count(Function function) {
        return buildDefault(function);
    }

    @Override
    public String floor(Function function) {
        return buildDefault(function);
    }

    @Override
    public String round(Function function) {
        return buildDefault(function);
    }

    @Override
    public String sign(Function function) {
        return buildDefault(function);
    }

    @Override
    public String sum(Function function) {
        return buildDefault(function);
    }

    @Override
    public String getDate(Function function) {
        return buildDefault(function);
    }

    @Override
    public String nullIf(Function function) {
        return buildDefault(function);
    }

}

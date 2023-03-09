package com.wjd.lr.expr.builder.function;

import com.wjd.lr.expr.model.Function;

import java.lang.reflect.Method;

/**
 * 通用函数构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class GeneralFuncBuilder implements FunctionBuilder {

    @Override
    public String build(Function function) {
        try {
            String name = function.getName().toLowerCase();
            Method m = getClass().getDeclaredMethod(name, Function.class);
            return (String) m.invoke(this, function);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return function.getText();
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

    public String lower(Function function) {
        return buildDefault(function);
    }

    public String max(Function function) {
        return buildDefault(function);
    }

    public String min(Function function) {
        return buildDefault(function);
    }

    public String replace(Function function) {
        return buildDefault(function);
    }

    public String substring(Function function) {
        return buildDefault(function);
    }

    public String upper(Function function) {
        return buildDefault(function);
    }

    public String day(Function function) {
        return buildDefault(function);
    }

    public String month(Function function) {
        return buildDefault(function);
    }

    public String year(Function function) {
        return buildDefault(function);
    }

    public String abs(Function function) {
        return buildDefault(function);
    }

    public String avg(Function function) {
        return buildDefault(function);
    }

    public String ceil(Function function) {
        return buildDefault(function);
    }

    public String count(Function function) {
        return buildDefault(function);
    }

    public String floor(Function function) {
        return buildDefault(function);
    }

    public String round(Function function) {
        return buildDefault(function);
    }

    public String sign(Function function) {
        return buildDefault(function);
    }

    public String sum(Function function) {
        return buildDefault(function);
    }

    public String getDate(Function function) {
        return buildDefault(function);
    }

    public String nullIf(Function function) {
        return buildDefault(function);
    }

}

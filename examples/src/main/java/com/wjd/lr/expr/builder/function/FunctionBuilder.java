package com.wjd.lr.expr.builder.function;

import com.wjd.lr.expr.model.Function;

/**
 * 函数构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public interface FunctionBuilder {

    String lower(Function function);

    String max(Function function);

    String min(Function function);

    String replace(Function function);

    String substring(Function function);

    String upper(Function function);

    String day(Function function);

    String month(Function function);

    String year(Function function);

    String abs(Function function);

    String avg(Function function);

    String ceil(Function function);

    String count(Function function);

    String floor(Function function);

    String round(Function function);

    String sign(Function function);

    String sum(Function function);

    String getDate(Function function);

    String nullIf(Function function);

}

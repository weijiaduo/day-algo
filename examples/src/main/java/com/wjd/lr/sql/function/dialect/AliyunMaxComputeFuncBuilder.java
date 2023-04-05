package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Aliyun MaxCompute
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class AliyunMaxComputeFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String day(Function function) {
        return formatDate(function, "DD");
    }

    @Override
    public String month(Function function) {
        return formatDate(function, "MM");
    }

    @Override
    public String year(Function function) {
        return formatDate(function, "YYYY");
    }

    /**
     * 格式化日期
     *
     * @param function   函数
     * @param dateFormat 格式化字符串
     * @return 日期字符串
     */
    private String formatDate(Function function, String dateFormat) {
        String p1 = function.getParams().get(0).toStr(ctx);
        return String.format("cast(to_char(%s, %s) as bigint)", p1, dateFormat);
    }

}

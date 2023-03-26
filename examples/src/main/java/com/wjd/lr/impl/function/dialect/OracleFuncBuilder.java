package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Oracle
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class OracleFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String substring(Function function) {
        return buildDefault(new Function("substr", function.getParams()));
    }

    @Override
    public String day(Function function) {
        return formatDate(function, "dd");
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
        String p1 = function.getParams().get(0).toSql(ctx);
        return String.format("to_number(to_char(%s, %s))", p1, dateFormat);
    }

    @Override
    public String ceiling(Function function) {
        return buildDefault(new Function("ceil", function.getParams()));
    }

    @Override
    public String getDate(Function function) {
        return "sysdate";
    }

}

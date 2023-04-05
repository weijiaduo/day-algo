package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Greenplum
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class GreenplumFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String day(Function function) {
        return formatDate(function);
    }

    @Override
    public String month(Function function) {
        return formatDate(function);
    }

    @Override
    public String year(Function function) {
        return formatDate(function);
    }

    /**
     * 格式化日期
     *
     * @param function 函数
     * @return 日期字符串
     */
    private String formatDate(Function function) {
        String p1 = function.getParams().get(0).toStr(ctx);
        return String.format("extract(%s from %s)", function.getName(), p1);
    }

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}
package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Kingbase
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class KingbaseFuncBuilder extends GeneralFuncBuilder {

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

}
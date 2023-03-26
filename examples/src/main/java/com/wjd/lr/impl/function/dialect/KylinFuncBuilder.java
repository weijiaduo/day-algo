package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.expr.ast.NumericValue;
import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Kylin
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class KylinFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String substring(Function function) {
        String p1 = function.getParams().get(0).toSql(ctx);
        String p2 = function.getParams().get(1).toSql(ctx);
        String p3 = function.getParams().get(2).toSql(ctx);
        try {
            // 索引从 1 开始
            int start = Integer.parseInt(p2.trim());
            int length = Integer.parseInt(p3.trim());
            start = start == 0 ? 1 : start;
            p2 = String.valueOf(start);
            p3 = String.valueOf(start + length);
        } catch (Exception e) {
            // 参数不一定是数字，如果是表达式就没办法替换了
        }
        return String.format("substring(%s from %s for %s)", p1, p2, p3);
    }

    @Override
    public String day(Function function) {
        return buildDefault(new Function("dayofmonth", function.getParams()));
    }

    @Override
    public String round(Function function) {
        if (function.getParams().size() == 1) {
            // 默认保留 2 位精度
            function.getParams().add(new NumericValue(2));
        }
        return super.round(function);
    }

    @Override
    public String getDate(Function function) {
        return "current_date";
    }

}

package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Hadoop Hive
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class HadoopHiveFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String replace(Function function) {
        return buildDefault(new Function("regexp_replace", function.getParams()));
    }

    @Override
    public String getDate(Function function) {
        return "cast(from_unixtime(unix_timestamp(), 'yyyy-MM-dd HH:mm:ss') as timestamp)";
    }

    @Override
    public String nullIf(Function function) {
        String p1 = function.getParams().get(0).toSql(ctx);
        String p2 = function.getParams().get(1).toSql(ctx);
        return String.format("case when %s = %s then null else %s end", p1, p2, p1);
    }
}
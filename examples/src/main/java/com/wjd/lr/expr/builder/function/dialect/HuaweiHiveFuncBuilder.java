package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

/**
 * Huawei Hive
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class HuaweiHiveFuncBuilder extends GeneralFuncBuilder {

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
        return buildDefault(new Function("coalesce", function.getParams()));
    }

}

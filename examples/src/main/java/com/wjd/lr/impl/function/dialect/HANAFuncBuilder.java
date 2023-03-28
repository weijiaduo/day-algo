package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * HANA
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class HANAFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String day(Function function) {
        return buildDefault(new Function("dayofmonth", function.getParams()));
    }

    @Override
    public String getDate(Function function) {
        return "current_date";
    }

}
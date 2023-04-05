package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Impala
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class ImpalaFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}

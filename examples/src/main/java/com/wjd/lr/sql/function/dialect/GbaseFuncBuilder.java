package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Gbase
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class GbaseFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}

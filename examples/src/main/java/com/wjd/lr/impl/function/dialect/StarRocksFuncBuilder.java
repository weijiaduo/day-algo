package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * StarRocks
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class StarRocksFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}
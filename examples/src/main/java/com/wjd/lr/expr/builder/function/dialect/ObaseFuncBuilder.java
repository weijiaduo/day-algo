package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

/**
 * Obase
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class ObaseFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}

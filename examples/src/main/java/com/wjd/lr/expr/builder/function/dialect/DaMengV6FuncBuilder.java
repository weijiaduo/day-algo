package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

/**
 * DaMeng V6
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class DaMengV6FuncBuilder extends GeneralFuncBuilder {

    @Override
    public String day(Function function) {
        String p1 = function.getParams().get(0);
        return String.format("extract(day from %s)", p1);
    }

}

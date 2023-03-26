package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * DaMeng V6
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class DaMengV6FuncBuilder extends GeneralFuncBuilder {

    @Override
    public String day(Function function) {
        String p1 = function.getParams().get(0).toSql(ctx);
        return String.format("extract(day from %s)", p1);
    }

}

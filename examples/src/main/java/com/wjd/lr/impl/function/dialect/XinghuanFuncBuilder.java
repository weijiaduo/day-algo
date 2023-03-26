package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.expr.ast.Function;
import com.wjd.lr.impl.function.GeneralFuncBuilder;

/**
 * Xinghuan
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class XinghuanFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String sign(Function function) {
        String p1 = function.getParams().get(0).toSql(ctx);
        return String.format("case when %s > 0 then 1 when %s = 0 then 0 else -1 end", p1, p1);
    }

    @Override
    public String getDate(Function function) {
        return "sysdate";
    }

}

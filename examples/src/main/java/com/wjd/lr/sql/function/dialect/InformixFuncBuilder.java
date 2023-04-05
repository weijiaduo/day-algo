package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Informix
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class InformixFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String substring(Function function) {
        return buildDefault(new Function("substr", function.getParams()));
    }

    @Override
    public String ceiling(Function function) {
        return buildDefault(new Function("ceil", function.getParams()));
    }

    @Override
    public String sign(Function function) {
        String p1 = function.getParams().get(0).toStr(ctx);
        return String.format("case when %s > 0 then 1 when %s = 0 then 0 else -1 end", p1, p1);
    }

    @Override
    public String getDate(Function function) {
        return "sysdate";
    }

}

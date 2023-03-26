package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * Gbase 8S V84
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class Gbase8SV84FuncBuilder extends GeneralFuncBuilder {

    @Override
    public String substring(Function function) {
        return buildDefault(new Function("substr", function.getParams()));
    }

    @Override
    public String ceiling(Function function) {
        return buildDefault(new Function("ceil", function.getParams()));
    }

    @Override
    public String getDate(Function function) {
        return "sysdate";
    }

}

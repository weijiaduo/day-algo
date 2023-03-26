package com.wjd.lr.impl.function.dialect;

import com.wjd.lr.impl.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

/**
 * DB2V9
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class DB2V9FuncBuilder extends GeneralFuncBuilder {

    @Override
    public String getDate(Function function) {
        return "current date";
    }

}

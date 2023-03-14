package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

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

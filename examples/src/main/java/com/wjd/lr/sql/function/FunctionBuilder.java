package com.wjd.lr.sql.function;

import com.wjd.lr.expr.ast.Function;

/**
 * 函数构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public interface FunctionBuilder {

    /**
     * Build Function -> SQL string
     *
     * @param function the function
     * @return the SQL string
     */
    String build(Function function);

}

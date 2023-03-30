package com.wjd.lr.expr;

import com.wjd.lr.expr.ast.ColumnRef;
import com.wjd.lr.expr.ast.Function;

/**
 * 表达式上下文
 * <p>
 * 用于适配不同的数据库，转成不同的 SQL 语句
 *
 * @author weijiaduo
 * @since 2023 /3/24
 */
public interface ExprContext {

    /**
     * 给名称加上引号标记
     *
     * @param name 名称
     * @return 加上引用标记后的名称
     */
    String quoteName(String name);


    /**
     * 列引用转成 SQL 语句
     *
     * @param columnRef 列引用
     * @return SQL 语句
     */
    String sqlColumnRef(ColumnRef columnRef);

    /**
     * 函数转成 SQL 语句
     *
     * @param function 函数
     * @return SQL 语句
     */
    String sqlFunction(Function function);

}

package com.wjd.lr.expr;

import com.wjd.lr.expr.ast.ColumnRef;
import com.wjd.lr.expr.ast.Function;

/**
 * 表达式上下文
 * <p>
 * 用于表达式转成字符串时的上下文
 *
 * @author weijiaduo
 * @since 2023 /3/24
 */
public interface ExprContext {

    /**
     * 名称转成字符串
     *
     * @param name 名称
     * @return 加上引用标记后的名称
     */
    String strName(String name);

    /**
     * 列引用转成字符串
     *
     * @param columnRef 列引用
     * @return SQL 语句
     */
    String strColumnRef(ColumnRef columnRef);

    /**
     * 函数转成字符串
     *
     * @param function 函数
     * @return SQL 语句
     */
    String strFunction(Function function);

}

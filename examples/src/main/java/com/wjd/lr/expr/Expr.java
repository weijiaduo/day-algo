package com.wjd.lr.expr;

import com.wjd.lr.expr.type.ValueType;

/**
 * 表达式
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public interface Expr {

    /**
     * 获取表达式类型
     *
     * @return 表达式类型
     */
    ExprType getType();

    /**
     * 获取表达式的值类型
     *
     * @return 值类型
     */
    ValueType getValueType();

    /**
     * 表达式转成 SQL 语句
     *
     * @param context 上下文
     * @return SQL 语句
     */
    String toSql(ExprContext context);

    /**
     * 默认的 SQL 语句转换实现
     *
     * @return SQL 语句
     */
    default String toSql() {
        return this.toSql(new DefaultExprContext());
    }

}

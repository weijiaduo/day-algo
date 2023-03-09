package com.wjd.lr.expr.builder.ref;

import com.wjd.lr.expr.model.ColumnRef;

/**
 * 列引用构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public interface ColumnRefBuilder {

    /**
     * 构建列引用的字符串表达式
     *
     * @param columnRef 列引用
     * @return 列引用表达式
     */
    String build(ColumnRef columnRef);

}

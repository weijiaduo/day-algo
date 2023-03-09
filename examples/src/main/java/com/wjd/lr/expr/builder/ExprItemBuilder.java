package com.wjd.lr.expr.builder;

/**
 * 表达式构建器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public interface ExprItemBuilder<E> {

    String build(E item);

}

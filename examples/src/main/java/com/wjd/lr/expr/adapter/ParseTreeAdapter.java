package com.wjd.lr.expr.adapter;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * 语法树适配器
 * <p>
 * 第三方类型 -> 自己的类型
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public interface ParseTreeAdapter<T> {

    /**
     * 是否可以处理该规则节点
     *
     * @param parseTree 语法树节点
     * @return true/false
     */
    boolean accept(ParseTree parseTree);

    /**
     * 语法树节点转成字符串
     *
     * @param parseTree 语法树节点
     * @return 内部项目
     */
    T adapt(ParseTree parseTree);

}

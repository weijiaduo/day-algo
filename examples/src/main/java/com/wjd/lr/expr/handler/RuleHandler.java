package com.wjd.lr.expr.handler;

import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public interface RuleHandler<E extends RuleNode, R> {

    /**
     * 处理规则节点，并返回值
     *
     * @param e 规则节点
     * @return 返回值
     */
    R handle(E e);

}

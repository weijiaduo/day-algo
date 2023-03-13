package com.wjd.lr.expr.adapter;

import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 规则适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public interface RuleAdapter {

    /**
     * 是否可以处理该规则节点
     *
     * @param ruleNode 规则节点
     * @return true/false
     */
    boolean accept(RuleNode ruleNode);

    /**
     * 语法树节点转成字符串
     *
     * @param ruleNode 规则节点
     * @return 内部项目
     */
    String adapt(RuleNode ruleNode);

}

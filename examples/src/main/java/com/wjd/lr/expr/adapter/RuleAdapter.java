package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.model.ExprItem;
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
     * 语法树节点转成内部对象
     *
     * @param ruleNode 规则节点
     * @return 内部项目
     */
    ExprItem adapt(RuleNode ruleNode);

    /**
     * 构建表达式字符串
     *
     * @param exprItem 表达式项目
     * @return 表达式字符串
     */
    String build(ExprItem exprItem);

}

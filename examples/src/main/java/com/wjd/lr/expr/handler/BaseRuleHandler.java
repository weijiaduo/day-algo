package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.RuleHandler;
import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 规则处理器基类
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public abstract class BaseRuleHandler<E extends RuleNode> implements RuleHandler<E, String> {

    /**
     * 访问者
     */
    protected ExprVisitor visitor;

    public BaseRuleHandler(ExprVisitor visitor) {
        this.visitor = visitor;
    }

}

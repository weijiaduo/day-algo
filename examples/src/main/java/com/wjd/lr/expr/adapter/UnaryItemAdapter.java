package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.unary.UnaryItemBuilder;
import com.wjd.lr.expr.model.ExprItem;
import com.wjd.lr.expr.model.UnaryItem;
import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 一元表达式适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class UnaryItemAdapter implements RuleAdapter {

    /**
     * 访问者
     */
    private final ExprVisitor visitor;
    /**
     * 访问者
     */
    private final UnaryItemBuilder builder;

    public UnaryItemAdapter(ExprVisitor visitor, UnaryItemBuilder builder) {
        this.visitor = visitor;
        this.builder = builder;
    }

    @Override
    public boolean accept(RuleNode ruleNode) {
        return ruleNode instanceof ExprParser.UnaryContext;
    }

    @Override
    public UnaryItem adapt(RuleNode ruleNode) {
        ExprParser.UnaryContext ctx = (ExprParser.UnaryContext) ruleNode;
        String op = ctx.children.get(0).getText();
        String expr = visitor.visit(ctx.expr());
        UnaryItem unaryItem = new UnaryItem(op, expr);
        unaryItem.setText(ruleNode.getText());
        return unaryItem;
    }

    @Override
    public String build(ExprItem exprItem) {
        return builder.build((UnaryItem) exprItem);
    }

}

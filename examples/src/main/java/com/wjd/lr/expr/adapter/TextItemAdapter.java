package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.text.TextItemBuilder;
import com.wjd.lr.expr.model.TextItem;
import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 文本适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class TextItemAdapter implements RuleAdapter {

    /**
     * 访问者
     */
    private final ExprVisitor visitor;
    /**
     * 构建者
     */
    private final TextItemBuilder builder;

    public TextItemAdapter(ExprVisitor visitor, TextItemBuilder builder) {
        this.visitor = visitor;
        if (builder == null) {
            builder = new TextItemBuilder();
        }
        this.builder = builder;
    }

    @Override
    public boolean accept(RuleNode ruleNode) {
        return ruleNode instanceof ExprParser.LiteralContext
                || ruleNode instanceof ExprParser.RefNameContext
                || ruleNode instanceof ExprParser.AnyNameContext;
    }

    @Override
    public String adapt(RuleNode ruleNode) {
        TextItem textItem = new TextItem(ruleNode.getText());
        return builder.build(textItem);
    }

}

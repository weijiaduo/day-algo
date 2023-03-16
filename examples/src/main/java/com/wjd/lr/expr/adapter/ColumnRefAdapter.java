package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.ref.ColumnRefBuilder;
import com.wjd.lr.expr.model.ColumnRef;
import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 列引用适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class ColumnRefAdapter implements RuleAdapter {

    /**
     * 访问者
     */
    private final ExprVisitor visitor;
    /**
     * 列引用构建器
     */
    private final ColumnRefBuilder builder;

    public ColumnRefAdapter(ExprVisitor visitor, ColumnRefBuilder builder) {
        this.visitor = visitor;
        if (builder == null) {
            builder = new ColumnRefBuilder();
        }
        this.builder = builder;
    }

    @Override
    public boolean accept(RuleNode ruleNode) {
        return ruleNode instanceof ExprParser.ColumnRefContext;
    }

    @Override
    public String adapt(RuleNode ruleNode) {
        ExprParser.ColumnRefContext ctx = (ExprParser.ColumnRefContext) ruleNode;
        String tableName = null;
        if (ctx.tableName() != null) {
            tableName = removeBracket(ctx.tableName().getText());
        }
        String columnName = removeBracket(ctx.columnName().getText());
        ColumnRef columnRef = new ColumnRef(tableName, columnName);
        columnRef.setText(ruleNode.getText());
        return builder.build(columnRef);
    }

    /**
     * 去掉引用的中括号 []
     *
     * @param ref 引用字符串
     * @return 去掉引用括号后的字符串
     */
    private String removeBracket(String ref) {
        return ref.trim().substring(1, ref.length() - 1).trim();
    }

}

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
        String schemaName = null;
        if (ctx.schemaName() != null) {
            schemaName = ctx.schemaName().getText();
        }
        String tableName = null;
        if (ctx.tableName() != null) {
            tableName = ctx.tableName().getText();
        }
        String columnName = ctx.columnName().getText();
        ColumnRef columnRef = new ColumnRef(schemaName, tableName, columnName);
        columnRef.setText(ruleNode.getText());
        return builder.build(columnRef);
    }


}

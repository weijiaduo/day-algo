package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.model.ColumnRef;
import com.wjd.lr.expr.ref.ColumnRefBuilder;

/**
 * 列引用处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ColumnRefHandler extends BaseRuleHandler<ExprParser.ColumnRefContext> {

    /**
     * ColumnRefBuilder
     */
    private final ColumnRefBuilder columnRefBuilder;

    public ColumnRefHandler(ExprVisitor visitor, ColumnRefBuilder columnRefBuilder) {
        super(visitor);
        this.columnRefBuilder = columnRefBuilder;
    }

    @Override
    public String handle(ExprParser.ColumnRefContext ctx) {
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
        return columnRefBuilder.build(columnRef);
    }

}

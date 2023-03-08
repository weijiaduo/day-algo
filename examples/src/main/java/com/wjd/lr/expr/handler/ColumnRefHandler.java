package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;

/**
 * 列引用处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ColumnRefHandler extends BaseRuleHandler<ExprParser.ColumnRefContext> {

    public ColumnRefHandler(ExprVisitor visitor) {
        super(visitor);
    }

    @Override
    public String handle(ExprParser.ColumnRefContext ctx) {
        // TODO: get real column expr
        String columnName = ctx.columnName().getText();
        if (ctx.tableName() != null) {
            columnName = ctx.tableName().getText() + "." + columnName;
        }
        if (ctx.schemaName() != null) {
            columnName = ctx.schemaName().getText() + "." + columnName;
        }
        return columnName;
    }

}

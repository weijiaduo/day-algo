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
        String expr = ctx.getText();
        if (expr == null || expr.length() < 2) {
            return "";
        }
        expr = expr.substring(1, expr.length() - 1);
        expr = String.join(".", expr.split("]\\.\\["));
        return expr;
    }

}

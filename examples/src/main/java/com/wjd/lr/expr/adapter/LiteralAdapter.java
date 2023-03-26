package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.*;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * 字面量适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class LiteralAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Literal adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public LiteralAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.LiteralContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.LiteralContext ctx = (ExprParser.LiteralContext) parseTree;
        Expr expr;
        String text = ctx.getText();
        if (ctx.NUMERIC_LITERAL() != null) {
            expr = new NumericValue(text);
        } else if (ctx.STRING_LITERAL() != null) {
            expr = new StringValue(text);
        } else if (ctx.TRUE_() != null || ctx.FALSE_() != null) {
            expr = new BoolValue(Boolean.valueOf(text));
        } else if (ctx.NULL_() != null) {
            expr = new NullValue();
        } else {
            expr = new TextExpr(text);
        }
        return handle(expr);
    }

}

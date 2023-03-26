package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.UnaryExpr;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * 一元运算适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class UnaryAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Unary adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public UnaryAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.UnaryContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.UnaryContext ctx = (ExprParser.UnaryContext) parseTree;
        String op = ctx.getChild(TerminalNode.class, 0).getText();
        Expr operand = visitor.visit(ctx.expr());
        return handle(new UnaryExpr(op, operand));
    }

}

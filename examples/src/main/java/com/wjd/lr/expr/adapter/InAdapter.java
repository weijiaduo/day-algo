package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.BoolValue;
import com.wjd.lr.expr.ast.GeneralFunction;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * In 适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class InAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new In adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public InAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.InContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.InContext ctx = (ExprParser.InContext) parseTree;
        boolean isNot = ctx.NOT_() != null;
        List<Expr> params = new java.util.ArrayList<>(ctx.expr().stream()
                .map(visitor::visit).toList());
        params.add(1, new BoolValue(isNot));
        return handle(new GeneralFunction("in", params));
    }

}

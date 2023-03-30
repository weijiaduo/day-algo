package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.WrapExpr;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * 值包装适配器
 *
 * @author weijiaduo
 * @since 2023/3/30
 */
public class WrapExprAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Wrap expr adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public WrapExprAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.WrapContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.WrapContext ctx = (ExprParser.WrapContext) parseTree;
        List<Expr> values = ctx.expr().stream().map(visitor::visit).toList();
        return handle(new WrapExpr(values));
    }

}

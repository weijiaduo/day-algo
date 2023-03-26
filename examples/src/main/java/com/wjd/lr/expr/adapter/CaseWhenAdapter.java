package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.GeneralFunction;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * Cse When 适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class CaseWhenAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Case when adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public CaseWhenAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.CaseWhenContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.CaseWhenContext ctx = (ExprParser.CaseWhenContext) parseTree;
        List<Expr> params = new java.util.ArrayList<>(ctx.expr().stream().map(visitor::visit).toList());
        if ("when".equalsIgnoreCase(ctx.getChild(1).getText())) {
            params.add(0, null);
        }
        if (ctx.ELSE_() == null) {
            params.add(null);
        }
        return handle(new GeneralFunction("caseWhen", params));
    }

}

package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.CompareExpr;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * 比较运算适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class CompareAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Compare adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public CompareAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.CompareContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.CompareContext ctx = (ExprParser.CompareContext) parseTree;
        String op = ctx.getChild(TerminalNode.class, 0).getText();
        List<Expr> operands = ctx.expr().stream().map(visitor::visit).toList();
        return handle(new CompareExpr(op, operands));
    }

}

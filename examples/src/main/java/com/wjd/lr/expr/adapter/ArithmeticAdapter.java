package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.ArithmeticExpr;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * 数值运算适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class ArithmeticAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Arithmetic adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public ArithmeticAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.ArithmeticContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.ArithmeticContext ctx = (ExprParser.ArithmeticContext) parseTree;
        String op = ctx.getChild(TerminalNode.class, 0).getText();
        List<Expr> operands = ctx.expr().stream().map(visitor::visit).toList();
        return handle(new ArithmeticExpr(op, operands));
    }

}

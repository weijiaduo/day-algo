package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.LogicalExpr;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * 逻辑运算适配器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class LogicalAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Logical adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public LogicalAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.LogicContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.LogicContext ctx = (ExprParser.LogicContext) parseTree;
        String op = ctx.getChild(TerminalNode.class, 0).getText();
        List<Expr> operands = ctx.expr().stream().map(visitor::visit).toList();
        return handle(new LogicalExpr(op, operands));
    }

}

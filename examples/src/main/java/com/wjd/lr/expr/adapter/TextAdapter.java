package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.TextExpr;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * 文本适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class TextAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Text adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public TextAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.RefNameContext
                || parseTree instanceof ExprParser.AnyNameContext
                || parseTree instanceof TerminalNode;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        String text = parseTree.getText();
        if ("<EOF>".equals(text)) {
            return null;
        }
        return handle(new TextExpr(text));
    }

}

package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.ColumnRef;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * 列引用适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class ColumnRefAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Column ref adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public ColumnRefAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.ColumnRefContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.ColumnRefContext ctx = (ExprParser.ColumnRefContext) parseTree;
        String tableName = null;
        if (ctx.tableName() != null) {
            tableName = removeBracket(ctx.tableName().getText());
        }
        String columnName = removeBracket(ctx.columnName().getText());
        return handle(new ColumnRef(tableName, columnName));
    }

    /**
     * 去掉引用的中括号 []
     *
     * @param ref 引用字符串
     * @return 去掉引用括号后的字符串
     */
    private String removeBracket(String ref) {
        return ref.trim().substring(1, ref.length() - 1).trim();
    }

}

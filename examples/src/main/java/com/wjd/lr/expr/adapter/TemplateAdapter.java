package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.Template;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * 模板适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class TemplateAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Template adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public TemplateAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.TemplateContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.TemplateContext ctx = (ExprParser.TemplateContext) parseTree;
        String scriptText = parseScriptText(ctx);
        return handle(new Template(scriptText));
    }

    /**
     * 解析模板内部的脚本
     *
     * @param ctx 模板上下文
     * @return 模板脚本
     */
    private String parseScriptText(ExprParser.TemplateContext ctx) {
        // No need to visit inner script
        String expr = ctx.getText();
        if (expr != null && expr.length() > 3) {
            // remove template brace ${}
            expr = expr.substring(2, expr.length() - 1);
        } else {
            expr = "";
        }
        return expr;
    }

}

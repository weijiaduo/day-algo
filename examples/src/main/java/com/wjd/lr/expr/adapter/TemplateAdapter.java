package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.template.TemplateBuilder;
import com.wjd.lr.expr.model.Template;
import org.antlr.v4.runtime.tree.RuleNode;

/**
 * 模板适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class TemplateAdapter implements RuleAdapter {

    /**
     * 访问者
     */
    private final ExprVisitor visitor;
    /**
     * 访问者
     */
    private final TemplateBuilder builder;

    public TemplateAdapter(ExprVisitor visitor, TemplateBuilder builder) {
        this.visitor = visitor;
        if (builder == null) {
            builder = new TemplateBuilder();
        }
        this.builder = builder;
    }

    @Override
    public boolean accept(RuleNode ruleNode) {
        return ruleNode instanceof ExprParser.TemplateContext;
    }

    @Override
    public String adapt(RuleNode ruleNode) {
        ExprParser.TemplateContext ctx = (ExprParser.TemplateContext) ruleNode;
        String scriptText = parseScriptText(ctx);
        Template template = new Template(scriptText);
        template.setText(ruleNode.getText());
        return builder.build(template);
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

package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.model.Template;
import com.wjd.lr.expr.template.DefaultTemplateBuilder;
import com.wjd.lr.expr.template.TemplateBuilder;

/**
 * 模板规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class TemplateHandler extends BaseRuleHandler<ExprParser.TemplateContext> {

    /**
     * 模板构建器
     */
    private final TemplateBuilder templateBuilder;

    public TemplateHandler(ExprVisitor visitor) {
        this(visitor, null);
    }

    public TemplateHandler(ExprVisitor visitor, TemplateBuilder templateBuilder) {
        super(visitor);
        if (templateBuilder == null) {
            templateBuilder = new DefaultTemplateBuilder();
        }
        this.templateBuilder = templateBuilder;
    }

    @Override
    public String handle(ExprParser.TemplateContext tempCtx) {
        String scriptText = parseScriptText(tempCtx);
        Template template = new Template(scriptText);
        return templateBuilder.build(template);
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

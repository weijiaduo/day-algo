package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.template.TemplateContext;
import org.mvel2.MVEL;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.impl.StaticMethodImportResolverFactory;

/**
 * 模板规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class TemplateHandler extends BaseRuleHandler<ExprParser.TemplateContext> {

    /**
     * 模板上下文
     */
    private TemplateContext templateContext;

    public TemplateHandler(ExprVisitor visitor) {
        this(visitor, new TemplateContext());
    }

    public TemplateHandler(ExprVisitor visitor, TemplateContext templateContext) {
        super(visitor);
        this.templateContext = templateContext;
    }

    @Override
    public String handle(ExprParser.TemplateContext tempCtx) {
        // 解析脚本表达式
        String scriptText = parseScriptText(tempCtx);
        ExpressionCompiler compiler = new ExpressionCompiler(scriptText, templateContext.getParseContext());
        CompiledExpression compiledExpr = compiler.compile();

        // 执行模板脚本
        Object result = MVEL.executeExpression(compiledExpr, templateContext.getExecuteContext(),
                new StaticMethodImportResolverFactory(templateContext.getParseContext()));
        return String.valueOf(result);
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

    /**
     * @param templateContext templateContext
     */
    public void setTemplateContext(TemplateContext templateContext) {
        this.templateContext = templateContext;
    }

    /**
     * @return TemplateContext
     */
    public TemplateContext getTemplateContext() {
        return templateContext;
    }
}

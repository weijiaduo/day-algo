package com.wjd.lr.template.mvel2;

import com.wjd.lr.template.TemplateContext;
import com.wjd.lr.template.TemplateExecutor;
import org.mvel2.MVEL;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.impl.StaticMethodImportResolverFactory;

/**
 * Mvel2 模板执行器
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public class Mvel2TemplateExecutor implements TemplateExecutor {

    @Override
    public Object execute(String template, TemplateContext context) {
        Mvel2TemplateContext ctx = (Mvel2TemplateContext) context;
        if (ctx == null) {
            ctx = new Mvel2TemplateContext();
        }

        // 编译模板脚本
        ExpressionCompiler compiler = new ExpressionCompiler(template, ctx.getParseContext());
        CompiledExpression compiledExpr = compiler.compile();

        // 执行模板脚本
        return MVEL.executeExpression(compiledExpr, ctx.getExecuteContext(),
                new StaticMethodImportResolverFactory(ctx.getParseContext()));
    }

}

package com.wjd.lr.expr.builder.template;

import com.wjd.lr.expr.model.Template;
import org.mvel2.MVEL;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.impl.StaticMethodImportResolverFactory;

/**
 * 默认模板构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class DefaultTemplateBuilder implements TemplateBuilder {

    /**
     * 上下文环境
     */
    private final TemplateContext context;

    public DefaultTemplateBuilder() {
        this(new TemplateContext());
    }

    public DefaultTemplateBuilder(TemplateContext context) {
        this.context = context;
    }

    @Override
    public String build(Template template) {
        // 编译模板脚本
        String expr = template.getExpr();
        ExpressionCompiler compiler = new ExpressionCompiler(expr, context.getParseContext());
        CompiledExpression compiledExpr = compiler.compile();

        // 执行模板脚本
        Object result = MVEL.executeExpression(compiledExpr, context.getExecuteContext(),
                new StaticMethodImportResolverFactory(context.getParseContext()));
        return String.valueOf(result);
    }

}

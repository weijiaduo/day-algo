package com.wjd.lr.impl.template;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.*;
import com.wjd.lr.expr.handler.TemplateHandler;
import org.mvel2.MVEL;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.impl.StaticMethodImportResolverFactory;

import java.util.Date;

/**
 * MVEL2 template handler
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class Mvel2TemplateHandler extends TemplateHandler {

    /**
     * template context
     */
    private Mvel2TemplateContext ctx;

    /**
     * Instantiates a new Mvel 2 template handler.
     */
    public Mvel2TemplateHandler() {
        this(new Mvel2TemplateContext());
    }

    /**
     * Instantiates a new Mvel 2 template handler.
     *
     * @param ctx the ctx
     */
    public Mvel2TemplateHandler(Mvel2TemplateContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Expr handle(Template template) {
        Object result = evalScript(template.getScript());
        if (result == null) {
            return new NullValue();
        }
        Class<?> clazz = result.getClass();
        if (clazz == Boolean.class) {
            return new BoolValue((Boolean) result);
        } else if (clazz == Short.class
                || clazz == Integer.class
                || clazz == Long.class
                || clazz == Float.class
                || clazz == Double.class) {
            return new NumericValue(result);
        } else if (clazz == Character.class
                || clazz == String.class) {
            return new StringValue(String.valueOf(result));
        } else if (clazz == Date.class) {
            return new DateTimeValue(result);
        }
        return new TextExpr(String.valueOf(result));
    }

    /**
     * 执行脚本
     *
     * @param script 脚本
     * @return 脚本执行结果
     */
    private Object evalScript(String script) {
        // 编译模板脚本
        ExpressionCompiler compiler = new ExpressionCompiler(script, ctx.getParseContext());
        CompiledExpression compiledExpr = compiler.compile();

        // 执行模板脚本
        return MVEL.executeExpression(compiledExpr, ctx.getExecuteContext(),
                new StaticMethodImportResolverFactory(ctx.getParseContext()));
    }

    /**
     * @return template context
     */
    public Mvel2TemplateContext getCtx() {
        return ctx;
    }

    /**
     * @param ctx template context
     */
    public void setCtx(Mvel2TemplateContext ctx) {
        this.ctx = ctx;
    }
}

package com.wjd.lr.service.sql;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.*;
import com.wjd.lr.expr.handler.TemplateHandler;
import com.wjd.lr.template.TemplateContext;
import com.wjd.lr.template.mvel2.Mvel2TemplateContext;
import com.wjd.lr.template.mvel2.Mvel2TemplateExecutor;

import java.util.Date;

/**
 * Template expr handler
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class SqlTemplateHandler extends TemplateHandler {

    /**
     * Mvel2 Template Context
     */
    private TemplateContext ctx;

    /**
     * Instantiates a new Sql template handler.
     */
    public SqlTemplateHandler() {
        this(new Mvel2TemplateContext());
    }

    /**
     * Instantiates a new Sql template handler.
     *
     * @param context the context
     */
    public SqlTemplateHandler(TemplateContext context) {
        this.ctx = context;
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
        return new Mvel2TemplateExecutor().execute(script, ctx);
    }

}

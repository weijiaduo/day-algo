package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ast.Template;
import com.wjd.lr.expr.Expr;

/**
 * 模板处理器
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public abstract class TemplateHandler implements ExprHandler<Template> {

    @Override
    public boolean accept(Expr expr) {
        return expr instanceof Template;
    }

    @Override
    public abstract Expr handle(Template template);

}

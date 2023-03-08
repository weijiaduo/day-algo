package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用函数规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class NativeFunctionHandler extends BaseRuleHandler<ExprParser.NativeFuncContext> {

    public NativeFunctionHandler(ExprVisitor visitor) {
        super(visitor);
    }

    @Override
    public String handle(ExprParser.NativeFuncContext ctx) {
        String funcName = ctx.funcName().getText();
        List<String> params = new ArrayList<>();
        for (ExprParser.ExprContext expr : ctx.expr()) {
            params.add(visitor.visit(expr));
        }
        return funcName + "(" + String.join(", ", params) + ")";
    }

}

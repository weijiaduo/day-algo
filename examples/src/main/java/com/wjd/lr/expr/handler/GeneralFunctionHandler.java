package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;

/**
 * 通用函数规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class GeneralFunctionHandler extends BaseRuleHandler<ExprParser.GeneralFuncContext> {

    public GeneralFunctionHandler(ExprVisitor visitor) {
        super(visitor);
    }

    @Override
    public String handle(ExprParser.GeneralFuncContext ctx) {
        // TODO: transform real database function
        String funcName = ctx.funcName().getText().toLowerCase();
        switch (funcName) {
            case "len":
                return length(ctx, visitor);
            case "ceil":
            case "floor":
            default:
                return visitor.visitChildren(ctx);
        }
    }

    private String length(ExprParser.GeneralFuncContext ctx, ExprVisitor visitor) {
        String funcStr = visitor.visitChildren(ctx);
        return "length" + funcStr.substring(3);
    }

}

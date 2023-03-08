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
public class GeneralFuncHandler extends BaseRuleHandler<ExprParser.GeneralFuncContext> {

    public GeneralFuncHandler(ExprVisitor visitor) {
        super(visitor);
    }

    @Override
    public String handle(ExprParser.GeneralFuncContext ctx) {
        // TODO: transform real database function
        String funcName = ctx.funcName().getText().toLowerCase();
        switch (funcName) {
            case "len":
                return length(ctx);
            case "ceil":
            case "floor":
            default:
                return defaultFunc(ctx);
        }
    }

    private String length(ExprParser.GeneralFuncContext ctx) {
        List<String> params = getParamList(ctx);
        return "length(" + String.join(", ", params) + ")";
    }

    /**
     * 默认的方法解析
     *
     * @param ctx 方法上下文
     * @return 方法字符串
     */
    private String defaultFunc(ExprParser.GeneralFuncContext ctx) {
        String funcName = ctx.funcName().getText();
        List<String> params = getParamList(ctx);
        return funcName + "(" + String.join(", ", params) + ")";
    }

    /**
     * 获取解析后的参数列表
     *
     * @param ctx 方法上下文
     * @return 参数字符串列表
     */
    private List<String> getParamList(ExprParser.GeneralFuncContext ctx) {
        List<String> params = new ArrayList<>();
        for (ExprParser.ExprContext expr : ctx.expr()) {
            params.add(visitor.visit(expr));
        }
        return params;
    }

}

package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.function.FunctionBuilder;
import com.wjd.lr.expr.model.Function;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用函数规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class GeneralFuncHandler extends BaseRuleHandler<ExprParser.GeneralFuncContext> {

    /**
     * 函数构建器
     */
    private final FunctionBuilder functionBuilder;

    public GeneralFuncHandler(ExprVisitor visitor, FunctionBuilder functionBuilder) {
        super(visitor);
        this.functionBuilder = functionBuilder;
    }

    @Override
    public String handle(ExprParser.GeneralFuncContext ctx) {
        String funcName = ctx.funcName().getText().toLowerCase();
        List<String> params = getParamList(ctx);
        Function function = new Function(funcName, params);
        String expr = buildFunctionExpr(function);
        if (expr != null) {
            return expr;
        }
        return ctx.getText();
    }

    /**
     * 构建 SQL 函数表达式字符串
     *
     * @param function 函数
     * @return 函数表达式字符串
     */
    private String buildFunctionExpr(Function function) {
        try {
            Method m = functionBuilder.getClass().getDeclaredMethod(function.getName(), Function.class);
            return (String) m.invoke(functionBuilder, function);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

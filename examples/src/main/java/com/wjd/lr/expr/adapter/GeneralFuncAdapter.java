package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.function.FunctionBuilder;
import com.wjd.lr.expr.model.ExprItem;
import com.wjd.lr.expr.model.Function;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用函数适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class GeneralFuncAdapter implements RuleAdapter {

    /**
     * 访问者
     */
    private final ExprVisitor visitor;
    /**
     * 构建器
     */
    private final FunctionBuilder builder;

    public GeneralFuncAdapter(ExprVisitor visitor, FunctionBuilder builder) {
        this.visitor = visitor;
        this.builder = builder;
    }

    @Override
    public boolean accept(RuleNode ruleNode) {
        return ruleNode instanceof ExprParser.GeneralFuncContext;
    }

    @Override
    public Function adapt(RuleNode ruleNode) {
        ExprParser.GeneralFuncContext ctx = (ExprParser.GeneralFuncContext) ruleNode;
        String funcName = ctx.funcName().getText().toLowerCase();
        List<String> params = getParamList(ctx);
        Function function = new Function(funcName, params);
        function.setText(ruleNode.getText());
        return function;
    }

    @Override
    public String build(ExprItem exprItem) {
        return builder.build((Function) exprItem);
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

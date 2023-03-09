package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.function.FunctionBuilder;
import com.wjd.lr.expr.model.ExprItem;
import com.wjd.lr.expr.model.Function;
import com.wjd.lr.expr.model.NativeFunction;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 本地函数适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class NativeFuncAdapter implements RuleAdapter {

    /**
     * 访问者
     */
    private final ExprVisitor visitor;
    /**
     * 构建者
     */
    private final FunctionBuilder builder;

    public NativeFuncAdapter(ExprVisitor visitor, FunctionBuilder builder) {
        this.visitor = visitor;
        this.builder = builder;
    }

    @Override
    public boolean accept(RuleNode ruleNode) {
        return ruleNode instanceof ExprParser.NativeFuncContext;
    }

    @Override
    public NativeFunction adapt(RuleNode ruleNode) {
        ExprParser.NativeFuncContext ctx = (ExprParser.NativeFuncContext) ruleNode;
        String funcName = ctx.funcName().getText();
        List<String> params = getParamList(ctx);
        NativeFunction function = new NativeFunction(funcName, params);
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
    private List<String> getParamList(ExprParser.NativeFuncContext ctx) {
        List<String> params = new ArrayList<>();
        for (ExprParser.ExprContext expr : ctx.expr()) {
            params.add(visitor.visit(expr));
        }
        return params;
    }

}

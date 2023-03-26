package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.GeneralFunction;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用函数适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class GeneralFuncAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new General func adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public GeneralFuncAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.GeneralFuncContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.GeneralFuncContext ctx = (ExprParser.GeneralFuncContext) parseTree;
        String funcName = ctx.funcName().getText().toLowerCase();
        List<Expr> params = getParamList(ctx);
        GeneralFunction function = new GeneralFunction(funcName, params);
        return handle(function);
    }

    /**
     * 获取解析后的参数列表
     *
     * @param ctx 方法上下文
     * @return 参数字符串列表
     */
    private List<Expr> getParamList(ExprParser.GeneralFuncContext ctx) {
        List<Expr> params = new ArrayList<>();
        for (ExprParser.ExprContext expr : ctx.expr()) {
            params.add(visitor.visit(expr));
        }
        return params;
    }

}

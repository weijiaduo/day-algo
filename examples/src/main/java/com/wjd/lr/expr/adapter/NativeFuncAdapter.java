package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.ast.NativeFunction;
import com.wjd.lr.expr.ast.TextExpr;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 本地函数适配器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class NativeFuncAdapter extends AbstractExprAdapter {

    /**
     * Instantiates a new Native func adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    public NativeFuncAdapter(ExprBuilder builder, ExprVisitor visitor) {
        super(builder, visitor);
    }

    @Override
    public boolean accept(ParseTree parseTree) {
        return parseTree instanceof ExprParser.NativeFuncContext;
    }

    @Override
    public Expr adapt(ParseTree parseTree) {
        ExprParser.NativeFuncContext ctx = (ExprParser.NativeFuncContext) parseTree;
        String funcName = ctx.funcName().getText();
        List<Expr> params = getParamList(ctx);
        return handle(new NativeFunction(funcName, params));
    }

    /**
     * 获取解析后的参数列表
     *
     * @param ctx 方法上下文
     * @return 参数字符串列表
     */
    private List<Expr> getParamList(ExprParser.NativeFuncContext ctx) {
        List<Expr> params = new ArrayList<>();
        if (ctx.STAR() != null) {
            params.add(new TextExpr("*"));
        } else {
            for (ParseTree child : ctx.children) {
                if (child instanceof ExprParser.ExprContext
                        || child instanceof ExprParser.TypeNameContext) {
                    params.add(visitor.visit(child));
                }
            }
        }
        return params;
    }

}

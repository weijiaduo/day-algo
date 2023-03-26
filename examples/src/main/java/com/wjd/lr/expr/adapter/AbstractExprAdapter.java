package com.wjd.lr.expr.adapter;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.handler.ExprHandler;

/**
 * Expr Adapter
 *
 * @author weijiaduo
 * @since 2023/3/26
 */
public abstract class AbstractExprAdapter implements ParseTreeAdapter<Expr> {

    /**
     * Expr Builder
     */
    protected final ExprBuilder builder;
    /**
     * Expr Visitor
     */
    protected final ExprVisitor visitor;

    /**
     * Instantiates a new Abstract expr adapter.
     *
     * @param builder the builder
     * @param visitor the visitor
     */
    protected AbstractExprAdapter(ExprBuilder builder, ExprVisitor visitor) {
        this.builder = builder;
        this.visitor = visitor;
    }

    /**
     * Get expr handler
     *
     * @param expr expr
     * @return ExprHandler
     */
    protected <E extends Expr> ExprHandler<? super E> getHandler(E expr) {
        for (ExprHandler<?> handler : builder.getHandlers()) {
            if (handler.accept(expr)) {
                try {
                    //noinspection unchecked
                    return (ExprHandler<? super E>) handler;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Handle expr
     *
     * @param expr expr
     * @param <E>  generic type
     * @return handled expr
     */
    protected <E extends Expr> Expr handle(E expr) {
        ExprHandler<? super E> handler = getHandler(expr);
        return handler != null ? handler.handle(expr) : expr;
    }

}

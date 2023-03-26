package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.Expr;

/**
 * 表达式处理器
 * <p>
 * 对外开放的接口，在解析表达式时可以进行一些处理和转换
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public interface ExprHandler<T extends Expr> {

    /**
     * Accept expr
     *
     * @param expr expr
     * @return true/false
     */
    boolean accept(Expr expr);

    /**
     * expr -> handled expr
     *
     * @param expr expr
     * @return new expr
     */
    Expr handle(T expr);

}

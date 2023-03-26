package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.GeneralFunction;

/**
 * 通用函数处理器
 *
 * @author weijiaduo
 * @since 2023/3/26
 */
public abstract class GeneralFunctionHandler extends FunctionHandler {

    @Override
    public boolean accept(Expr expr) {
        return expr instanceof GeneralFunction;
    }

}

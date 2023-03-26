package com.wjd.lr.expr;

import com.wjd.lr.expr.ast.ExprList;

/**
 * 表达式语法树访问者
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ExprVisitor extends AbstractExprVisitor<Expr> {

    @Override
    protected Expr aggregateResult(Expr aggregate, Expr nextResult) {
        ExprList exprList;
        if (aggregate instanceof ExprList) {
            exprList = (ExprList) aggregate;
        } else {
            exprList = new ExprList();
            if (aggregate != null) {
                exprList.add(aggregate);
            }
        }
        if (nextResult instanceof ExprList) {
            exprList.addAll((ExprList) nextResult);
        } else if (nextResult != null) {
            exprList.add(nextResult);
        }
        if (exprList.size() > 1) {
            return exprList;
        } else {
            return exprList.get(0);
        }
    }

}

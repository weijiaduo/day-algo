package com.wjd.lr.expr.builder.unary;

import com.wjd.lr.expr.builder.ExprItemBuilder;
import com.wjd.lr.expr.model.UnaryItem;

/**
 * 一元表达式构建器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class UnaryItemBuilder implements ExprItemBuilder<UnaryItem> {

    @Override
    public String build(UnaryItem item) {
        if ("not".equalsIgnoreCase(item.getOp())) {
            return item.getOp() + " " + item.getExpr();
        }
        return item.getOp() + item.getExpr();
    }

}

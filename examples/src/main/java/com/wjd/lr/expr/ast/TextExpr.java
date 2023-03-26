package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;

/**
 * 文本
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class TextExpr extends AbstractExpr {

    /**
     * Text
     */
    private final String text;

    /**
     * Instantiates a new Text expr.
     *
     * @param text the text
     */
    public TextExpr(String text) {
        this.text = text;
    }

    @Override
    public ExprType getType() {
        return ExprType.TEXT;
    }

    @Override
    public String toSql(ExprContext context) {
        return text;
    }

    /**
     * @return text
     */
    public String getText() {
        return text;
    }
}

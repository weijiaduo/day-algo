package com.wjd.lr.expr.model;

/**
 * 表达式项目
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public abstract class ExprItem {

    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

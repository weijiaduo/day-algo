package com.wjd.pattern.decorator;

/**
 * @since 2021/11/29
 */
public class SideBorder extends Border {

    private char borderChar;

    protected SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        // 左右两边加上装饰符后，长度需要加2
        return 1 + display.getColumns() + 1;
    }

    @Override
    public String getRowText(int row) {
        // 给左右两边加上装饰符
        return borderChar + display.getRowText(row) + borderChar;
    }
}

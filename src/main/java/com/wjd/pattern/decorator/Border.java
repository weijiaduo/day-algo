package com.wjd.pattern.decorator;

/**
 * @since 2021/11/29
 */
public abstract class Border extends Display {

    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return display.getRowText(row);
    }
}

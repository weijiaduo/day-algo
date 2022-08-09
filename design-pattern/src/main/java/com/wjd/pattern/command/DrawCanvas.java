package com.wjd.pattern.command;

import java.awt.*;

/**
 * @since 2021/12/14
 */
public class DrawCanvas extends Canvas implements Drawable {
    /* 颜色 */
    private Color color = Color.red;
    /* 绘制的原点半径 */
    private int radius = 6;
    /* 历史记录 */
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    public void paint(Graphics g) {
        System.out.println("paint");
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}

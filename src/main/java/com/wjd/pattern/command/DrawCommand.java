package com.wjd.pattern.command;

import java.awt.*;

/**
 * @since 2021/12/14
 */
public class DrawCommand implements Command {

    protected Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}

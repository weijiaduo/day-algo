package com.wjd.pattern.factorymethod.factory;

import com.wjd.pattern.factorymethod.product.Square;

public class SquareFactory implements ShapeFactory {

    @Override
    public Square createShape() {
        return new Square();
    }
}

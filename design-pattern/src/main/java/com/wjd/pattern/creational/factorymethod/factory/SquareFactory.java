package com.wjd.pattern.creational.factorymethod.factory;

import com.wjd.pattern.creational.factorymethod.product.Square;

public class SquareFactory implements ShapeFactory {

    @Override
    public Square createShape() {
        return new Square();
    }
}

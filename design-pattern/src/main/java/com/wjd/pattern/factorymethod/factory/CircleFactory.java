package com.wjd.pattern.factorymethod.factory;

import com.wjd.pattern.factorymethod.product.Circle;

public class CircleFactory implements ShapeFactory {

    @Override
    public Circle createShape() {
        return new Circle();
    }

}

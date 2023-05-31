package com.wjd.pattern.creational.factorymethod.factory;

import com.wjd.pattern.creational.factorymethod.product.Circle;

public class CircleFactory implements ShapeFactory {

    @Override
    public Circle createShape() {
        return new Circle();
    }

}

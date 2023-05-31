package com.wjd.pattern.creational.factorymethod.factory;

import com.wjd.pattern.creational.factorymethod.product.Shape;

public interface ShapeFactory {

    /**
     * 产品工厂方法
     * @return 产品
     */
    Shape createShape();

}

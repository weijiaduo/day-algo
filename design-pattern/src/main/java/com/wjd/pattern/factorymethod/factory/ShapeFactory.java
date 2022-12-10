package com.wjd.pattern.factorymethod.factory;

import com.wjd.pattern.factorymethod.product.Shape;

public interface ShapeFactory {

    /**
     * 产品工厂方法
     * @return 产品
     */
    Shape createShape();

}

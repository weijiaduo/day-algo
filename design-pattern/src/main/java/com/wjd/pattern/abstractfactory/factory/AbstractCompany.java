package com.wjd.pattern.abstractfactory.factory;

import com.wjd.pattern.abstractfactory.product.AbstractComputer;
import com.wjd.pattern.abstractfactory.product.AbstractMobilePhone;

public abstract class AbstractCompany {

    /**
     * 生产电脑产品
     *
     * @return 电脑产品
     */
    public abstract AbstractComputer createComputer();

    /**
     * 生产手机产品
     *
     * @return 手机产品
     */
    public abstract AbstractMobilePhone createMobilePhone();

}

package com.wjd.pattern.creational.abstractfactory.factory;

import com.wjd.pattern.creational.abstractfactory.product.HuaweiComputer;
import com.wjd.pattern.creational.abstractfactory.product.HuaweiMobilePhone;

public class HuaweiCompany extends AbstractCompany {

    @Override
    public HuaweiComputer createComputer() {
        return new HuaweiComputer();
    }

    @Override
    public HuaweiMobilePhone createMobilePhone() {
        return new HuaweiMobilePhone();
    }
}

package com.wjd.pattern.abstractfactory.factory;

import com.wjd.pattern.abstractfactory.product.HuaweiComputer;
import com.wjd.pattern.abstractfactory.product.HuaweiMobilePhone;

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

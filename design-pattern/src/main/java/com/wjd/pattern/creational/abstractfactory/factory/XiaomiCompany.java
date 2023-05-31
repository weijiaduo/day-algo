package com.wjd.pattern.creational.abstractfactory.factory;

import com.wjd.pattern.creational.abstractfactory.product.XiaomiComputer;
import com.wjd.pattern.creational.abstractfactory.product.XiaomiMobilePhone;

public class XiaomiCompany extends AbstractCompany {

    @Override
    public XiaomiComputer createComputer() {
        return new XiaomiComputer();
    }

    @Override
    public XiaomiMobilePhone createMobilePhone() {
        return new XiaomiMobilePhone();
    }
}

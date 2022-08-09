package com.wjd.pattern.abstractfactory.factory;

import com.wjd.pattern.abstractfactory.product.XiaomiComputer;
import com.wjd.pattern.abstractfactory.product.XiaomiMobilePhone;

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

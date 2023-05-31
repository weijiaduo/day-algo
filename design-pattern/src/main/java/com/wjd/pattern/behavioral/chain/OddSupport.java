package com.wjd.pattern.behavioral.chain;

/**
 * @since 2021/12/7
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}

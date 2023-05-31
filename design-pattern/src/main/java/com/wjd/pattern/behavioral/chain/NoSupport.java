package com.wjd.pattern.behavioral.chain;

/**
 * @since 2021/12/7
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }

}

package com.wjd.pattern.templatemethod;

/**
 * @since 2022/1/15
 */
public abstract class AbstractDisplay {

    public abstract void open();
    public abstract void print();
    public abstract void close();

    /**
     * 模板方法，定义流程
     */
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }

}

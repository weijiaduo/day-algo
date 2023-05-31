package com.wjd.pattern.behavioral.observer;

/**
 * @since 2022/1/11
 */
public interface Observer {

    /** 观察者被通知的回调接口 */
    void update(NumberGenerator generator);

}

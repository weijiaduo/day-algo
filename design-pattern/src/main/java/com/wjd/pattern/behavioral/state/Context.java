package com.wjd.pattern.behavioral.state;

/**
 * @since 2021/12/11
 */
public interface Context {

    void setClock(int hour);
    void changeState(State state);
    void callSecurityCenter(String msg);
    void recordLog(String msg);

}

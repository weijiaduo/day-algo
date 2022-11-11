package com.wjd.pattern.state;

/**
 * @since 2021/12/11
 */
public interface State {

    void doClock(Context context, int hour);
    void doUse(Context context);
    void doAlarm(Context context);
    void doPhone(Context context);

}

package com.wjd.pattern.mediator;

/**
 * @since 2022/1/23
 */
public interface Colleague {

    void setMediator(Mediator mediator);
    void setColleagueEnabled(boolean enabled);

}

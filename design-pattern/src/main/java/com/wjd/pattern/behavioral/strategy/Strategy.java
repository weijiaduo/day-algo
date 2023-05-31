package com.wjd.pattern.behavioral.strategy;

/**
 * @since 2022/1/18
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}

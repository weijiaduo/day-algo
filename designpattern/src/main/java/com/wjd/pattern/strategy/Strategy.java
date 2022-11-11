package com.wjd.pattern.strategy;

/**
 * @since 2022/1/18
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}

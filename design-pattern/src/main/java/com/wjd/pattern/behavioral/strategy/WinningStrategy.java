package com.wjd.pattern.behavioral.strategy;

import java.util.Random;

/**
 * @since 2022/1/18
 */
public class WinningStrategy implements Strategy {

    private Random random;
    private boolean won = false;
    private Hand preHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            preHand = Hand.getHand(random.nextInt(3));
        }
        return preHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}

package com.wjd.concurrency.cas.random;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 《并发编程实战》-第15章
 * 原子变量随机数
 * @since 2022/4/27
 */
public class AtomicPseudoRandom extends PseudoRandom {

    private AtomicInteger seed;

    public AtomicPseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    @Override
    public int nextInt(int n) {
        while (true) {
            int s = seed.get();
            int nextSeed = calculateNext(s);
            if (seed.compareAndSet(s, nextSeed)) {
                int remainder = s % n;
                return remainder > 0 ? remainder : remainder + n;
            }
        }
    }
}

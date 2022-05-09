package com.wjd.concurrency.cas.random;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 《并发编程实战》-第15章
 * 重入锁随机数
 * @since 2022/4/27
 */
public class ReentrantLockPseudoRandom extends PseudoRandom {

    private final Lock lock = new ReentrantLock(false);

    private int seed;

    public ReentrantLockPseudoRandom(int seed) {
        this.seed = seed;
    }

    @Override
    public int nextInt(int n) {
        lock.lock();
        try {
            int s = seed;
            seed = calculateNext(s);
            int remainder = s % n;
            return remainder > 0 ? remainder : remainder + n;
        } finally {
            lock.unlock();
        }
    }
}

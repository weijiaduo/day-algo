package com.wjd.concurrency.cancel.task;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 《并发编程实战》-第7章
 * 取消策略-取消标志
 * @since 2022/5/4
 */
public class MarkCancellationTask implements Runnable {

    /**
     * 取消标志
     */
    private volatile boolean cancelled;

    private final List<BigInteger> primes = new ArrayList<>();

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }
}

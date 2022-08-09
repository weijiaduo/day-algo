package com.wjd.concurrency.cas;

/**
 * 《并发编程实战》-第15章
 * 模拟 CAS 操作
 * @since 2022/4/27
 */
public class SimulatedCAS {

    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return (expectValue == compareAndSwap(expectValue, newValue));
    }

}

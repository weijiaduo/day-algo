package com.wjd.concurrency.cas;

/**
 * 《并发编程实战》-第15章
 * 基于 CAS 实现的非阻塞计数器
 * @since 2022/4/27
 */
public class CasCounter {

    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }

}

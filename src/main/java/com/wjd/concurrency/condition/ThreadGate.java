package com.wjd.concurrency.condition;

/**
 * 《并发编程实战》-第14章
 * @since 2022/5/1
 */
public class ThreadGate {
    // 条件谓词： opened-since(n) (opened || generation > n)

    private boolean opened;
    private int generation;

    public synchronized void close() {
        opened = false;
    }

    public synchronized void open() {
        ++generation;
        opened = true;
        notifyAll();
    }

    /**
     * 阻塞并直到 opened-since(n) (generation on entry)
     */
    public synchronized void await() throws InterruptedException {
        int arrivalGeneration = generation;
        while (!opened && arrivalGeneration == generation) {
            wait();
        }
    }

}

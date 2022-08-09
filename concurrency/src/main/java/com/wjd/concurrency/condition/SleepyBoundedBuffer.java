package com.wjd.concurrency.condition;

/**
 * 《并发编程实战》-第14章
 *  轮询+休眠实现简单的阻塞
 * @since 2022/5/1
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    private static final int SLEEP_GRANULARITY = 100;

    public SleepyBoundedBuffer(int size) {
        super(size);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            if (!isFull()) {
                doPut(v);
                return;
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            if (!isEmpty()) {
                return doTake();
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

}

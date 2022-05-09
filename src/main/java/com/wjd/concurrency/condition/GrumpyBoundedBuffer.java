package com.wjd.concurrency.condition;

/**
 * 《并发编程实战》-第14章
 *  不满足前提条件时，直接返回失败
 * @since 2022/5/1
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws InterruptedException {
        if (isFull()) {
            throw new InterruptedException();
        }
        doPut(v);
    }

    public synchronized V take() throws InterruptedException {
        if (isEmpty()) {
            throw new InterruptedException();
        }
        return doTake();
    }

}

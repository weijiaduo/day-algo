package com.wjd.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 《并发编程实战》-第14章
 *  多个条件队列实现有界缓存
 * @since 2022/5/1
 */
public class ConditionBoundedBuffer<T> {

    private static final int BUFFER_SEIZE = 100;

    protected final Lock lock = new ReentrantLock();
    // 条件谓词：notFull (count < item.length)
    protected final Condition notFull = lock.newCondition();
    // 条件谓词：notEmpty (count > 0)
    protected final Condition notEmpty = lock.newCondition();

    private final T[] items = (T[]) new Object[BUFFER_SEIZE];
    private int tail;
    private int head;
    private int count;

    /**
     * 阻塞并直到：notFull
     */
    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = t;
            if (++tail == items.length) {
                tail = 0;
            }
            count++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞并直到：notEmpty
     */
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T t = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            count--;
            notFull.signalAll();
            return t;
        } finally {
            lock.unlock();
        }
    }

}

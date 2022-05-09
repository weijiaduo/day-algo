package com.wjd.concurrency.condition;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 《并发编程实战》-第14章
 *  基于AQS实现的二元闭锁
 * @since 2022/5/1
 */
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void signal() {
        sync.tryReleaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            // 如果闭锁是开的（state == 1），就返回成功，否则返回失败
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int ignored) {
            setState(1); // 打开闭锁
            return true; // 现在其他线程可以获取该闭锁了
        }
    }
}

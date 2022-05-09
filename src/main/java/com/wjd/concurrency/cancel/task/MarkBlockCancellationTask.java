package com.wjd.concurrency.cancel.task;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;

/**
 * 《并发编程实战》-第7章
 * 取消策略-取消阻塞标志
 * @since 2022/5/4
 */
public class MarkBlockCancellationTask implements Runnable {

    /**
     * 取消标志
     */
    private volatile boolean cancelled;

    private final BlockingDeque<BigInteger> queue;

    public MarkBlockCancellationTask(BlockingDeque<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                p = p.nextProbablePrime();
                // 阻塞操作，可能会一致阻塞
                queue.put(p);
            }
        } catch (InterruptedException e) {
            //
        }
    }

    public void cancel() {
        cancelled = true;
    }
}

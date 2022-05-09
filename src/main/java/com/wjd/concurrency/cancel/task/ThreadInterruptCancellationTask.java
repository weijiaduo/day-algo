package com.wjd.concurrency.cancel.task;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;

/**
 * 《并发编程实战》-第7章
 * 取消策略-中断取消
 * @since 2022/5/4
 */
public class ThreadInterruptCancellationTask implements Runnable {

    private final BlockingDeque<BigInteger> queue;

    public ThreadInterruptCancellationTask(BlockingDeque<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            // 1. 和取消标志方法一样，检查中断标志
            while (!Thread.currentThread().isInterrupted()) {
                p = p.nextProbablePrime();
                // 阻塞操作，可能会一致阻塞
                queue.put(p);
            }
        } catch (InterruptedException e) {
            // 2. 还提供了中断异常的取消方式
            Thread.currentThread().interrupt();
        }
    }
}

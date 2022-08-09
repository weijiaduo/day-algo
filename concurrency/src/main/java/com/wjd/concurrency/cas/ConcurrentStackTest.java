package com.wjd.concurrency.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *《并发编程实战》-第15章
 * 非阻塞栈
 * @since 2022/4/27
 */
public class ConcurrentStackTest {

    public static void main(String[] args) {
        int pushThreads = 100;
        final CountDownLatch latch = new CountDownLatch(pushThreads + pushThreads);
        final ExecutorService executor = Executors.newFixedThreadPool(50);

        final ConcurrentStack<Integer> stack = new ConcurrentStack<>();
        final AtomicInteger pushSum = new AtomicInteger(0);
        final AtomicInteger popSum = new AtomicInteger(0);
        for (int i = 0; i < pushThreads; i++) {
            executor.submit(() -> {
                int v = (int)(System.nanoTime() % 1000);
                pushSum.addAndGet(v);
                stack.push(v);
                latch.countDown();
            });

            executor.submit(() -> {
                Integer v;
                do {
                    v = stack.pop();
                } while (v == null);
                popSum.addAndGet(v);
                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("push: " + pushSum + ", pop: " + popSum);
    }

}

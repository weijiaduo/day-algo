package com.wjd.concurrency.cas.random;

import java.util.concurrent.*;

/**
 * 《并发编程实战》-第15章
 * 随机数性能测试
 * @since 2022/4/27
 */
public class RandomTest {

    public static void main(String[] args) throws InterruptedException {
        testReentrantLockPseudoRandom();
        testAtomicPseudoRandom();
    }

    static void testReentrantLockPseudoRandom() throws InterruptedException {
        int seed = 0;
        final ReentrantLockPseudoRandom random = new ReentrantLockPseudoRandom(seed);
        System.out.println("lock(ms): " + testRandomTime(random));
    }

    static void testAtomicPseudoRandom() throws InterruptedException {
        int seed = 0;
        AtomicPseudoRandom random = new AtomicPseudoRandom(seed);
        System.out.println("atomic(ms): " + testRandomTime(random));
    }

    static double testRandomTime(PseudoRandom random) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        long time = System.nanoTime();
        CountDownLatch latch = new CountDownLatch(1000000);
        for (int i = 0; i < 1000000; i++) {
            final int n = i + 1;
            executor.execute(() -> {
                random.nextInt(n);
                latch.countDown();
            });
        }
        latch.await();
        time = System.nanoTime() - time;
        executor.shutdown();
        return (time / Math.pow(10, 6));
    }

}

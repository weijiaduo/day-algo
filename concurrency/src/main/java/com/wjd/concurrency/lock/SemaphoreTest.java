package com.wjd.concurrency.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @since 2022/3/27
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        testSemaphore();
    }

    private static void testSemaphore() {
        for (int i = 0; i < 100; i++) {
            new SemaphoreThread().start();
        }
    }

    static class SemaphoreThread extends Thread {
        static Semaphore semaphore = new Semaphore(10);
        static AtomicInteger count = new AtomicInteger(0);
        static int num = 0;

        int id = ++num;

        @Override
        public void run() {
            try {
                semaphore.acquire();

                // 数量不应该超过信号量的大小
                int c = count.incrementAndGet();
                System.out.println("Thread: " + id + ", acquire count: " + c);

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                int c = count.decrementAndGet();
                semaphore.release();
                // System.out.println("Thread " + id + " release: " + (count--));
            }
        }
    }

}

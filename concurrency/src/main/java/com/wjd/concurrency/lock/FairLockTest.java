package com.wjd.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @since 2022/3/27
 */
public class FairLockTest {

    public static void main(String[] args) {
        // testUnFairLock();
        testFairLock();
    }

    private static void testUnFairLock() {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new UnFairLockThread();
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void testFairLock() {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new FairLockThread();
            threads[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class UnFairLockThread extends Thread {
        static int num = 0;
        static ReentrantLock lock = new ReentrantLock();

        int id = ++num;

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("Thread: " + id);
            } finally {
                lock.unlock();
            }
        }
    }

    static class FairLockThread extends Thread {
        static int num = 0;
        static volatile int count = 0;
        static ReentrantLock lock = new ReentrantLock(true);

        int id = ++num;

        @Override
        public void run() {
            ++count;
            lock.lock();
            try {
                // 等待所有线程都到达lock()方法处
                while (count < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread: " + id);
            } finally {
                lock.unlock();
            }
        }
    }
}

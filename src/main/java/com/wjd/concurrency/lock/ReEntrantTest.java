package com.wjd.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @since 2022/3/22
 */
public class ReEntrantTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new RenEntrantThread();
        Thread t2 = new RenEntrantThread();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(RenEntrantThread.count);
    }

    static class RenEntrantThread extends Thread {
        static ReentrantLock lock = new ReentrantLock();
        static int count = 0;

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                // 加锁需要手动执行，不同于synchronized
                // 同一线程，可以多次获取同一把锁，即锁可重入
                lock.lock();
                try {
                    count++;
                } finally {
                    // 加锁多少次，就需要解锁多少次
                    // 放在finally中，保证能够释放锁
                    lock.unlock();
                }
            }
        }
    }

}

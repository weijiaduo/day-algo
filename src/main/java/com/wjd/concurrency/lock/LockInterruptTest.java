package com.wjd.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @since 2022/3/22
 */
public class LockInterruptTest {

    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new LockInterruptThread();
        Thread t2 = new LockThread();

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断线程
        t1.interrupt();
    }

    static class LockInterruptThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Thread1 lock1 start");
                lock1.lockInterruptibly();
                System.out.println("Thread1 lock1 end");

                // 等待造成死锁
                Thread.sleep(1000);

                System.out.println("Thread1 lock2 start");
                lock2.lockInterruptibly();
                System.out.println("Thread1 lock2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
            }
            System.out.println("Thread1 exit");
        }
    }

    static class LockThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread2 lock2 start");
            lock2.lock();
            System.out.println("Thread2 lock2 end");

            try {
                // 等待造成死锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread2 lock1 start");
            lock1.lock();
            System.out.println("Thread2 lock1 end");

            lock2.unlock();
            lock1.unlock();

            System.out.println("Thread2 exit");
        }
    }

}

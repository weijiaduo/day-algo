package com.wjd.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @since 2022/3/26
 */
public class TimeLockTest {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        testTryLock();
        // testLockTimeOut();
    }

    private static void testTryLock() {
        Thread lockThread = new LockThread();
        lockThread.start();

        try {
            // 等lockThread先拿到锁
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread timeLockThread = new TryLockThread();
        timeLockThread.start();
    }

    private static void testLockTimeOut() {
        Thread lockThread = new LockThread();
        lockThread.start();

        try {
            // 等lockThread先拿到锁
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread timeLockThread = new TimeLockThread();
        timeLockThread.start();
    }

    static class TryLockThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("test try lock");
                if (lock.tryLock()) {
                    System.out.println("try lock success");
                } else {
                    System.out.println("try lock failed");
                }
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println("try lock unlock");
                }
            }
        }
    }

    static class TimeLockThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("try time lock");
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    System.out.println("try time lock success");
                } else {
                    System.out.println("try time lock time out");
                }
            } catch (InterruptedException e) {
                System.out.println("try time lock interrupt");
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println("try time lock unlock");
                }
            }
        }
    }

    static class LockThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("lock");
            try {
                // 超过定时锁的时间
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("unlock");
            }
        }
    }
}

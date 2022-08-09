package com.wjd.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @since 2022/3/27
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        testThreadAwait();
    }

    private static void testThreadAwait() {
        Thread awaitThread = new AwaitThread();
        awaitThread.start();

        // 等待是await执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread signalThread = new SignalThread();
        signalThread.start();
    }

    static class AwaitThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("await thread lock");
                System.out.println("thread await start");
                condition.await();
                System.out.println("thread await end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("await thread unlock");
            }
        }
    }

    static class SignalThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("signal thread lock");
                System.out.println("thread signal start");
                condition.signal();
                System.out.println("thread signal end");
            } finally {
                // 没释放锁之前，await线程就算唤醒了，也只是在等待锁
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println("signal thread unlock");
            }
        }
    }

}

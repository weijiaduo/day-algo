package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class YieldThreadTest {

    public static void main(String[] args) {
        testYield();
    }

    public static void testYield() {
        Thread yieldThread = new YieldThread();
        yieldThread.start();

        Thread noYieldThread = new NoYieldThread();
        noYieldThread.start();
    }

    static class YieldThread extends Thread {
        int count = 0;

        @Override
        public void run() {
            while (true) {
                System.out.println("YieldThread: " + count++);
                Thread.yield();
            }
        }
    }

    static class NoYieldThread extends Thread {
        int count = 0;

        @Override
        public void run() {
            while (true) {
                System.out.println("NoYieldThread: " + count++);
            }
        }
    }

}

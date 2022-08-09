package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class InterruptThreadTest {

    public static void main(String[] args) throws InterruptedException {
        testNoHandleInterrupt();
        testHandleInterrupt();
        testCatchInterrupt();
    }

    /**
     * 不处理中断
     */
    public static void testNoHandleInterrupt() throws InterruptedException {
        Thread t = new NoHandleInterruptThread();
        t.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            t.interrupt();
        }
    }

    /**
     * 处理中断
     */
    public static void testHandleInterrupt() throws InterruptedException {
        Thread t = new HandleInterruptThread();
        t.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(400);
            t.interrupt();
        }
    }

    /**
     * 捕获中断
     */
    public static void testCatchInterrupt() throws InterruptedException {
        Thread t = new CatchInterruptedThread();
        t.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(400);
            t.interrupt();
        }
    }

    static class NoHandleInterruptThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("NoHandleInterruptThread");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("NoHandleInterruptThread InterruptedException");
                }
            }
        }
    }

    static class HandleInterruptThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Current Thread interrupted");
                    break;
                }
                System.out.println("HandleInterruptThread");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("HandleInterruptThread InterruptedException");
                }
            }
        }
    }

    static class CatchInterruptedThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("CatchInterruptedThread");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("CatchInterruptedThread InterruptedException");
                    break;
                }
            }
        }
    }

}

package com.wjd.concurrency.thread;

/**
 * @since 2022/3/21
 */
public class DaemonThreadTest {

    public static void main(String[] args) {
        testDaemon();
    }

    public static void testNotDaemon() {
        System.out.println("Main start");
        Thread t = new DaemonThread();
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main end");
    }

    public static void testDaemon() {
        System.out.println("Main start");
        Thread t = new DaemonThread();
        t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main end");
    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Daemon Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

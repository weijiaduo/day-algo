package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class VolatileThreadTest {

    static int count1 = 0;
    static volatile int count2 = 0;

    public static void main(String[] args) {
        testNoVolatile();
        // testVolatile();
    }

    public static void testNoVolatile() {
        Thread t = new NoVolatileThread();
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count1 = -1;
        System.out.println("count end");
    }

    public static void testVolatile() {
        Thread t = new VolatileThread();
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count2 = -1;
        System.out.println("count end");
    }

    static class NoVolatileThread extends Thread {
        int count = 0;
        @Override
        public void run() {
            while (count < 100) {
                if (count1 != 0) {
                    System.out.println(System.currentTimeMillis() + ": " + count);
                    break;
                }
                System.out.println(count++);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class VolatileThread extends Thread {
        int count = 0;
        @Override
        public void run() {
            while (count < 100) {
                if (count2 != 0) {
                    System.out.println(System.currentTimeMillis() + ": " + count);
                    break;
                }
                System.out.println(count++);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

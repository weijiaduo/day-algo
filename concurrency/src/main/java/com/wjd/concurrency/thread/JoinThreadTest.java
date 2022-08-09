package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class JoinThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // testJoinThread();
        testJoinTimeThread();
    }

    /**
     * join无限等待
     */
    public static void testJoinThread() throws InterruptedException {
        Thread t = new JoinThread();
        t.start();

        System.out.println("Join start");
        t.join();
        System.out.println("Join end");
    }

    /**
     * join超时等待
     */
    public static void testJoinTimeThread() throws InterruptedException {
        Thread t = new JoinThread();
        t.start();

        System.out.println("Join time start");
        t.join(3000);
        System.out.println("Join time end");
    }

    static class JoinThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("JoinThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

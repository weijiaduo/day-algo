package com.wjd.concurrency.thread;

/**
 * @since 2022/3/21
 */
public class RunnableThreadTest {

    public static void main(String[] args) {
        new Thread(new RunnableThread()).start();
    }

    static class RunnableThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Runnable");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

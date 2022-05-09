package com.wjd.concurrency.thread;

/**
 * @since 2022/3/21
 */
public class ExtendsThreadTest {

    public static void main(String[] args) {
        new ExtendsThread().start();
    }

    static class ExtendsThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Extends Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

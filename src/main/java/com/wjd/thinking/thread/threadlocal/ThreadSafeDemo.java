package com.wjd.thinking.thread.threadlocal;

public class ThreadSafeDemo {

    private int count = 0;

    public static void test() {
        Thread[] threads = new Thread[2];
        for (Thread thread: threads) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

    /***
     * 递增
     */
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

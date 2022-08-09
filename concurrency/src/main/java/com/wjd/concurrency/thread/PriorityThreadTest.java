package com.wjd.concurrency.thread;

/**
 * @since 2022/3/21
 */
public class PriorityThreadTest {

    public static void main(String[] args) {
        testPriority();
    }

    public static void testPriority() {
        Thread highPriority = new PriorityThread("High");
        highPriority.setPriority(Thread.MAX_PRIORITY);
        highPriority.start();

        Thread lowPriority = new PriorityThread("Low");
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        lowPriority.start();

        Thread normPriority = new PriorityThread("Norm");
        normPriority.setPriority(Thread.NORM_PRIORITY);
        normPriority.start();
    }

    static class PriorityThread extends Thread {
        static Object mutex = new Object();

        int count = 0;

        PriorityThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (count < 10000000) {
                synchronized (mutex) {
                    count++;
                }
            }
            System.out.println("Completed: " + getName() + " " + getPriority());
        }
    }

}

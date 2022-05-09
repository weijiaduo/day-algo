package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class WaitAndNotifyThreadTest {

    private static Object mutex = new Object();

    public static void main(String[] args) {
        testWaitAndNotify();
    }

    public static void testWaitAndNotify() {
        Thread waitThread = new WaitThread();
        waitThread.start();

        Thread notifyThread = new NotifyThread();
        notifyThread.start();
    }

    static class WaitThread extends Thread {
        @Override
        public void run() {
            synchronized (mutex) {
                System.out.println(System.currentTimeMillis() + ": Wait Thread enter");
                try {
                    System.out.println(System.currentTimeMillis() + ": Wait Thread wait");
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": Wait Thread end");
            }
        }
    }

    static class NotifyThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + ": Notify Thread start");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (mutex) {
                System.out.println(System.currentTimeMillis() + ": Notify Thread enter");

                // notify()只能唤醒等待线程，它想要重新运行必须等当前线程释放锁之后
                System.out.println(System.currentTimeMillis() + ": Notify Thread notify");
                mutex.notify();

                try {
                    // 持有锁不释放，即使notify()其他线程了，其他线程也无法运行
                    System.out.println(System.currentTimeMillis() + ": Notify Thread sleep");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(System.currentTimeMillis() + ": Notify Thread end");
            }
        }
    }

}

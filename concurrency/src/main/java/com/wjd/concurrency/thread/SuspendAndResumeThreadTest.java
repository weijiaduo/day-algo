package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class SuspendAndResumeThreadTest {

    private static Object mutex = new Object();

    public static void main(String[] args) throws InterruptedException {
        // testGoodResume();
        // testBadResume();
        testBetterResume();
    }

    public static void testGoodResume() throws InterruptedException {
        Thread t = new SuspendThread();
        t.start();

        // 等suspend挂起后再通知继续执行resume
        Thread.sleep(2000);
        System.out.println("Resume Thread");
        t.resume();

        // 其他线程尝试获取锁
        Thread.sleep(1000);
        Thread retryEnter = new TryMutexThread();
        retryEnter.start();
    }

    public static void testBadResume() throws InterruptedException {
        Thread t = new SuspendThread();
        t.start();

        // 立即通知继续执行，resume在suspend之前调用
        System.out.println("Resume Thread");
        t.resume();

        // 其他线程尝试获取锁
        Thread.sleep(1000);
        Thread retryEnter = new TryMutexThread();
        retryEnter.start();
    }

    public static void testBetterResume() throws InterruptedException {
        BetterSuspendAndResumeThread t = new BetterSuspendThread();
        t.start();

        // 立即通知继续执行，resume在suspend之前调用
        System.out.println("Resume Thread");
        t.resumeMe();

        // 其他线程尝试获取锁
        Thread.sleep(1000);
        Thread retryEnter = new TryMutexThread();
        retryEnter.start();
    }

    static class SuspendThread extends Thread {
        @Override
        public void run() {
            synchronized (mutex) {
                System.out.println("Suspend Thread enter");
                System.out.println("Suspend Thread suspend");
                // 挂起，但是不释放锁资源
                suspend();
                System.out.println("Suspend Thread exit");
            }
        }
    }

    static class BetterSuspendAndResumeThread extends Thread {
        volatile boolean resumeme = false;
        public void suspendMe() {
            boolean r = resumeme;
            resumeme = false;
            if (!r) {
                // 假如resume在suspend之前执行了，就不执行suspend
                System.out.println("Suspend Me");
                suspend();
            }
        }
        public void resumeMe() {
            resumeme = true;
            System.out.println("Resume Me");
            resume();
        }
    }

    static class BetterSuspendThread extends BetterSuspendAndResumeThread {
        @Override
        public void run() {
            synchronized (mutex) {
                System.out.println("Suspend Thread enter");
                System.out.println("Suspend Thread suspend");
                // 挂起，但是不释放锁资源
                suspendMe();
                System.out.println("Suspend Thread exit");
            }
        }
    }

    static class TryMutexThread extends Thread {
        @Override
        public void run() {
            System.out.println("TryMutex Thread start");
            synchronized (mutex) {
                System.out.println("TryMutex Thread enter");
                System.out.println("TryMutex Thread exit");
            }
        }
    }

}

package com.wjd.concurrency.executors;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 《并发编程实战》-第八章
 * 自定义线程工厂
 * @since 2022/5/10
 */
public class MyThreadFactory implements ThreadFactory {

    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyThread(r, poolName);
    }

    public static class MyThread extends Thread {
        public static final String DEFAULT_NAME = "MyAppThread";
        private static volatile boolean debugLifecycle = false;
        private static final AtomicInteger created = new AtomicInteger();
        private static final AtomicInteger alive = new AtomicInteger();

        public MyThread(Runnable r) {
            this(r, DEFAULT_NAME);
        }

        public MyThread(Runnable r, String name) {
            super(r, name + "--" + created.incrementAndGet());
            setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("UnCaught in thread " + t.getName() + "\n" + e);
                }
            });
        }

        @Override
        public void run() {
            boolean debug = debugLifecycle;
            if (debug) {
                System.out.println("Created " + getName());
            }
            try {
                alive.incrementAndGet();
                super.run();
            } finally {
                alive.decrementAndGet();
                if (debug) {
                    System.out.println("Exiting " + getName());
                }
            }
        }

        public static int getThreadsCreated () {
            return created.get();
        }

        public static int getThreadAlive() {
            return alive.get();
        }

        public static boolean getDebug() {
            return debugLifecycle;
        }

        public static void setDebug(boolean debug) {
            debugLifecycle = debug;
        }
    }
}

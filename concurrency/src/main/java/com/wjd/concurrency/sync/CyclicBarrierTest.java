package com.wjd.concurrency.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @since 2022/4/16
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        long time = timeTask(10, () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(time);
    }

    public static long timeTask(int nThreads, final Runnable task) throws Exception {
        class Time {
            public long value = 0;
        }
        final Time time = new Time();

        // nThreads + 1 是加上了主线程
        final CyclicBarrier gate = new CyclicBarrier(nThreads + 1,
                () -> time.value = System.nanoTime() - time.value);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        // 等待所有线程开始
                        gate.await();

                        task.run();

                        // 等待所有线程结束
                        gate.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        // 等待所有线程开始
        gate.await();
        // 等待所有线程结束
        gate.await();

        return time.value;
    }

}

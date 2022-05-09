package com.wjd.concurrency.cancel.thread;

import java.util.concurrent.BlockingDeque;

/**
 * @since 2022/5/7
 */
public class InterruptIgnoreThread {

    static class IgnoreThread extends Thread {

        BlockingDeque<Runnable> tasks;

        @Override
        public void run() {
            Runnable task;
            for(;;) {
                try {
                    task = tasks.take();
                    task.run();
                } catch (InterruptedException e) {
                    // 屏蔽忽略所有的中断
                }
            }
        }
    }

}

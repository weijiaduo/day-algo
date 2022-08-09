package com.wjd.concurrency.cancel.thread;

import java.util.concurrent.BlockingDeque;

/**
 * @since 2022/5/7
 */
public class InterruptExitThread {

    static class ExitThread extends Thread {

        BlockingDeque<Runnable> tasks;

        @Override
        public void run() {
            try {
                Runnable task;
                for(;;) {
                    // 检查是否发生了中断
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    task = tasks.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                // 中断线程
            } finally {
                // 清理
                cleanup();
                // 通知结束
                notifyExit();
            }
        }

        void cleanup() {
        }

        void notifyExit() {}
    }

}

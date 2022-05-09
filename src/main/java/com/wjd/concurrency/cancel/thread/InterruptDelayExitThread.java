package com.wjd.concurrency.cancel.thread;

import java.util.concurrent.BlockingDeque;

/**
 * @since 2022/5/7
 */
public class InterruptDelayExitThread {

    static class DelayExitThread extends Thread {

        BlockingDeque<Runnable> tasks;

        @Override
        public void run() {
            boolean interrupted = false;
            try {
                Runnable task;
                for(;;) {
                    try {
                        // 检查是否发生了中断
                        if (Thread.currentThread().isInterrupted()) {
                            // 记录中断信息
                            interrupted = true;
                        }

                        task = getNextTask();
                        if (task == null) {
                            break;
                        }
                        task.run();
                    } catch (InterruptedException e) {
                        // 记录中断信息
                        interrupted = true;
                    }
                }
            }finally {
                if (interrupted) {
                    // 恢复中断信息
                    Thread.currentThread().interrupt();
                }
                // 清理
                cleanup();
                // 通知结束
                notifyExit();
            }
        }

        void cleanup() {
        }

        void notifyExit() {}

        Runnable getNextTask() throws InterruptedException {
            return null;
        }
    }

}

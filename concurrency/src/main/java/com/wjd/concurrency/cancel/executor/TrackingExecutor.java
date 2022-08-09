package com.wjd.concurrency.cancel.executor;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 《并发编程实战》-第七章
 * 跟踪关闭之后被取消的任务
 * @since 2022/5/9
 */
public class TrackingExecutor extends AbstractExecutorService {

    private final ExecutorService exec;
    private final Set<Runnable> tasksCancelledAtShutdown = Collections.synchronizedSet(new HashSet<>());

    public TrackingExecutor(ExecutorService exec) {
        this.exec = exec;
    }

    @Override
    public void shutdown() {
    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable runnable) {
        exec.execute(() -> {
            try {
                runnable.run();
            } finally {
                // 如果服务关闭了，并且线程被中断了
                if (isShutdown() && Thread.currentThread().isInterrupted()) {
                    // 关闭后被取消的线程
                    tasksCancelledAtShutdown.add(runnable);
                }
            }
        });
    }
}

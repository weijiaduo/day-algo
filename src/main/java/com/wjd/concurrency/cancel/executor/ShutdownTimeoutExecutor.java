package com.wjd.concurrency.cancel.executor;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 《并发编程实战》-第七章
 * 超时等待服务关闭
 * @since 2022/5/9
 */
public class ShutdownTimeoutExecutor {

    boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicBoolean hasMail = new AtomicBoolean(false);
        try {
            for (final String host : hosts) {
                exec.execute(() -> {
                    if (checkMail(host)) {
                        hasMail.set(true);
                    }
                });
            }
        } finally {
            // 停止服务
            exec.shutdown();
            // 超时等待服务停止，避免线程一直不结束
            exec.awaitTermination(timeout, unit);
        }
        return hasMail.get();
    }

    boolean checkMail(String host) {
        return true;
    }

}

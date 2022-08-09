package com.wjd.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 《并发编程实战》-第八章
 * 任务依赖导致的线程死锁
 * @since 2022/5/10
 */
public class ThreadDeadlock {

    // 单线程的线程池
    private final ExecutorService exec = Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // 将发生死锁 —— 由于任务在等待子任务的结果
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            return "";
        }
    }

    public class LoadFileTask implements Callable<String> {

        private final String filename;

        public LoadFileTask(String filename) {
            super();
            this.filename = filename;
        }

        @Override
        public String call() throws Exception {
            return null;
        }
    }

}

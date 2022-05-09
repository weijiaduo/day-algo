package com.wjd.concurrency.cancel.executor;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 《并发编程实战》-第七章
 * 可靠的取消关闭操作
 * @since 2022/5/8
 */
public class LogService {

    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;

    private boolean isShutdown;
    private int reservations;

    public LogService(Writer writer) {
        this.writer = new PrintWriter(writer);
        this.queue = new LinkedBlockingQueue<>();
        this.loggerThread = new LoggerThread();
    }


    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                // 服务关闭了，禁止继续提交日志
                throw new IllegalStateException("Shutdown");
            }
            // 记录日志数量
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized(LogService.this) {
                        // 服务关闭且剩余日志都处理完了，线程才能退出
                        if (isShutdown && reservations == 0) {
                            break;
                        }
                    }
                    String msg = queue.take();
                    synchronized (LogService.this) {
                        reservations--;
                    }
                    writer.println(msg);
                }
            } catch (InterruptedException e) {
                // 即使发生了中断，只要服务没关闭就继续执行
            } finally {
                writer.close();
            }
        }
    }

}

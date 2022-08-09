package com.wjd.concurrency.cancel.executor;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 《并发编程实战》-第七章
 * “毒丸”对象
 * @since 2022/5/8
 */
public class LogPoisonService {

    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;

    private boolean isShutdown;
    private final String poison = new String("");

    public LogPoisonService(Writer writer) {
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
        while (true) {
            try {
                // 放入“毒丸”
                queue.put(poison);
                break;
            } catch (InterruptedException e) {
                // 重试
            }
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                // 服务关闭了，禁止继续提交日志
                throw new IllegalStateException("Shutdown");
            }
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    String msg = queue.take();
                    // 当遇到了“毒丸”对象，就立即停止
                    if (msg == poison) {
                        break;
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

package com.wjd.concurrency.runtask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * 《并发编程实战》-第6章
 *  支持关闭操作的的web服务器
 * @since 2022/5/2
 */
public class LifecycleWebServer {

    private final int NUM_THREADS = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (!executor.isShutdown()) {
            try {
                Socket connection = serverSocket.accept();
                executor.execute(() -> handleRequest(connection));
            } catch (RejectedExecutionException e) {
                if (!executor.isShutdown()) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private void handleRequest(Socket connection) {
    }

}

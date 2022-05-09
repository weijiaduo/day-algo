package com.wjd.concurrency.runtask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 《并发编程实战》-第6章
 *  使用线程池的web服务器
 * @since 2022/5/2
 */
public class TaskExecutorWebServer {

    static final int NUM_THREADS = 10;
    static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket connection = serverSocket.accept();
            executor.execute(() -> handleRequest(connection));
        }
    }

    private static void handleRequest(Socket connection) {
    }

}

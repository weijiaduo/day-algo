package com.wjd.concurrency.runtask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 《并发编程实战》-第6章
 *  串行的web服务器
 * @since 2022/5/2
 */
public class SingleThreadWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket connection = serverSocket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
    }

}

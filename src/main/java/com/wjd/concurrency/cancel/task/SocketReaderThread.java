package com.wjd.concurrency.cancel.task;

import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;

/**
 * 《并发编程实战》-第七章
 * 非阻塞方式模拟中断
 * @since 2022/5/8
 */
public class SocketReaderThread extends Thread {

    private final Socket socket;
    private final InputStream in;

    public SocketReaderThread(Socket socket, InputStream in) {
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                }
                if (count > 0) {
                    processBuffer(buf, count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processBuffer(byte[] buf, int count) {}
}

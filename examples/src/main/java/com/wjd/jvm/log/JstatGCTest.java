package com.wjd.jvm.log;


public class JstatGCTest {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[10 * SIZE_1K];
        }
        data = null;
        Thread.sleep(1000);
    }

}

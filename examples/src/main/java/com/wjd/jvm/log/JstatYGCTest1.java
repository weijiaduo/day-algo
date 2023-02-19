package com.wjd.jvm.log;

public class JstatYGCTest1 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    private static byte[] lastData = null;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        // 其他对象
        byte[] other = new byte[128 * SIZE_1K];
        other = null;

        // 每次生成8MB数据，其中2MB保留到下一秒内
        byte[] data = new byte[2 * SIZE_1M];
        for (int i = 0; i < 3; i++) {
            lastData = new byte[2 * SIZE_1M];
        }

        Thread.sleep(900);
    }

}

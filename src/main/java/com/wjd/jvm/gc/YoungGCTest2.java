package com.wjd.jvm.gc;

/**
 * @since 2021-07-15
 *
 * 达到年龄15岁的对象，进入老年代
 *
 * Heap：80MB
 * Eden：32MB
 * Survivor：4MB
 * Old：40MB
 */
public class YoungGCTest2 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 存活对象
        byte[] array1 = new byte[128 * SIZE_1K];

        // 触发垃圾回收
        byte[] array2 = new byte[8 * SIZE_1M];
        byte[] array3 = null;
        for (int i = 0; i < 16; i++) {
            array2 = new byte[8 * SIZE_1M];
            array2 = new byte[8 * SIZE_1M];
            array2 = null;

            array3 = new byte[8 * SIZE_1M];
            array2 = array3;
            array3 = null;
        }

        System.out.println(80 * SIZE_1M);
    }

}

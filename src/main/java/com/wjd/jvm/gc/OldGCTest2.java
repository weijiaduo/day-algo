package com.wjd.jvm.gc;

/**
 * @since 2021-07-15
 *
 * 老年代空间担保，剩余可用连续空间小于历次进入老年代的平均空间
 *
 * Heap：40MB
 * Eden：16MB
 * Survivor：2MB
 * Old：20MB
 */
public class OldGCTest2 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 存活对象
        byte[] array1 = new byte[4 * SIZE_1M];
        byte[] array2 = new byte[1 * SIZE_1M];
        for (int i = 0; i < 5; i++) {
            // 垃圾对象
            byte[] array3 = new byte[4 * SIZE_1M];
            byte[] array4 = new byte[4 * SIZE_1M];
            byte[] array5 = new byte[128 * SIZE_1K];
            array3 = null;
            array4 = null;
            array5 = null;

            // 触发YGC
            byte[] array6 = new byte[4 * SIZE_1M];
            array1 = array6;
            array6 = null;
        }
    }

}

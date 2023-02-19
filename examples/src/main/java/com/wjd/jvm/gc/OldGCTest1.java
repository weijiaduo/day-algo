package com.wjd.jvm.gc;

/**
 * @since 2021-07-16
 *
 * 老年代GC，存活对象太大，放不进老年代
 *
 * Heap：40MB
 * Eden：16MB
 * Survivor：2MB
 * Old：20MB
 */
public class OldGCTest1 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 垃圾大对象，直接进入老年代
        byte[] array1 = new byte[10 * SIZE_1M];
        array1 = null;

        // 存活对象
        byte[] array5 = new byte[128 * SIZE_1K];
        byte[] array2 = new byte[4 * SIZE_1M];
        byte[] array3 = new byte[4 * SIZE_1M];
        byte[] array4 = new byte[4 * SIZE_1M];

        // 触发YGC后，同时触发OGC
        byte[] array6 = new byte[4 * SIZE_1M];
    }
}

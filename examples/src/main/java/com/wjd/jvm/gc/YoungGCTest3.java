package com.wjd.jvm.gc;

/**
 * @since 2021-07-15
 *
 * YGC后存活对象大小大于 > Survivor空间大小
 *
 * Heap：40MB
 * Eden：16MB
 * Survivor：2MB
 * Old：20MB
 */
public class YoungGCTest3 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 大存活对象
        byte[] array1 = new byte[4 * SIZE_1M];
        array1 = new byte[4 * SIZE_1M];
        array1 = new byte[4 * SIZE_1M];

        // 小存活对象
        byte[] array2 = new byte[512 * SIZE_1K];

        // 触发垃圾回收
        byte[] array3 = new byte[4 * SIZE_1M];
    }

}

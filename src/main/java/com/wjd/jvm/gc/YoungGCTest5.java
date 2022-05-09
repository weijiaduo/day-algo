package com.wjd.jvm.gc;

/**
 * @since 2021-07-15
 *
 * 大对象直接放入老年代
 *
 * Heap：40MB
 * Eden：16MB
 * Survivor：2MB
 * Old：20MB
 */
public class YoungGCTest5 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 大对象
        byte[] array1 = new byte[12 * SIZE_1M];
    }

}

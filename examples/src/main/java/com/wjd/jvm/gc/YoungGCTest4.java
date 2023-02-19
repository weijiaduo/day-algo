package com.wjd.jvm.gc;

/**
 * @since 2021-07-15
 *
 * YGC后存活对象大小大于 > Survivor空间大小
 *
 * 测试放入的顺序，看谁先进入老年代，是引用顺序，还是对象大小顺序
 *
 * Heap：40MB
 * Eden：16MB
 * Survivor：2MB
 * Old：20MB
 */
public class YoungGCTest4 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 垃圾对象
        byte[] array1 = new byte[4 * SIZE_1M];
        array1 = new byte[4 * SIZE_1M];
        array1 = null;

        // 存活对象
        byte[] array4 = new byte[700 * SIZE_1K];
        byte[] array2 = new byte[1000 * SIZE_1K];
        byte[] array3 = new byte[400 * SIZE_1K];

        // 触发垃圾回收
        byte[] array5 = new byte[4 * SIZE_1M];
    }

}

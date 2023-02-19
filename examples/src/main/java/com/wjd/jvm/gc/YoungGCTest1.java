package com.wjd.jvm.gc;

/**
 * @since 2021-07-14
 *
 * 动态年龄计算测试：年龄1 + 年龄2 + ... + 年龄n > Survivor 50%
 *
 * Heap：40MB
 * Eden：16MB
 * Survivor：2MB
 * Old：20MB
 */
public class YoungGCTest1 {

    private static final int SIZE_1K = 1024;

    private static final int SIZE_1M = 1024 * SIZE_1K;

    public static void main(String[] args) {
        // 垃圾对象
        byte[] array1 = new byte[4 * SIZE_1M];
        array1 = new byte[4 * SIZE_1M];
        array1 = new byte[4 * SIZE_1M];
        array1 = null;

        // 存活对象，第1代存活对象
        byte[] array2 = new byte[128 * SIZE_1K];

        // 触发垃圾回收
        byte[] array3 = new byte[4 * SIZE_1M];
        array3 = new byte[4 * SIZE_1M];
        array3 = new byte[4 * SIZE_1M];
        array3 = null;

        // 存活对象，第2代存活对象
        byte[] array4 = new byte[128 * SIZE_1K];

        // 触发垃圾回收
        byte[] array5 = new byte[4 * SIZE_1M];
        array5 = new byte[4 * SIZE_1M];
        array5 = new byte[4 * SIZE_1M];
        array5 = null;

        // 触发垃圾回收
        byte[] array6 = new byte[4 * SIZE_1M];
    }

}

package com.wjd.jvm.log;

/**
 * @since 2021-07-14
 *
 * Heap：10MB
 * Eden：4MB
 * Survivor：0.5MB
 * Old：5MB
 */
public class GCLogTest1 {

    private static final int SIZE_1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] array1 = new byte[SIZE_1M];
        array1 = new byte[SIZE_1M];
        array1 = new byte[SIZE_1M];
        array1 = null;

        byte[] array2 = new byte[2 * SIZE_1M];
    }

}

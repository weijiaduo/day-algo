package com.wjd.algorithm.sort;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author weijiaduo
 * @since 2022/7/21
 */
public class SortTest {

    int[] arr = {0, 3, 1, 6, 2, 5, 4};
    int[] expect = {0, 1, 2, 3, 4, 5, 6};

    @Test
    void testBubble() {
        int[] actual = Arrays.copyOf(arr, arr.length);
        new BubbleSort().sort(actual);
        assertArrayEquals(expect, actual);
    }

    @Test
    void testSelect() {
        int[] actual = Arrays.copyOf(arr, arr.length);
        new SelectSort().sort(actual);
        assertArrayEquals(expect, actual);
    }

    @Test
    void testInsert() {
        int[] actual = Arrays.copyOf(arr, arr.length);
        new InsertSort().sort(actual);
        assertArrayEquals(expect, actual);
    }

    @Test
    void testQuick() {
        int[] actual = Arrays.copyOf(arr, arr.length);
        new QuickSort().sort(actual);
        assertArrayEquals(expect, actual);
    }

}

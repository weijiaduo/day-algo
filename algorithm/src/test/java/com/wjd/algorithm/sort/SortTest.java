package com.wjd.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

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

    @Test
    void testBubbleTime() {
        long start = System.nanoTime();
        Sort sort = new BubbleSort();
        Random random = new Random(1);
        for (int i = 0; i < 10000; i++) {
            int size = 50 + random.nextInt(200);
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = random.nextInt();
            }
            sort.sort(arr);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    void testInsertTime() {
        long start = System.nanoTime();
        Sort sort = new InsertSort();
        Random random = new Random(1);
        for (int i = 0; i < 10000; i++) {
            int size = 50 + random.nextInt(200);
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = random.nextInt();
            }
            sort.sort(arr);
        }
        System.out.println(System.nanoTime() - start);
    }

}

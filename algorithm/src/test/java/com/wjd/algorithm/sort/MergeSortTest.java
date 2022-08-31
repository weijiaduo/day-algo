package com.wjd.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        Sort sort = new MergeSort();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int size = 50 + random.nextInt(150);
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = random.nextInt(1000);
            }
            int[] actual = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr);
            sort.sort(actual);
            assertArrayEquals(actual, arr);
        }
    }
}
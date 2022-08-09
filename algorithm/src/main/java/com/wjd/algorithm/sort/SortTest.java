package com.wjd.algorithm.sort;

import java.util.Arrays;

/**
 * @author weijiaduo
 * @since 2022/7/21
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 6, 2, 5, 4};

        // int[] arr1 = Arrays.copyOf(arr, arr.length);
        // new QuickSort().sort(arr1);
        // System.out.println(Arrays.toString(arr1));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        new BubbleSort().sort(arr2);
        System.out.println(Arrays.toString(arr2));

        // int[] arr3 = Arrays.copyOf(arr, arr.length);
        // new SelectSort().sort(arr3);
        // System.out.println(Arrays.toString(arr3));
        //
        // int[] arr4 = Arrays.copyOf(arr, arr.length);
        // new InsertSort().sort(arr4);
        // System.out.println(Arrays.toString(arr4));
    }

}

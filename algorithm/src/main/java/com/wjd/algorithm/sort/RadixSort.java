package com.wjd.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author weijiaduo
 * @since 2022/9/6
 */
public class RadixSort implements Sort {

    @Override
    public void sort(int[] arr) {
        // 找到数组最大值
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }

        // 从低位到高位对数组进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    /**
     * 计数排序
     *
     * @param arr 数组
     * @param exp 指数
     */
    private void countSort(int[] arr, int exp) {
        // 统计每个数字（0-9）的次数
        int[] count = new int[10];
        for (int a : arr) {
            count[(a / exp) % 10]++;
        }

        // 累计数字的次数和
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 更新排序结果到原数组
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = copy.length - 1; i >= 0; i--) {
            int index = (copy[i] / exp) % 10;
            count[index]--;
            arr[count[index]] = copy[i];
        }
    }

}

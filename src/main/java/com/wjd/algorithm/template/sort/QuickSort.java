package com.wjd.algorithm.template.sort;

/**
 * 快速排序
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class QuickSort {

    /**
     * 排序
     *
     * @param arr 数组
     */
    public void sort(int[] arr) {
        partSort(arr, 0, arr.length);
    }

    /**
     * 查找排序后的第k个元素（k范围是[0, n-1]）
     *
     * @param arr 数组
     * @param k   索引k
     * @return arr[k]
     */
    public int findKth(int[] arr, int k) {
        int n = arr.length;
        if (k < 0 || k >= n) {
            return -1;
        }
        int start = 0, end = n;
        while (start < end) {
            int m = partition(arr, start, end);
            if (m == k) {
                return arr[m];
            } else if (m > k) {
                end = m;
            } else {
                start = m + 1;
            }
        }
        return -1;
    }

    /**
     * 递归排序
     *
     * @param arr   数组
     * @param start [start, end)
     * @param end   [start, end)
     */
    private void partSort(int[] arr, int start, int end) {
        if (start < end) {
            int m = partition(arr, start, end);
            partSort(arr, start, m);
            partSort(arr, m + 1, end);
        }
    }

    /**
     * 二分数组
     *
     * @param arr   数组
     * @param start [start, end)
     * @param end   [start, end)
     * @return 分隔点索引
     */
    private int partition(int[] arr, int start, int end) {
        int ref = arr[start];
        int lp = start;
        for (int i = lp + 1; i < end; i++) {
            if (arr[i] <= ref) {
                swap(arr, ++lp, i);
            }
        }
        swap(arr, start, lp);
        return lp;
    }

    /**
     * 交换数组元素
     *
     * @param arr 数组
     * @param i   索引
     * @param j   索引
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

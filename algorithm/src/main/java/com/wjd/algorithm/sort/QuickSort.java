package com.wjd.algorithm.sort;

/**
 * 快速排序
 * <p>
 * 时间复杂度：最好 O(nlogn) 最差 O(n^2) 平均 O(nlogn)
 * <p>
 * 空间复杂度：空间 O(logn)
 * <p>
 * 稳定性：不稳定
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class QuickSort implements Sort {

    /**
     * 排序
     *
     * @param arr 数组
     */
    @Override
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
        int p = pivot(arr, start, end - 1);
        swap(arr, start, p);
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
     * 选择分区点（选择三个点的中值位置）
     *
     * @param arr 数组
     * @param i   [i, j]
     * @param j   [i, j]
     * @return 分区点索引
     */
    private int pivot(int[] arr, int i, int j) {
        int mid = i + (j - i) / 2;
        if (arr[i] < arr[j]) {
            return arr[mid] > arr[i] ? mid : j;
        } else {
            return arr[mid] < arr[i] ? mid : i;
        }
    }

}

package com.wjd.algorithm.sort;

/**
 * 归并排序
 *
 * @author weijiaduo
 * @since 2022/9/1
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    /**
     * 排序
     *
     * @param arr   数组
     * @param start [start, end)
     * @param end   [start, end)
     */
    private void sort(int[] arr, int start, int end) {
        if (start + 1 >= end) {
            return;
        }

        // 计算中点
        int mid = start + (end - start) / 2;
        // 对左边进行排序
        sort(arr, start, mid);
        // 对右边进行排序
        sort(arr, mid, end);
        // 合并左右两边的数据
        merge(arr, start, mid, end);
    }

    /**
     * 合并排序数组
     *
     * @param arr   数组
     * @param start [start, end)
     * @param mid   [start, mid) 和 [mid, end)
     * @param end   [start, end)
     */
    private void merge(int[] arr, int start, int mid, int end) {
        int n = end - start;
        int[] tempArr = new int[n];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            // 优先排左边的，保证稳定性
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }
        while (i < mid) {
            tempArr[k++] = arr[i++];
        }
        while (j < end) {
            tempArr[k++] = arr[j++];
        }
        // 注意复制到原数组时，起点是 start
        System.arraycopy(tempArr, 0, arr, start, n);
    }

}

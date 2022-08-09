package com.wjd.algorithm.sort;

/**
 * 选择排序
 * <p>
 * 时间复杂度：最好 O(n^2) 最差 O(n^2) 平均 O(n^2)
 * <p>
 * 空间复杂度：空间 O(1)
 * <p>
 * 稳定性：不稳定
 *
 * @author weijiaduo
 * @since 2022/7/21
 */
public class SelectSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

}

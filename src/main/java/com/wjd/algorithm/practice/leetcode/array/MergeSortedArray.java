package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-05-29
 *
 * 88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class MergeSortedArray implements Solution<Void> {

    @Override
    public Void solve(Object ...args) {
        int[] nums1 = {0};
        int[] nums2 = {2};
        ArrayUtil.print(nums1);
        merge(nums1, 0, nums2, 1);
        ArrayUtil.print(nums1);
        return null;
    }

    /**
     * 合并数组2到数组1
     *
     * @param nums1 数组1
     * @param m     元素数量
     * @param nums2 数组2
     * @param n     元素数量
     */
    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n;
        while (--k >= 0) {
            if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }
}

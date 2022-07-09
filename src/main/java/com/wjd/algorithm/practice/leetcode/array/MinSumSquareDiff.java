package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 双周赛 82
 * <p>
 * 6118. 最小差值平方和
 * <p>
 * 给你两个下标从 0开始的整数数组nums1 和nums2，长度为n。
 * <p>
 * 数组nums1 和nums2的 差值平方和定义为所有满足0 <= i < n的(nums1[i] - nums2[i])2之和。
 * <p>
 * 同时给你两个正整数k1 和k2。你可以将nums1中的任意元素+1 或者-1至多k1次。类似的，你可以将nums2中的任意元素+1 或者-1至多k2次。
 * <p>
 * 请你返回修改数组nums1至多k1次且修改数组nums2至多 k2次后的最小差值平方和。
 * <p>
 * 注意：你可以将数组中的元素变成负整数。
 * <p>
 * 输入：nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
 * 输出：579
 * 解释：nums1 和 nums2 中的元素不能修改，因为 k1 = 0 和 k2 = 0 。
 * 差值平方和为：(1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)2= 579 。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class MinSumSquareDiff implements Solution<Long> {

    @Override
    public Long solve(Object... args) {
        int[] nums1 = {18, 4, 8, 19, 13, 8};
        int[] nums2 = {18, 11, 8, 2, 13, 15};
        int k1 = 16;
        int k2 = 8;
        long result = minSumSquareDiff(nums1, nums2, k1, k2);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：求最小差值平方和，每次减少最大的绝对值，就能最小化差值平方和
     * <p>
     * 执行用时: 11 ms
     * 内存消耗: 57.3 MB
     */
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans = 0;
        int n = nums1.length;

        // 计算每个元素的绝对值差
        int[] abs = new int[n];
        for (int i = 0; i < n; i++) {
            abs[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(abs);

        // 优先减去绝对值大的
        int k = k1 + k2, lastIndex = n - 1;
        while (k > 0 && abs[lastIndex] > 0) {
            // 找到最大值的第一个索引位置
            int index = lastIndex;
            while (index > 0 && abs[index] <= abs[index - 1]) {
                index--;
            }

            // 最大值的数量
            int num = n - index;
            if (num <= k) {
                // k 依旧大于最大值的数量
                lastIndex = index;
                int prev = index == 0 ? 0 : abs[index - 1];
                // 每个最大值平均减去的数值
                int div = Math.min(abs[index] - prev, k / num);
                // 只更新第一个最大值即可，避免时间消耗
                abs[lastIndex] -= div;
                k -= num * div;
            } else {
                // k 小于最大值的数量
                lastIndex = index + k;
                // 最大值索引往后移动，之前可能没更新，需要把最新的最大值同步过去
                abs[lastIndex] = abs[index];
                for (int i = index; i < index + k; i++) {
                    abs[i] = abs[lastIndex] - 1;
                }
                k = 0;
            }
        }
        // 统计差值平方和
        for (int i = 0; i < n; i++) {
            if (i >= lastIndex) {
                // 后面全是一样的最大值
                ans += (long) abs[lastIndex] * abs[lastIndex] * (n - i);
                break;
            } else {
                ans += (long) abs[i] * abs[i];
            }
        }
        return ans;
    }

}

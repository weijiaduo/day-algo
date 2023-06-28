package com.wjd.practice.leetcode.array.statistics;

/**
 * 643. 子数组最大平均数 I
 * <p>
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * @since 2021-06-04
 */
public class MaxAverage {

    /**
     * 最大平均数
     *
     * @param nums 数组
     * @param k    数量
     * @return 最大平均数
     */
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        for (int i = k, sum = maxSum; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum * 1.0 / k;
    }
}

package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-05-29
 *
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("Max sub Array = " + result);
        return result;
    }

    /**
     * 最大子序和
     * @param nums 数组
     * @return 最大和
     */
    private int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && sums[i - 1] >= 0) {
                sums[i] = sums[i - 1] + nums[i];
            } else {
                sums[i] = nums[i];
            }
            if (sums[i] > maxSum) {
                maxSum = sums[i];
            }
        }
        return maxSum;
    }
}

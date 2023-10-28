package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.TestCase;

/**
 * 643. 子数组最大平均数 I
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 *
 * @since 2021-06-04
 */
public class MaxAverage {

    /**
     * 思路：滑动窗口，维持一个k位数和的窗口
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,12,-5,-6,50,3]", "4", "[5]", "1"},
            output = {"12.75", "5.00000"})
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int n = nums.length, sum = maxSum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum * 1.0 / k;
    }

}

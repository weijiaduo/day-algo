package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-06-04
 * <p>
 * 665. 非递减数列
 * <p>
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class CheckPossibility implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        int[] nums = {3, 4, 5, 3};
        boolean result = checkPossibility(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 检查数组能否变成一个非递减数列
     *
     * @param nums 数组
     * @return true/false
     */
    private boolean checkPossibility(int[] nums) {
        int fixCount = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; fixCount <= 1 && i < nums.length; i++) {
            int next = i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE;
            // 中值比前值小，肯定要修正
            if (nums[i] < prev) {
                // 修正为 nums[i] = prev
                fixCount++;
                continue;
            }

            // 中值在前后值之间，不用修正
            if (nums[i] <= next) {
                prev = nums[i];
                continue;
            }

            // 中值最大，前值后值都比中值小
            if (prev <= next) {
                // 前值比后值小，修正中值
                // 修正为 prev <= nums[i] <= next
                fixCount++;
            } else {
                // 前值比后值大，修正后值
                prev = nums[i];
            }
        }
        return fixCount <= 1;
    }
}

package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * @since 2021-06-23
 *
 * 896. 单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 */
public class Monotonic implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        int[] nums = {1, 1, 1};
        boolean result = isMonotonic(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 是否是单调数列
     * @param nums 数组
     * @return true/false
     */
    private boolean isMonotonic(int[] nums) {
        boolean flag = nums[0] <= nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (flag) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

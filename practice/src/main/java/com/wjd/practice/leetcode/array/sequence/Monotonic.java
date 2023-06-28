package com.wjd.practice.leetcode.array.sequence;

/**
 * 896. 单调数列
 * <p>
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * <p>
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 *
 * @since 2021-06-23
 */
public class Monotonic {

    /**
     * 是否是单调数列
     *
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

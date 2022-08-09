package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * @since 2021-06-08
 * <p>
 * 747. 至少是其他数字两倍的最大数
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 */
public class DominantIndex implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {3, 0, 0, 0, 1};
        int result = dominantIndex(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 最大元素的下标
     *
     * @param nums 数组
     * @return 最大元素的下标
     */
    private int dominantIndex(int[] nums) {
        int index = -1;
        int max1 = Integer.MIN_VALUE, max2 = max1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max2 <= max1 / 2 ? index : -1;
    }
}

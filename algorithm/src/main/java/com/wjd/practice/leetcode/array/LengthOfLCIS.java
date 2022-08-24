package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * @since 2021-06-05
 * <p>
 * 674. 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class LengthOfLCIS implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {2, 2, 3, 2, 2};
        int result = findLengthOfLCIS(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 最长连续递增序列的长度
     *
     * @param nums 数组
     * @return 递增序列的长度
     */
    private int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        for (int i = 1, len = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
            } else {
                len = 1;
            }
        }
        return maxLen;
    }
}

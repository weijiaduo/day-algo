package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * @since 2021-05-31
 *
 * 485. 最大连续 1 的个数
 *
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 */
public class MaxConsecutiveOnes implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {1,0,1,1,0,1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 最大连续 1 的个数
     * @param nums 数组
     * @return 数量
     */
    private int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}

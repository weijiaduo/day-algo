package com.wjd.practice.leetcode.array.statistics;

/**
 * 485. 最大连续 1 的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * @since 2021-05-31
 */
public class MaxConsecutiveOnes {

    /**
     * 最大连续 1 的个数
     *
     * @param nums 数组
     * @return 数量
     */
    public int findMaxConsecutiveOnes(int[] nums) {
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

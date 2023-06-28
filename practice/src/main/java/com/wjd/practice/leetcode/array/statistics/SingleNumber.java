package com.wjd.practice.leetcode.array.statistics;

/**
 * 136. 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * <p>
 * 找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @since 2021-06-28
 */
public class SingleNumber {

    /**
     * 只出现一次的数字
     *
     * @param nums 数组
     * @return 数字
     */
    public int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

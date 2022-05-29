package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-06-28
 *
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 */
public class SingleNumber implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {2,2,1};
        int result = findSingleNumber(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 只出现一次的数字
     * @param nums 数组
     * @return 数字
     */
    private int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

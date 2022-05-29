package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.HashSet;

/**
 * @since 2021-05-29
 *
 * 217. 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsDuplicate implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        int[] nums = {22, 1, 22};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 存在重复元素
     *
     * @param nums 数组
     * @return true/false
     */
    private boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}

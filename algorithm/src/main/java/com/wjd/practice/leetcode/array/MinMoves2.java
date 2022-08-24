package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * <p>
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>
 * @since 2022/5/19
 */
public class MinMoves2 implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {1, 2, 3};
        int result = minMoves2(nums);
        System.out.println(result);
        return result;
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        // 取中位数，中位数和其他的差值总和最小
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }
}

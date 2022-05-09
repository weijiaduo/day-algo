package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * @since 2021-05-31
 * <p>
 * 561. 数组拆分 I
 * <p>
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 */
public class ArrayPairSum implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        int result = arrayPairSum(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 数对最小值的最大和
     *
     * @param nums 数组
     * @return 最大和
     */
    private int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

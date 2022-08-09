package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * @since 2021-06-03
 * <p>
 * 628. 三个数的最大乘积
 * <p>
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
public class MaximumProduct implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {-1, -2, -3, 4};
        int result = maximumProduct(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 三个数的最大乘积
     *
     * @param nums 数组
     * @return 最大乘积
     */
    private int maximumProduct2(int[] nums) {
        int result;
        Arrays.sort(nums);
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0) {
            // 3非负，或3非正
            result = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        } else {
            // 3非负，或1非负2非正
            int r1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            // 1非负2非正
            int r2 = nums[0] * nums[1] * nums[nums.length - 1];
            result = Math.max(r1, r2);
        }
        return result;
    }

    /**
     * 三个数的最大乘积
     *
     * @param nums 数组
     * @return 最大乘积
     */
    private int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 最大值
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            // 最小值
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}

package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * @since 2021-05-29
 * <p>
 * 414. 第三大的数
 * <p>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */
public class ThirdMax implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {2, 2, 3, 4};
        int result = getThirdMax(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 获取第3大的数
     *
     * @param nums 数组
     * @return 第3大的数
     */
    private int getThirdMax(int[] nums) {
        int[] maxes = new int[3];
        Arrays.fill(maxes, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, t = i; j < maxes.length; j++) {
                if (maxes[j] < 0) {
                    maxes[j] = t;
                    break;
                }
                if (nums[t] == nums[maxes[j]]) {
                    break;
                }
                if (nums[t] > nums[maxes[j]]) {
                    int temp = t;
                    t = maxes[j];
                    maxes[j] = temp;
                }
            }
        }
        return maxes[maxes.length - 1] >= 0 ? nums[maxes[maxes.length - 1]] : nums[maxes[0]];
    }
}

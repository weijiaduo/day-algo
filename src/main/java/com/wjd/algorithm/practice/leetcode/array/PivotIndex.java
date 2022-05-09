package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-06-06
 * <p>
 * 724. 寻找数组的中心下标
 * <p>
 * 给你一个整数数组nums，请编写一个能够返回数组 “中心下标” 的方法。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心下标可能出现在数组的两端。
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class PivotIndex implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int[] nums = {2, 1, -1};
        int result = pivotIndex(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 寻找数组的中心下标
     *
     * @param nums 数组
     * @return 中心下标索引
     */
    private int pivotIndex(int[] nums) {
        int result = -1;
        int leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int p = 0;
        while (p < nums.length) {
            if (p > 0) {
                leftSum += nums[p - 1];
            }
            rightSum -= nums[p];
            if (leftSum == rightSum) {
                result = p;
                break;
            }
            p++;
        }
        return result;
    }
}

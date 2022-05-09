package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * @since 2021-07-01
 *
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
 * 假定每组输入只存在唯一答案。
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 */
public class ThreeSumClosest implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int result = threeSumClosest(nums, target);
        System.out.println(result);
        return result;
    }

    /**
     * 最近的3数之和
     * @param nums 数组
     * @param target 目标值
     * @return 3数之和
     */
    private int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = twoSumClosest(nums, target - nums[i], i + 1, nums.length - 1);
            sum += nums[i];
            if (sum == target) {
                return sum;
            }
            if (i == 0 || Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
            }
        }
        return closestSum;
    }

    /**
     * 最近的2数之和
     * @param nums 排序数组
     * @param target 目标值
     * @param start 起始索引
     * @param end 终止索引
     * @return 2数之和
     */
    private int twoSumClosest(int[] nums, int target, int start, int end) {
        int lp = start, rp = end;
        int sum = nums[lp] + nums[rp];
        while (lp < rp) {
            int temp = nums[lp] + nums[rp];
            if (temp == target) {
                return target;
            }
            if (Math.abs(temp - target) < Math.abs(sum - target)) {
                sum = temp;
            }
            if (temp < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return sum;
    }

}

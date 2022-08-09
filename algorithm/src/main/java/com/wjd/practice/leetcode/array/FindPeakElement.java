package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 162. 寻找峰值
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class FindPeakElement implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int result = findPeakElement(nums);
        System.out.println(result);
        return result;
    }

    private int findPeakElement(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    /**
     * 思路：二分法，寻找峰值
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了62.45% 的Java用户
     */
    private int dfs(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        // 判断是否是峰值
        boolean gl = (mid == 0 || nums[mid] > nums[mid - 1]);
        boolean gr = (mid == nums.length - 1 || nums[mid] > nums[mid + 1]);
        if (gl && gr) {
            return mid;
        }
        if (gr) {
            // 在左边寻找峰值
            return dfs(nums, left, mid - 1);
        } else {
            // 在右边寻找峰值
            return dfs(nums, mid + 1, right);
        }
    }

}

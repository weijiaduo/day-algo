package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-07-09
 *
 * 33.搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class RotateSearch implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {3,1};
        int target = 1;
        int result = search(nums, target);
        System.out.println(result);
        return result;
    }

    /**
     * 搜索旋转排序数组
     * @param nums 数组
     * @param target 目标值
     * @return 目标值的索引
     */
    private int search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    /**
     * 二分查找
     * @param nums 数组
     * @param target 目标值
     * @param start 起始索引
     * @param end 结束索引
     * @return 目标值索引
     */
    private int find(int[] nums, int target, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mp = start + ((end - start) >> 1);
        if (nums[mp] == target) {
            return mp;
        }
        if (nums[mp] >= nums[start]) {
            // 中值在左边的升序序列中
            if (nums[start] <= target && target < nums[mp]) {
                // 左边
                return find(nums, target, start, mp - 1);
            } else {
                // 右边
                return find(nums, target, mp + 1, end);
            }
        } else {
            // 中值在右边的升序序列中
            if (nums[mp] < target && target <= nums[end]) {
                // 右边
                return find(nums, target, mp + 1, end);
            } else {
                // 左边
                return find(nums, target, start, mp - 1);
            }
        }
    }

}

package com.wjd.practice.leetcode.array.binary;

/**
 * 33.搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * <p>
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * <p>
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * @since 2021-07-09
 */
public class RotateSearch {

    /**
     * 搜索旋转排序数组
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值的索引
     */
    public int search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param target 目标值
     * @param start  起始索引
     * @param end    结束索引
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

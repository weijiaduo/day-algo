package com.wjd.practice.leetcode.array.binary;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * <p>
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 *
 * @since 2021-07-13
 */
public class SearchRange {

    /**
     * 思路：二分查找，找到第一个大于等于，最后一个小于等于 target 的位置
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.6 MB,击败了65.62% 的Java用户
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = firstNotLessThan(nums, 0, n - 1, target);
        if (l == -1 || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int r = lastNotGreatThan(nums, l, n - 1, target);
        return new int[]{l, r};
    }

    /**
     * 第一个大于等于 target 的位置
     */
    private int firstNotLessThan(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                if (m == l || nums[m - 1] < target) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    /**
     * 最后一个小于等于 target 的位置
     */
    private int lastNotGreatThan(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= target) {
                if (m == r || nums[m + 1] > target) {
                    return m;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}

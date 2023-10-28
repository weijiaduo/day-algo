package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

/**
 * 162. 寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class FindPeakElement {

    /**
     * 思路：递归二分法，总是往更高的方向走
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了62.45% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "[1,2,1,3,5,6,4]"},
            output = {"2", "5"})
    public int binary(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    /**
     * 二分法
     */
    private int binarySearch(int[] nums, int left, int right) {
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
        if (!gl) {
            // 比左边小，在左边寻找峰值
            return binarySearch(nums, left, mid - 1);
        } else {
            // 比右边小，在右边寻找峰值
            return binarySearch(nums, mid + 1, right);
        }
    }

    /**
     * 思路：循环二分法，总是往更高的方向走
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了63.42% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "[1,2,1,3,5,6,4]"},
            output = {"2", "5"})
    public int binary2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}

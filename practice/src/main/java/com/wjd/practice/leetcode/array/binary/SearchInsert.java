package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.leetcode.TestCase;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 为 无重复元素 的 升序 排列数组
 * -10⁴ <= target <= 10⁴
 *
 * @since 2021-05-29
 */
public class SearchInsert {

    /**
     * 思路：二分查找，寻找第一个大于等于 target 的值
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.5 MB,击败了5.14% 的Java用户
     */
    @TestCase(input = {"[1,3,5,6]", "5", "[1,3,5,6]", "2", "[1,3,5,6]", "7"},
            output = {"2", "1", "4"})
    public int binary(int[] nums, int target) {
        int lp = 0, rp = nums.length - 1;
        while (lp <= rp) {
            int mp = lp + (rp - lp) / 2;
            if (nums[mp] >= target) {
                if (mp == 0 || nums[mp - 1] < target) {
                    return mp;
                }
                rp = mp - 1;
            } else {
                lp = mp + 1;
            }
        }
        return nums.length;
    }

}

package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

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
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -10⁴ <= nums[i] <= 10⁴
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10⁴ <= target <= 10⁴
 *
 * @since 2021-07-09
 */
public class RotateSearch {

    /**
     * 思路：二分法，将数组分半后，左边和右边肯定有一边是有序的
     * <p>
     * 如果 nums[left] <= nums[mid]，那么左边肯定是有序的
     * <p>
     * 如果 nums[mid] <= nums[right]，那么右边肯定是有序的
     * <p>
     * 然后再判断 target 在哪一边，继续下一次二分查找，直到找到 target 为止
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了82.17% 的Java用户
     */
    @TestCase(input = {"[4,5,6,7,0,1,2]", "0", "[4,5,6,7,0,1,2]", "3", "[1]", "0"},
            output = {"4", "-1", "-1"})
    public int binary(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
                // 左边是有序的
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // 右边是有序的
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

}

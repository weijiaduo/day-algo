package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.TestCase;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * <p>
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 10⁹
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁵
 *
 * @author weijiaduo
 * @since 2022/7/15
 */
public class MinSubArrayLen {

    /**
     * 思路：滑动窗口统计和
     * <p>
     * 复杂度：时间 O(n) 空间O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.97% 的Java用户
     * 内存消耗:48.7 MB,击败了12.24% 的Java用户
     */
    @TestCase(input = {"7", "[2,3,1,2,4,3]",
            "4", "[1,4,4]",
            "11", "[1,1,1,1,1,1,1,1]"},
            output = {"2", "1", "0"})
    public int slide(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int lp = 0, rp = 0, sum = 0;
        while (rp < n) {
            // 右边扩张滑动窗口
            sum += nums[rp++];
            // 左边收缩滑动窗口
            while (sum >= target) {
                ans = Math.min(ans, rp - lp);
                sum -= nums[lp++];
            }
        }
        return ans > n ? 0 : ans;
    }

}

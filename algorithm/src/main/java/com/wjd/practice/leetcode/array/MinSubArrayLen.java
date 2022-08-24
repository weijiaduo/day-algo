package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * <p>
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * @author weijiaduo
 * @since 2022/7/15
 */
public class MinSubArrayLen implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1};
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：滑动窗口统计和
     * <p>
     * 复杂度：时间 O(n) 空间O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.97% 的Java用户
     * 内存消耗:48.7 MB,击败了12.24% 的Java用户
     */
    private int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        // [lp, rp)半开区间表示滑动窗口
        int lp = 0, rp = 0, sum = 0;
        while (lp < n) {
            // 右边扩张滑动窗口
            while (rp < n && sum < target) {
                sum += nums[rp++];
            }
            // 剩余和已经不满足了
            if (sum < target) {
                break;
            }
            // 左边收缩滑动窗口
            while (lp < rp && sum - nums[lp] >= target) {
                sum -= nums[lp++];
            }
            ans = Math.min(ans, rp - lp);
            // 左移下一个滑动窗口
            sum -= nums[lp++];
        }
        return ans > n ? 0 : ans;
    }

}

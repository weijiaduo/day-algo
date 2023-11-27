package com.wjd.practice.book.sword.dynamic;

import com.wjd.practice.TestCase;

/**
 * 42. 连续子数组的最大和
 * <p>
 * 给一个数组，返回它的最大连续子序列的和
 * <p>
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class GreatestSumOfSubArrays {

    /**
     * 思路：动态规划
     * <p>
     * sum[i]表示以第i个元素结尾的子数组的最大和
     * <p>
     * 状态转移方程：sum[i] = max(sum[i-1]+nums[i], nums[i])
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[6,-3,-2,7,-15,1,2,2]"}, output = "8")
    public int dynamic1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 状态定义
        // dp[i] 表示以第i个元素结尾的子数组的最大和
        int n = nums.length;
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = nums[0];

        // 状态转移
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * 由于只依赖于前一个值，所以可以将一维数组压缩成一个变量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[6,-3,-2,7,-15,1,2,2]"}, output = "8")
    public int dynamic0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // 状态定义以及初始化
        int pre = nums[0];
        // 状态转移
        int ans = pre;
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }

}

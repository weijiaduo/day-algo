package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.leetcode.TestCase;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * <p>
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * <p>
 * 提示：
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 * @since 2021-06-06
 */
public class MinCostClimbingStairs {

    /**
     * 思路：动态规划，抵达楼顶 n 有 2 种方式，一种跳 1 阶，一种跳 2 阶
     * <p>
     * dp[n] = min(dp[n-1] + cost[n-1], dp[n-2] + cost[n-2])
     * <p>
     * 这个一维数组空间可以优化掉，采用滚动数组，仅保留前 2 个值即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[10,15,20]", "[1,100,1,1,1,100,1,1,100,1]"},
            output = {"15", "6"})
    public int dynamic(int[] cost) {
        int minCost = 0, m1 = 0, m2 = 0;
        int n = cost.length;
        for (int i = 2; i <= n; i++) {
            minCost = Math.min(m1 + cost[i - 1], m2 + cost[i - 2]);
            m2 = m1;
            m1 = minCost;
        }
        return minCost;
    }

}
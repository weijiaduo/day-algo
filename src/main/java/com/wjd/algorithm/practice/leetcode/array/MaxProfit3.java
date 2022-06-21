package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 123. 买卖股票的最佳时机3
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * <p>
 * @author weijiaduo
 * @since 2022/6/21
 */
public class MaxProfit3 implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] prices = {7,6,4,3,1};
        int result = maxProfit2(prices);
        System.out.println(result);
        return result;
    }

    private int maxProfit(int[] prices) {
        int maxVal = 0;
        int n = prices.length;
        int[][][] dp = dynamic(prices);
        for (int i = 1; i < n; i++) {
            maxVal = Math.max(dp[0][i - 1][1] + dp[i][n - 1][1], maxVal);
        }
        maxVal = Math.max(dp[0][n - 1][1], maxVal);
        return maxVal;
    }

    /**
     * 哈哈哈，内存溢出
     *
     * Memory Limit Exceeded
     */
    private int[][][] dynamic(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            // [0] 记录[i, j]区间内最小值
            dp[i][i][0] = prices[i];
            // [1] 记录[i, j]区间内的最大利润
            dp[i][i][1] = 0;
        }
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                dp[i][i + d][0] = Math.min(prices[i + d], dp[i][i + d - 1][0]);
                dp[i][i + d][1] = Math.max(prices[i + d] - dp[i][i + d - 1][0], dp[i][i + d - 1][1]);
            }
        }
        return dp;
    }

    private int maxProfit2(int[] prices) {
        int maxVal = 0;
        int n = prices.length;
        int[][] dp = dynamic2(prices);
        for (int i = 1; i < n; i++) {
            maxVal = Math.max(dp[0][i - 1] + dp[1][i], maxVal);
        }
        maxVal = Math.max(dp[0][n - 1], maxVal);
        return maxVal;
    }

    /**
     * 思路：去掉三维数组无用的数据，最终保留下来2个数组
     *
     * 执行耗时:3 ms,击败了68.78% 的Java用户
     * 内存消耗:50.3 MB,击败了97.54% 的Java用户
     */
    private int[][] dynamic2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];

        // 从左往右，计算[0, j]的最大值
        int maxVal = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (prices[j] < prices[i]) {
                i = j;
            } else if (prices[j] - prices[i] > maxVal) {
                maxVal = prices[j] - prices[i];
            }
            dp[0][j] = maxVal;
        }

        // 从右往左，计算[i, n - 1]的最大值
        maxVal = 0;
        for (int i = n - 1, j = n - 1; i >= 0; i--) {
            if (prices[i] > prices[j]) {
                j = i;
            } else if (prices[j] - prices[i] > maxVal) {
                maxVal = prices[j] - prices[i];
            }
            dp[1][i] = maxVal;
        }

        return dp;
    }

    /**
     * 官解过于牛皮~~~
     *
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:57.8 MB,击败了25.63% 的Java用户
     */
    public int dynamic3(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}

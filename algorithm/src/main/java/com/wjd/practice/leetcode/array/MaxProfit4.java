package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机4
 * <p>
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * @author weijiaduo
 * @since 2022/7/10
 */
public class MaxProfit4 implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        int result = maxProfit2(k, prices);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：动态规划，动态计算在 i 天内买入和卖出 j 次股票的最大利润，买入和卖出要分开计算
     * <p>
     * 复杂度：时间 O(nk) 空间 O(nk)
     * <p>
     * 执行耗时:1 ms,击败了99.37% 的Java用户
     * 内存消耗:41.2 MB,击败了39.19% 的Java用户
     */
    private int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // buy[i][j] 表示在 i 天内买入 j 次股票的最大利润
        int[][] buy = new int[n][k];
        // sell[i][j] 表示在 i 天内卖出 j 次股票的最大利润
        int[][] sell = new int[n][k];

        // 第一天买入的股票，只能是第一张股票
        Arrays.fill(buy[0], -prices[0]);
        // 第一天卖出只能是0，因为还没买入
        Arrays.fill(sell[0], 0);

        for (int i = 1; i < n; i++) {
            // 前些天 [i - 1] 买入/卖出，或者当天 [i] 买入/卖出
            buy[i][0] = Math.max(buy[i - 1][0], -prices[i]);
            sell[i][0] = Math.max(sell[i - 1][0], buy[i - 1][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                // 下一次买入 buy[j] 必须在上一次卖出 sell[j - 1] 之后
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                // 卖出 sell[j] 必须在买入 buy[j] 之后
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
            }
        }
        return sell[n - 1][k - 1];
    }

    /**
     * 思路：压缩动态规划的二维数组，变成一维数组
     * <p>
     * 复杂度：时间 O(nk) 空间 O(k)
     * <p>
     * 执行耗时:1 ms,击败了99.37% 的Java用户
     * 内存消耗:39.1 MB,击败了92.36% 的Java用户
     */
    private int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        int[] buy = new int[k];
        int[] sell = new int[k];

        // 第一天买入的股票，只能是第一张股票
        Arrays.fill(buy, -prices[0]);
        // 第一天卖出只能是0，因为还没买入
        Arrays.fill(sell, 0);

        for (int i = 1; i < n; i++) {
            // 下一次买入 buy[j] 必须在上一次卖出之后 sell[j - 1]
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            // 卖出 sell[j] 之前必须先买入 buy[j]
            buy[0] = Math.max(buy[0], -prices[i]);
            for (int j = 1; j < k; j++) {
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
        }

        return sell[k - 1];
    }

}

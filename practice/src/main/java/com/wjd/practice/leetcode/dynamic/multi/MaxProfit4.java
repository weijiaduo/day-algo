package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * @author weijiaduo
 * @since 2022/7/10
 */
public class MaxProfit4 {

    /**
     * 思路：动态规划，动态计算在 i 天内买入和卖出 j 次股票的最大利润，买入和卖出要分开计算
     * <p>
     * 复杂度：时间 O(nk) 空间 O(nk)
     * <p>
     * 执行耗时:1 ms,击败了99.37% 的Java用户
     * 内存消耗:41.2 MB,击败了39.19% 的Java用户
     */
    @TestCase(input = {"2", "[2,4,1]", "2", "[3,2,6,5,0,3]"},
            output = {"2", "7"})
    public int dynamic2(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 状态定义
        // buy[i][j] 表示在 i 天内买入最多 j 次股票的最大利润
        int[][] buy = new int[n][k];
        // sell[i][j] 表示在 i 天内卖出最多 j 次股票的最大利润
        int[][] sell = new int[n][k];

        // 状态初始化
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
    @TestCase(input = {"2", "[2,4,1]", "2", "[3,2,6,5,0,3]"},
            output = {"2", "7"})
    public int dynamic1(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        // 状态定义
        int[] buy = new int[k];
        int[] sell = new int[k];

        // 状态初始化
        // 第一天买入的股票，只能是第一张股票
        Arrays.fill(buy, -prices[0]);
        // 第一天卖出只能是0，因为还没买入
        Arrays.fill(sell, 0);

        // 状态转移
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

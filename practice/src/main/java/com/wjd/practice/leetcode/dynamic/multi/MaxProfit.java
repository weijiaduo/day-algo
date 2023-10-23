package com.wjd.practice.leetcode.dynamic.multi;

import java.util.Arrays;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。
 *
 * @author weijiaduo
 * @since 2023/10/22
 */
public abstract class MaxProfit {

    /**
     * 动态规划，常规数组空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(nk)
     *
     * @param prices 价格
     * @param k      最多交易次数，k < 0 表示无限制次数
     * @param fee    交易费用
     * @return 最大利润
     */
    protected int dynamic1K(int[] prices, int k, int fee) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        // k < 0 表示无限制次数
        int m = k < 0 ? 1 : k + 1;

        // 状态定义
        // sell[i][j] 表示第 i 天内卖出最多 j 次股票的最大利润
        int[][] sell = new int[n][m];
        // buy[i][j] 表示第 i 天内买入最多 j 次股票的最大利润
        int[][] buy = new int[n][m];

        // 状态初始化
        // 第 0 天内不允许卖出，最大利润都是 0
        // Arrays.fill(sell[0], 0);
        // 第 0 天内只允许买入第 0 个股票，最大利润都是 -prices[0]
        Arrays.fill(buy[0], -prices[0]);

        // 状态转移
        for (int i = 1; i < n; i++) {
            // 这里取余是为了处理 k < 0 的情况，如果 k > 0 则不需要取余，可提升性能
            for (int j = 1 % m; j < m; j++) {
                // 当天卖出/不买不卖，记得加上服务费
                sell[i][j % m] = Math.max(buy[i - 1][j % m] + prices[i] - fee, sell[i - 1][j % m]);
                // 当天买入/不买不卖
                buy[i][j % m] = Math.max(sell[i - 1][(j - 1) % m] - prices[i], buy[i - 1][j % m]);
            }
        }
        return sell[n - 1][m - 1];
    }

    /**
     * 动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(k)
     *
     * @param prices 价格
     * @param k      最多交易次数，k < 0 表示无限制次数
     * @param fee    交易费用
     * @return 最大利润
     */
    protected int dynamic0K(int[] prices, int k, int fee) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        // k < 0 表示无限制次数
        int m = k < 0 ? 1 : k + 1;

        // 状态定义
        // sell[j] 表示卖出最多 j 次股票的最大利润
        int[] sell = new int[m];
        // buy[j] 表示买入最多 j 次股票的最大利润
        int[] buy = new int[m];

        // 状态初始化
        // 第 0 天内不允许卖出，最大利润是 0
        // Arrays.fill(sell, 0);
        // 第 0 天内只允许买入第 0 个股票，最大利润是 -prices[0]
        Arrays.fill(buy, -prices[0]);

        // 状态转移
        for (int i = 1; i < n; i++) {
            // 这里取余是为了处理 k < 0 的情况，如果 k > 0 则不需要取余，可提升性能
            for (int j = 1 % m; j < m; j++) {
                // 当天卖出/不买不卖，记得加上服务费
                sell[j % m] = Math.max(buy[j % m] + prices[i] - fee, sell[j % m]);
                // 当天买入/不买不卖
                buy[j % m] = Math.max(sell[(j - 1) % m] - prices[i], buy[j % m]);
            }
        }

        return sell[m - 1];
    }

}

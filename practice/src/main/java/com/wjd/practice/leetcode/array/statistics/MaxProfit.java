package com.wjd.practice.leetcode.array.statistics;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @since 2021-05-29
 */
public class MaxProfit {

    /**
     * 最大收益
     *
     * @param prices 价格数组
     * @return 最大收益
     */
    private int maxProfit(int[] prices) {
        int maxDiffVal = 0;
        int lp = 0;
        for (int rp = lp; rp < prices.length; rp++) {
            if (prices[rp] < prices[lp]) {
                // 找到更小值，那后面的最大差值就和之前的最小值没关系了
                // 后面就用最新的最小值来计算差值
                lp = rp;
            } else if (prices[rp] - prices[lp] > maxDiffVal) {
                // 找到更大值，更新最新的差值
                maxDiffVal = prices[rp] - prices[lp];
            }
        }
        return maxDiffVal;
    }

}

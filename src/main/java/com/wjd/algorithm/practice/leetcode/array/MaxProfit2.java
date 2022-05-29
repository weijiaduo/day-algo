package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-05-29
 *
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit2 implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] prices = {7,6,4,3,1};
        int result = maxProfit(prices);
        System.out.println(result);
        return result;
    }

    /**
     * 最大收益
     *
     * @param prices 价格数组
     * @return 最大收益
     */
    private int maxProfit(int[] prices) {
        int sumVal = 0;
        for (int rp = 1; rp < prices.length; rp++) {
            if (prices[rp] > prices[rp - 1]) {
                // 谷值到峰值之间上升值
                sumVal += prices[rp] - prices[rp - 1];
            }
        }
        return sumVal;
    }

}

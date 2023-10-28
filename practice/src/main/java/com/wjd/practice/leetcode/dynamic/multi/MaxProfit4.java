package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

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
public class MaxProfit4 extends MaxProfit {

    /**
     * 思路：动态规划，动态计算在 i 天内买入和卖出 j 次股票的最大利润，买入和卖出要分开计算
     * <p>
     * 复杂度：时间 O(nk) 空间 O(nk)
     * <p>
     * 执行耗时:2 ms,击败了68.17% 的Java用户
     * 内存消耗:41.7 MB,击败了67.79% 的Java用户
     */
    @TestCase(input = {"2", "[2,4,1]", "2", "[3,2,6,5,0,3]"},
            output = {"2", "7"})
    public int commonDynamic1(int k, int[] prices) {
        return dynamic1K(prices, k, 0);
    }

    /**
     * 思路：压缩动态规划的二维数组，变成一维数组
     * <p>
     * 复杂度：时间 O(nk) 空间 O(k)
     * <p>
     * 执行耗时:1 ms,击败了98.88% 的Java用户
     * 内存消耗:39 MB,击败了97.77% 的Java用户
     */
    @TestCase(input = {"2", "[2,4,1]", "2", "[3,2,6,5,0,3]"},
            output = {"2", "7"})
    public int commonDynamic0(int k, int[] prices) {
        return dynamic0K(prices, k, 0);
    }

}

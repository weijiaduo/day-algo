package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 123. 买卖股票的最佳时机 III
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 示例 4：
 * <p>
 * 输入：prices = [1]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁵
 *
 * @author weijiaduo
 * @since 2022/6/21
 */
public class MaxProfit3 extends MaxProfit {

    /**
     * 思路：动态规划
     * <p>
     * buy[i][j] 表示在 i 天内买入最多 j 次股票的最大利润，j < 2
     * <p>
     * sell[i][j] 表示在 i 天内卖出最多 j 次股票的最大利润，j < 2
     * <p>
     * 状态转移公式
     * <p>
     * buy[i][j] = max(sell[i-1][j-1] - prices[i], buy[i-1][j]) // 当天买入/不买不卖
     * <p>
     * sell[i][j] = max(buy[i-1][j] + prices[i], sell[i-1][j]) // 当天卖出/不买不卖
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:34 ms,击败了19.85% 的Java用户
     * 内存消耗:54.6 MB,击败了71.25% 的Java用户
     */
    @TestCase(input = {"[3,3,5,0,0,3,1,4]", "[1,2,3,4,5]", "[7,6,4,3,1] "},
            output = {"6", "4", "0"})
    public int dynamic1(int[] prices) {
        // 状态定义
        int n = prices.length, k = 2;
        int[][] buy = new int[n][k];
        int[][] sell = new int[n][k];
        // 状态初始化
        Arrays.fill(buy[0], -prices[0]);
        Arrays.fill(sell[0], 0);
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 第一次买入
            buy[i][0] = Math.max(-prices[i], buy[i - 1][0]);
            // 第一次卖出
            sell[i][0] = Math.max(buy[i - 1][0] + prices[i], sell[i - 1][0]);
            for (int j = 1; j < k; j++) {
                // 当天买入/不买不卖
                buy[i][j] = Math.max(sell[i - 1][j - 1] - prices[i], buy[i - 1][j]);
                // 当天卖出/不买不卖
                sell[i][j] = Math.max(buy[i - 1][j] + prices[i], sell[i - 1][j]);
            }
        }
        return sell[n - 1][1];
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了74.58% 的Java用户
     * 内存消耗:54.6 MB,击败了69.13% 的Java用户
     */
    @TestCase(input = {"[3,3,5,0,0,3,1,4]", "[1,2,3,4,5]", "[7,6,4,3,1] "},
            output = {"6", "4", "0"})
    public int dynamic0(int[] prices) {
        // 状态定义
        int n = prices.length;
        int[] buy = new int[2];
        int[] sell = new int[2];
        // 状态初始化
        Arrays.fill(buy, -prices[0]);
        Arrays.fill(sell, 0);
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 第一次买入和卖出
            buy[0] = Math.max(-prices[i], buy[0]);
            sell[0] = Math.max(buy[0] + prices[i], sell[0]);
            // 第二次买入和卖出
            buy[1] = Math.max(sell[0] - prices[i], buy[1]);
            sell[1] = Math.max(buy[1] + prices[i], sell[1]);
        }
        return sell[1];
    }

    /**
     * 思路：动态规划，数组改成变量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:57.8 MB,击败了25.63% 的Java用户
     */
    @TestCase(input = {"[3,3,5,0,0,3,1,4]", "[1,2,3,4,5]", "[7,6,4,3,1] "},
            output = {"6", "4", "0"})
    public int dynamic00(int[] prices) {
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

    /**
     * 思路：动态规划
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:40 ms,击败了18.86% 的Java用户
     * 内存消耗:57.3 MB,击败了19.52% 的Java用户
     */
    @TestCase(input = {"[3,3,5,0,0,3,1,4]", "[1,2,3,4,5]", "[7,6,4,3,1] "},
            output = {"6", "4", "0"})
    public int commonDynamic1(int[] prices) {
        return dynamic1K(prices, 2, 0);
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:9 ms,击败了50.57% 的Java用户
     * 内存消耗:52.90MB,击败了94.95% 的Java用户
     */
    @TestCase(input = {"[3,3,5,0,0,3,1,4]", "[1,2,3,4,5]", "[7,6,4,3,1] "},
            output = {"6", "4", "0"})
    public int commonDynamic0(int[] prices) {
        return dynamic0K(prices, 2, 0);
    }

}

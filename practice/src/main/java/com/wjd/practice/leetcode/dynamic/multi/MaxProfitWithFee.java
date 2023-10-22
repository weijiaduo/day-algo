package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.leetcode.TestCase;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5 * 10⁴
 * 1 <= prices[i] < 5 * 10⁴
 * 0 <= fee < 5 * 10⁴
 *
 * @author weijiaduo
 * @since 2023/10/17
 */
public class MaxProfitWithFee extends MaxProfit {

    /**
     * 思路：动态规划
     * <p>
     * dp[i][0] 表示在 [0,i] 内多次交易后处于买入状态的最大利润
     * <p>
     * dp[i][1] 表示在 [0,i] 内多次交易后处于卖出状态的最大利润
     * <p>
     * 状态转移公式
     * <p>
     * dp[i][0] = max(dp[i-1][1] - p[i], dp[i-1][0]) 新买入/不买不卖
     * <p>
     * dp[i][1] = max(dp[i-1][0] + p[i] - fee, dp[i-1][1]) 新卖出/不买不卖
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:17 ms,击败了61.75% 的Java用户
     * 内存消耗:54.6 MB,击败了14.42% 的Java用户
     */
    @TestCase(input = {"[1, 3, 2, 8, 4, 9]", "2", "[1,3,7,5,10,3]", "3"},
            output = {"8", "6"})
    public int dynamic1(int[] prices, int fee) {
        // 状态定义
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 状态初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 新买入/不买不卖
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            // 新卖出/不买不卖
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }

    /**
     * 思路：动态规划，使用滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了86.54% 的Java用户
     * 内存消耗:53.4 MB,击败了67.72% 的Java用户
     */
    @TestCase(input = {"[1, 3, 2, 8, 4, 9]", "2", "[1,3,7,5,10,3]", "3"},
            output = {"8", "6"})
    public int dynamic0(int[] prices, int fee) {
        int n = prices.length;
        // 状态定义及初始化
        int buy = -prices[0], sell = 0;
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 新买入/不买不卖
            buy = Math.max(sell - prices[i], buy);
            // 新卖出/不买不卖
            sell = Math.max(buy + prices[i] - fee, sell);
        }
        return sell;
    }

    /**
     * 思路：动态规划
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:28 ms,击败了5.43% 的Java用户
     * 内存消耗:53.2 MB,击败了77.86% 的Java用户
     */
    @TestCase(input = {"[1, 3, 2, 8, 4, 9]", "2", "[1,3,7,5,10,3]", "3"},
            output = {"8", "6"})
    public int commonDynamic1(int[] prices, int fee) {
        return dynamic1K(prices, -1, fee);
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了73.89% 的Java用户
     * 内存消耗:51.52MB,击败了97.10% 的Java用户
     */
    @TestCase(input = {"[1, 3, 2, 8, 4, 9]", "2", "[1,3,7,5,10,3]", "3"},
            output = {"8", "6"})
    public int commonDynamic0(int[] prices, int fee) {
        return dynamic0K(prices, -1, fee);
    }

    /**
     * 思路：贪心，官方题解
     * <p>
     * 换一个角度考虑，将手续费放在买入时进行计算
     * <p>
     * buy 表示在最大化收益的前提下，如果手上拥有一支股票，那么它的最低买入价格是多少
     * <p>
     * 当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了99.89% 的Java用户
     * 内存消耗:53.2 MB,击败了82.42% 的Java用户
     */
    @TestCase(input = {"[1, 3, 2, 8, 4, 9]", "2", "[1,3,7,5,10,3]", "3"},
            output = {"8", "6"})
    public int greedy(int[] prices, int fee) {
        int ans = 0;
        int n = prices.length;
        int buy = prices[0] + fee;
        for (int i = 1; i < n; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                ans += prices[i] - buy;
                buy = prices[i];
            }
        }
        return ans;
    }

}

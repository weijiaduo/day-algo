package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁴
 *
 * @since 2021-05-29
 */
public class MaxProfit1 extends MaxProfit {

    /**
     * 思路：贪心，优先用最小值，然后找它后面的更大值，两者差就是利润
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:57.4 MB,击败了73.57% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[7,6,4,3,1]"},
            output = {"5", "0"})
    public int greedy(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                // 找到更小值，那后面的最大差值就和之前的最小值没关系了
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // 找到更大值，更新最新的差值
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 思路：动态规划
     * <p>
     * dp[i][0] 表示前 i 天后处于买入状态的最大利润
     * <p>
     * dp[i][1] 表示前 i 天后处于卖出状态的最大利润
     * <p>
     * 状态转移公式
     * <p>
     * dp[i][0] = max(-price[i], dp[i-1][0]) // 当天买入/不买不卖，只能交易一次，所以是 -prices[i]
     * <p>
     * dp[i][1] = max(dp[i-1][0]+price[i], dp[i-1][1]) // 当天卖出/不买不卖
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:23 ms,击败了14.66% 的Java用户
     * 内存消耗:56.5 MB,击败了86.43% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[7,6,4,3,1]"},
            output = {"5", "0"})
    public int dynamic1(int[] prices) {
        int n = prices.length;
        // 状态定义
        int[][] dp = new int[n][2];
        // 状态初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 当天买入/不买不卖
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            // 当天卖出/不买不卖
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了47.45% 的Java用户
     * 内存消耗:57.7 MB,击败了30.34% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[7,6,4,3,1]"},
            output = {"5", "0"})
    public int dynamic0(int[] prices) {
        int n = prices.length;
        // 状态定义
        int[] dp = new int[2];
        // 状态初始化
        dp[0] = -prices[0];
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 当天买入/不买不卖
            dp[0] = Math.max(-prices[i], dp[0]);
            // 当天卖出/不买不卖
            dp[1] = Math.max(dp[0] + prices[i], dp[1]);
        }
        return dp[1];
    }

    /**
     * 思路：动态规划
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:44 ms,击败了5.46% 的Java用户
     * 内存消耗:55.3 MB,击败了95.20% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[7,6,4,3,1]"},
            output = {"5", "0"})
    public int commonDynamic1(int[] prices) {
        return dynamic1K(prices, 1, 0);
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了16.74% 的Java用户
     * 内存消耗:56.10MB,击败了63.51% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[7,6,4,3,1]"},
            output = {"5", "0"})
    public int commonDynamic0(int[] prices) {
        return dynamic0K(prices, 1, 0);
    }

}

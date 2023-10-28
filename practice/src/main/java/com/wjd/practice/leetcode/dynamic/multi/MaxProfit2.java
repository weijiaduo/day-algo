package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 总利润为 4 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 3 * 10⁴
 * 0 <= prices[i] <= 10⁴
 *
 * @since 2021-05-29
 */
public class MaxProfit2 extends MaxProfit {

    /**
     * 思路：贪心，只要有增长的地方，就买入和卖出
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.1 MB,击败了64.29% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[1,2,3,4,5]", "[7,6,4,3,1]", "[1,2,4,2,5,7,2,4,9,0,9]"},
            output = {"7", "4", "0", "24"})
    public int greedy(int[] prices) {
        int sumVal = 0;
        for (int rp = 1; rp < prices.length; rp++) {
            if (prices[rp] > prices[rp - 1]) {
                // 谷值到峰值之间上升值
                sumVal += prices[rp] - prices[rp - 1];
            }
        }
        return sumVal;
    }

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
     * dp[i][1] = max(dp[i-1][0] + p[i], dp[i-1][1]) 新卖出/不买不卖
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了29.97% 的Java用户
     * 内存消耗:43.2 MB,击败了30.88% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[1,2,3,4,5]", "[7,6,4,3,1]", "[1,2,4,2,5,7,2,4,9,0,9]"},
            output = {"7", "4", "0", "24"})
    public int dynamic1(int[] prices) {
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
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了35.24% 的Java用户
     * 内存消耗:43.1 MB,击败了68.97% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[1,2,3,4,5]", "[7,6,4,3,1]", "[1,2,4,2,5,7,2,4,9,0,9]"},
            output = {"7", "4", "0", "24"})
    public int dynamic0(int[] prices) {
        // 状态定义
        int n = prices.length;
        int[] dp = new int[2];
        // 状态初始化
        dp[0] = -prices[0];
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 新买入/不买不卖
            dp[0] = Math.max(dp[1] - prices[i], dp[0]);
            // 新卖出/不买不卖
            dp[1] = Math.max(dp[0] + prices[i], dp[1]);
        }
        return dp[1];
    }

    /**
     * 思路：动态规划
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了35.8% 的Java用户
     * 内存消耗:42.5 MB,击败了99.73% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[1,2,3,4,5]", "[7,6,4,3,1]", "[1,2,4,2,5,7,2,4,9,0,9]"},
            output = {"7", "4", "0", "24"})
    public int commonDynamic1(int[] prices) {
        return dynamic1K(prices, -1, 0);
    }

    /**
     * 思路：动态规划，滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了68.71% 的Java用户
     * 内存消耗:42.7 MB,击败了98.50% 的Java用户
     */
    @TestCase(input = {"[7,1,5,3,6,4]", "[1,2,3,4,5]", "[7,6,4,3,1]", "[1,2,4,2,5,7,2,4,9,0,9]"},
            output = {"7", "4", "0", "24"})
    public int commonDynamic0(int[] prices) {
        return dynamic0K(prices, -1, 0);
    }

}

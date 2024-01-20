package com.wjd.practice.recruit.bytedance;

import com.wjd.practice.TestCase;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 *
 * @author weijiaduo
 * @since 2024/1/20
 */
public class WaysToChangeCoins {

    /**
     * 思路：递归遍历所有情况
     * <p>
     * 看每种硬币可以分配多少种方式
     * <p>
     * 复杂度：时间 O(n^4) 空间 O(1)
     */
    @TestCase(input = {"5", "10"},
            output = {"2", "4"})
    public int dfs(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        return dfs(n, coins, 0);
    }

    private int dfs(int n, int[] coins, int i) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }

        int res = 0;
        int m = n / coins[i];
        for (int j = 0; j <= m; j++) {
            res += dfs(n - j * coins[i], coins, i + 1);
        }
        return res;
    }

    /**
     * 思路：动态规划
     * <p>
     * dp[i][j] 表示 i 个硬币组成金额为 j 的方法数量
     * <p>
     * dp[i][j] = sum(dp[i-1][j-k])
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"5", "10"},
            output = {"2", "4"})
    public int dynamic2(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        int m = coins.length;
        // 状态定义
        int[][] dp = new int[m + 1][n + 1];
        // 状态初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        // 状态转移
        for (int i = 1; i <= m; i++) {
            int coin = coins[i - 1];
            for (int j = coin; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
            }
        }
        return dp[m][n];
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * dp[i][j] 表示 i 个硬币组成金额为 j 的方法数量
     * <p>
     * dp[i][j] = sum(dp[i-1][j-k])
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"5", "10"},
            output = {"2", "4"})
    public int dynamic1(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        int m = coins.length;
        // 状态定义
        int[] dp = new int[n + 1];
        // 状态初始化
        dp[0] = 1;
        // 状态转移
        for (int i = 1; i <= m; i++) {
            int coin = coins[i - 1];
            for (int j = coin; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[n];
    }

}

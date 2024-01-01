package com.wjd.practice.book.cracking.dp;

import com.wjd.practice.TestCase;

/**
 * 面试题 08.11. 硬币
 * <p>
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * <p>
 * (结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 *
 * @author weijiaduo
 * @since 2024/1/1
 */
public class WaysToChange {

    final int MOD = 1000000007;

    /**
     * 思路：动态规划
     * <p>
     * dp[i][j] 表示 i 个硬币组成金额为 j 的方法数量
     * <p>
     * dp[i][j] = sum(dp[i-1][j-k])
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:27 ms,击败了34.54% 的Java用户
     * 内存消耗:69.5 MB,击败了5.62% 的Java用户
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
                dp[i][j] = (dp[i - 1][j] + dp[i][j - coin]) % MOD;
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
     * <p>
     * 执行耗时:23 ms,击败了88.35% 的Java用户
     * 内存消耗:42.7 MB,击败了25.70% 的Java用户
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
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }
        return dp[n];
    }

    /**
     * 思路：数学
     * <p>
     * 先枚举 25，再枚举 10，最后枚举 5
     * <p>
     * 将这 3 种枚举结果累加起来，就是种类数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了96.39% 的Java用户
     */
    @TestCase(input = {"5", "10"},
            output = {"2", "4"})
    public int math(int n) {
        int ans = 0;
        for (int i = 0; i * 25 <= n; ++i) {
            int rest = n - i * 25;
            int a = rest / 10;
            int b = rest % 10 / 5;
            ans = (ans + (int) ((long) (a + 1) * (a + b + 1) % MOD)) % MOD;
        }
        return ans;
    }

}

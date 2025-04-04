package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * <p>
 * 如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2³¹ - 1
 * 0 <= amount <= 10⁴
 *
 * @author weijiaduo
 * @since 2023/7/4
 */
public class CoinChange {

    /**
     * 思路：递归，每次减去一个硬币，然后继续对剩余金额进行递归
     * <p>
     * 复杂度：时间 O(S^n) 空间 O(n)
     * <p>
     * Time Limit Exceeded
     */
    @TestCase(input = {"[1, 2, 5]", "11", "[2]", "3", "[1]", "0"},
            output = {"3", "-1", "0"})
    public int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int ans = amount + 1;
        for (int coin : coins) {
            int c = dfs(coins, amount - coin);
            if (c >= 0) {
                ans = Math.min(c + 1, ans);
            }
        }
        return ans > amount ? -1 : ans;
    }

    /**
     * 思路：记忆化搜索，在递归上加上缓存，去除重复子问题
     * <p>
     * 复杂度：时间 O(Sn) 空间 O(n)
     * <p>
     * 执行耗时:24 ms,击败了19.09% 的Java用户
     * 内存消耗:42.2 MB,击败了20.70% 的Java用户
     */
    @TestCase(input = {"[1, 2, 5]", "11", "[2]", "3", "[1]", "0"},
            output = {"3", "-1", "0"})
    public int memo(int[] coins, int amount) {
        // -2 表示还未计算
        // -1 表示计算失败
        // >= 0 表示计算成功
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -2);
        return meno(coins, amount, cache);
    }

    private int meno(int[] coins, int amount, int[] cache) {
        if (amount < 0) {
            return -1;
        }
        if (cache[amount] != -2) {
            return cache[amount];
        }
        if (amount == 0) {
            return 0;
        }

        int ans = amount + 1;
        for (int coin : coins) {
            int c = meno(coins, amount - coin, cache);
            if (c >= 0) {
                ans = Math.min(c + 1, ans);
            }
        }
        ans = ans > amount ? -1 : ans;
        cache[amount] = ans;
        return ans;
    }

    /**
     * 思路：动态规划
     * <p>
     * 记忆化搜搜是自顶向下，动态规划则是反过来，自底向上
     * <p>
     * dp[i][j] 表示以 i 种硬币凑成金额 j 的最少硬币个数
     * <p>
     * dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i]] + 1)
     * <p>
     * 复杂度：时间 O(Sn) 空间 O(n)
     * <p>
     * 执行耗时:16 ms,击败了30.49% 的Java用户
     * 内存消耗:43.95 MB,击败了5.05% 的Java用户
     */
    @TestCase(input = {"[1, 2, 5]", "11", "[2]", "3", "[1]", "0"},
            output = {"3", "-1", "0"})
    public int dynamic2(int[] coins, int amount) {
        Arrays.sort(coins);
        // 1. 状态定义
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // 2. 状态初始化
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }
        // 3. 状态转移
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coin) {
                    dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i][j]);
                }
            }
        }
        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }

    /**
     * 思路：动态规划，将记忆化搜索转成动态规划
     * <p>
     * 记忆化搜搜是自顶向下，动态规划则是反过来，自底向上
     * <p>
     * dp[i] 表示金额为 i 时的最少硬币数量
     * <p>
     * dp[i] = min(dp[i], dp[i - coins[j]] + 1)
     * <p>
     * 复杂度：时间 O(Sn) 空间 O(n)
     * <p>
     * 执行耗时:13 ms,击败了75.84% 的Java用户
     * 内存消耗:43.3 MB,击败了86.19% 的Java用户
     */
    @TestCase(input = {"[1, 2, 5]", "11", "[2]", "3", "[1]", "0"},
            output = {"3", "-1", "0"})
    public int dynamic1(int[] coins, int amount) {
        // 1. 状态定义
        int[] dp = new int[amount + 1];

        // 2. 状态初始化
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 3. 状态转移
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}

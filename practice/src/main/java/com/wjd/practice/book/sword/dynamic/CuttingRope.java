package com.wjd.practice.book.sword.dynamic;

import com.wjd.practice.TestCase;

/**
 * 14. 剪绳子
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1）。
 * <p>
 * 每段的绳子的长度记为k[0],k[1],...,k[m]。k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * <p>
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class CuttingRope {

    /**
     * 思路：递归+记忆化搜索
     * <p>
     * 复杂度：时间 O(m*n^2) 空间 O(mn)
     */
    @TestCase(input = {"8", "3"}, output = {"18"})
    public long dfs(int n, int m) {
        return dfs(n, m, new long[n + 1][m + 1]);
    }

    private long dfs(int n, int m, long[][] momo) {
        if (m <= 0 || m > n) {
            return 0;
        }
        if (m == 1) {
            return n;
        }
        if (momo[n][m] != 0) {
            return momo[n][m];
        }
        long maxRes = 0;
        // 剪掉第一段，剩下的继续剪
        for (int i = 1; i < n; i++) {
            maxRes = Math.max(maxRes, i * dfs(n - i, m - 1, momo));
        }
        momo[n][m] = maxRes;
        return maxRes;
    }

    /**
     * 思路：动态规划
     * <p>
     * 复杂度：时间 O(m * n^2) 空间 O(mn)
     */
    @TestCase(input = {"8", "3"}, output = {"18"})
    public long dynamic2(int n, int m) {
        if (m <= 0 || m > n) {
            return 0;
        }

        // 状态定义
        // dp[i][j] 表示长度为 i 的绳子剪成 j 段的最大乘积
        long[][] dp = new long[n + 1][m + 1];

        // 状态初始化
        for (int i = 0; i < n; i++) {
            // 只有 1 段的时候，最大乘积就是绳子的长度
            dp[i][1] = i;
        }

        // 状态转移
        // dp[i][j] = max(dp[i][j], dp[i - k][j - 1] * k)
        // k 表示第 j 段的长度，k 属于 [1, i - j + 1]
        for (int j = 2; j <= m; j++) {
            for (int i = j; i <= n; i++) {
                for (int k = 1; k <= i - j + 1; k++) {
                    dp[i][j] = Math.max(dp[i - k][j - 1] * k, dp[i][j]);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * 复杂度：时间 O(m * n^2) 空间 O(n)
     */
    @TestCase(input = {"8", "3"}, output = {"18"})
    public long dynamic1(int n, int m) {
        if (m <= 0 || m > n) {
            return 0;
        }

        // 状态定义
        // dp[i] 表示长度为 i 的绳子剪成 j 段的最大乘积
        long[] dp = new long[n + 1];

        // 状态初始化
        for (int i = 0; i <= n; i++) {
            // 只有 1 段的时候，最大乘积就是绳子的长度
            dp[i] = i;
        }

        // 状态转移
        // dp[i] = max(dp[i], dp[i - k] * k)
        // k 表示第 j 段的长度，k 属于 [1, i - j + 1]
        for (int j = 2; j <= m; j++) {
            for (int i = n; i >= j; i--) { // 倒着遍历，避免覆盖
                for (int k = 1; k <= i - j + 1; k++) {
                    dp[i] = Math.max(dp[i - k] * k, dp[i]);
                }
            }
        }
        return dp[n];
    }

}

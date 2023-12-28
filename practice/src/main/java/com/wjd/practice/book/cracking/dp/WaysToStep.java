package com.wjd.practice.book.cracking.dp;

import com.wjd.practice.TestCase;

/**
 * 面试题 08.01. 三步问题
 * <p>
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * <p>
 * 实现一种方法，计算小孩有多少种上楼梯的方式。
 * <p>
 * 结果可能很大，你需要对结果模 1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * <p>
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * <p>
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 *
 * @author weijiaduo
 * @since 2023/12/28
 */
public class WaysToStep {

    static final int MOD = 1000000007;

    /**
     * 思路：动态规划
     * <p>
     * 设定 dp[i] 是走到第 i 个台阶的方式数量
     * <p>
     * 则有 dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:26 ms,击败了18.43% 的Java用户
     * 内存消耗:42.6 MB,击败了22.28% 的Java用户
     */
    @TestCase(input = {"3", "5", "61"},
            output = {"4", "13", "752119970"})
    public int dynamic1(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        // 状态定义
        int[] dp = new int[n + 1];
        // 状态初始化
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            dp[i] = (dp[i] + dp[i - 3]) % MOD;
        }
        return dp[n];
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * 由于只用到了前面 3 个值，所以可以采用滚动计算的方式压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:19 ms,击败了49.77% 的Java用户
     * 内存消耗:39.4 MB,击败了68.82% 的Java用户
     */
    @TestCase(input = {"3", "5", "61"},
            output = {"4", "13", "752119970"})
    public int dynamic0(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        // 状态初始化
        int last3 = 1, last2 = 1, last1 = 2;
        // 状态转移
        for (int i = 3; i <= n; i++) {
            int val = (last1 + last2) % MOD;
            val = (val + last3) % MOD;
            last3 = last2;
            last2 = last1;
            last1 = val;
        }
        return last1;
    }

    /**
     * 思路：快速幂
     * <p>
     * [f(n),f(n-1),f(n-2)]
     * <p>
     * = [[1,1,1][0,1,0],[0,0,1]] * [f(n-1),f(n-2),f(n-3)]
     * <p>
     * = [[1,1,1][0,1,0],[0,0,1]]^(n-3) * [f(3),f(2),f(1)]
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了68.97% 的Java用户
     */
    @TestCase(input = {"3", "5", "61"},
            output = {"4", "13", "752119970"})
    public int quickPow(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        long[][] a = new long[][]{{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        a = pow(a, n - 3);
        return (int) ((a[0][0] * 4 + a[0][1] * 2 + a[0][2]) % MOD);
    }

    /**
     * 矩阵的幂次方
     *
     * @param a 矩阵
     * @param k 幂次
     * @return 矩阵幂
     */
    private long[][] pow(long[][] a, int k) {
        long[][] ans = new long[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        long[][] e = a;
        while (k != 0) {
            if ((k & 1) == 1) {
                ans = multiply(ans, e);
            }
            e = multiply(e, e);
            k >>>= 1;
        }
        return ans;
    }

    /**
     * 矩阵乘法
     *
     * @param a 矩阵
     * @param b 矩阵
     * @return 矩阵相乘结果
     */
    private long[][] multiply(long[][] a, long[][] b) {
        int m = a.length, n = b[0].length;
        long[][] c = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < a[i].length; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j] % MOD) % MOD;
                }
            }
        }
        return c;
    }

}

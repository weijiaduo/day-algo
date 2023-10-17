package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.leetcode.TestCase;

/**
 * 790. 多米诺和托米诺平铺
 * <p>
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * <p>
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10⁹ + 7 取模 的值。
 * <p>
 * 平铺指的是每个正方形都必须有瓷砖覆盖。
 * <p>
 * 两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3
 * 输出: 5
 * 解释: 五种不同的方法如上所示。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 1
 * 输出: 1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 *
 * @author weijiaduo
 * @since 2023/10/16
 */
public class NumTilings {

    static final int MOD = 1000000007;

    /**
     * 官方题解，这题我还真没思路，想不完全
     * <p>
     * 思路：一维动态规划
     * <p>
     * 第 i 列的正方形有四种被覆盖的情况：
     * <p>
     * 1. 一个正方形都没有被覆盖，记为状态 0；
     * <p>
     * 2. 只有上方的正方形被覆盖，记为状态 1；
     * <p>
     * 3. 只有下方的正方形被覆盖，记为状态 2；
     * <p>
     * 4. 上下两个正方形都被覆盖，记为状态 3。
     * <p>
     * 使用 dp[i][s] 表示平铺到第 i 列时，各个状态 sss 对应的平铺方法数量。
     * <p>
     * 状态转移方程（i>0）为：
     * <p>
     * dp[i][0] = dp[i−1][3]
     * <p>
     * dp[i][1] = dp[i−1][0]+dp[i−1][2]
     * <p>
     * dp[i][2] = dp[i−1][0]+dp[i−1][1]
     * <p>
     * dp[i][3] = dp[i−1][0]+dp[i−1][1]+dp[i−1][2]+dp[i−1][3]
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"3", "1", "4"},
            output = {"5", "1", "11"})
    public int dynamic(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }

}
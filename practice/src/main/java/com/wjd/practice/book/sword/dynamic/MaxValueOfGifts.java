package com.wjd.practice.book.sword.dynamic;

import com.wjd.practice.TestCase;

/**
 * 47. 礼物的最大价值
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * <p>
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 * <p>
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class MaxValueOfGifts {

    /**
     * 思路：动态规划
     * <p>
     * 用 f(i, j) 表示到达坐标 (i, j) 时能拿到的礼物总和的最大值，
     * <p>
     * 那么 f(i, j) = max(f(i-1, j), f(i, j-1)) + gift(i, j)
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     */
    @TestCase(input = {"[[1,3,1],[1,5,1],[4,2,1]]"}, output = {"12"})
    public int dynamic1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 状态定义
        // dp[i][j] 表示到达坐标 (i, j) 时能拿到的礼物总和的最大值
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        // 状态初始化
        dp[0][0] = grid[0][0];
        // 第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[0][i];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * 由于只依赖于上一行和左边的状态，所以可以用滚动数组优化空间复杂度
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     */
    @TestCase(input = {"[[1,3,1],[1,5,1],[4,2,1]]"}, output = {"12"})
    public int dynamic0(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 状态定义
        // dp[i][j] 表示到达坐标 (i, j) 时能拿到的礼物总和的最大值
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = grid[0][0];
        // 第一行
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }

}

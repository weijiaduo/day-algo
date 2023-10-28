package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
 * 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 *
 * @author weijiaduo
 * @since 2022/6/1
 */
public class MinPathSum {

    /**
     * 思路：动态规划，最短路径 = min(左边,上边) + 当前值
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:2 ms,击败了92.30% 的Java用户
     * 内存消耗:42.7 MB,击败了82.36% 的Java用户
     */
    @TestCase(input = {"[[1,3,1],[1,5,1],[4,2,1]]", "[[1,2,3],[4,5,6]]"},
            output = {"7", "12"})
    public int dynamic2(int[][] grid) {
        // 状态定义
        // dp[i][j] 表示抵达 (i,j) 坐标的最小路径和
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        // 状态初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 思路：动态规划，滚动数组
     * <p>
     * 二维数组动态规划，只依赖于左边和上边
     * <p>
     * 所以可以改成只用滚动数组来替代，优化空间
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了92.30% 的Java用户
     * 内存消耗:42.6 MB,击败了94.97% 的Java用户
     */
    @TestCase(input = {"[[1,3,1],[1,5,1],[4,2,1]]", "[[1,2,3],[4,5,6]]"},
            output = {"7", "12"})
    public int dynamic1(int[][] grid) {
        // 状态定义
        // dp[j] 表示抵达 (*,j) 坐标的最小路径和
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        // 状态初始化
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }

}

package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
 * 63. 不同路径2
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @since 2022/6/1
 */
public class UniquePathsWithObstacles {

    /**
     * 思路：动态规划，碰到障碍物，直接步数为0，其他空位则是左边和上边的步数和
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了55.02% 的Java用户
     */
    @TestCase(input = {"[[0,0,0],[0,1,0],[0,0,0]]", "[[0,1],[0,0]]"},
            output = {"2", "1"})
    public int dynamic2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 状态定义
        // dp[i][j] 表示抵达 (i,j) 坐标的不同路径数量
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 状态初始化
        dp[0][0] = 1;
        // 第一行
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        // 第一列
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 状态转移
        // dp[i][j] += dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 思路：动态规划+滚动数组，在使用二维数组的基础下，改成只用一维数组
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了93.40% 的Java用户
     */
    @TestCase(input = {"[[0,0,0],[0,1,0],[0,0,0]]", "[[0,1],[0,0]]"},
            output = {"2", "1"})
    public int dynamic1(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 状态定义
        // dp[j] 表示抵达 (*,j) 坐标的不同路径数量
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = 1;

        // 状态转移
        // dp[j] = dp[j] + dp[j - 1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0) {
                    // 上一行的dp[j]和当前行的dp[j-1]
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

}

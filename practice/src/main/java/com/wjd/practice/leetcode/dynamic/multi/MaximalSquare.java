package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
 * 221. 最大正方形
 * <p>
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 * @author weijiaduo
 * @since 2023/11/12
 */
public class MaximalSquare {

    /**
     * 思路：动态规划
     * <p>
     * 定义 dp[i][j] 表示以坐标 (i,j) 为正方形的右下角时的边长
     * <p>
     * 则分为 2 种情况：
     * <p>
     * 1. matrix[i][j] = 0，不可能成为正方形，dp[i][j] = 0
     * <p>
     * 2. matrix[i][j] = 1，则还可以分为 2 种情况
     * <p>
     * 2.1 dp[i-1][j-1] = 0，则 dp[i][j] = 1
     * <p>
     * 2.2 dp[i-1][j-1] = 0，则 dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:6 ms,击败了87.84% 的Java用户
     * 内存消耗:52.5 MB,击败了78.64% 的Java用户
     */
    @TestCase(input = {
            """
                    [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]""",
            """
                    [['0','1'],['1','0']]""",
            """
                    [['0']]""",
            """
                    [['0','0','0','1'],['1','1','0','1'],['1','1','1','1'],['0','1','1','1'],['0','1','1','1']]"""},
            output = {"4", "1", "0", "9"})
    public int dynamic2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        // 状态定义
        // dp[i][j] 表示以坐标 (i,j) 为正方形的右下角时的边长
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int side = 0;

        // 状态初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            side = Math.max(dp[i][0], side);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            side = Math.max(dp[0][j], side);
        }

        // 状态转移
        // dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    side = Math.max(dp[i][j], side);
                }
            }
        }
        return side * side;
    }

    /**
     * 思路：依旧是动态规划，只是处理了特殊的边界判断，减少代码
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:6 ms,击败了88.74% 的Java用户
     * 内存消耗:56.34 MB,击败了7.25% 的Java用户
     */
    @TestCase(input = {
            """
                    [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]""",
            """
                    [['0','1'],['1','0']]""",
            """
                    [['0']]""",
            """
                    [['0','0','0','1'],['1','1','0','1'],['1','1','1','1'],['0','1','1','1'],['0','1','1','1']]"""},
            output = {"4", "1", "0", "9"})
    public int dynamic21(char[][] matrix) {
        int side = 0;
        // 状态定义
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        // 状态初始化
        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                side = Math.max(dp[i][j], side);
            }
        }
        return side * side;
    }

}

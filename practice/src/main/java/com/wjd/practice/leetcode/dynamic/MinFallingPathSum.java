package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.TestCase;

/**
 * 931. 下降路径最小和
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * <p>
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * <p>
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 * @author weijiaduo
 * @since 2023/7/13
 */
public class MinFallingPathSum {

    /**
     * 思路：动态规划
     * <p>
     * 定义 dp[i][j] 是以 (i,j) 为路径末端时的最小和
     * <p>
     * 则 dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1]) + matrix[i][j]
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:5 ms,击败了37.82% 的Java用户
     * 内存消耗:43.4 MB,击败了7.96% 的Java用户
     */
    @TestCase(input = {"[[2,1,3],[6,5,4],[7,8,9]]", "[[-19,57],[-40,-5]]"},
            output = {"13", "-59"})
    public int dynamic2(int[][] matrix) {
        // 状态定义
        // dp[i][j] 是以 (i,j) 为路径末端时的最小和
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        // 状态初始化
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 正上方
                int tmp = dp[i - 1][j];
                // 左上角
                if (j > 0) {
                    tmp = Math.min(dp[i - 1][j - 1], tmp);
                }
                // 右上角
                if (j < n - 1) {
                    tmp = Math.min(dp[i - 1][j + 1], tmp);
                }
                dp[i][j] = tmp + matrix[i][j];
            }
        }
        // 寻找最大值
        int ans = Integer.MAX_VALUE;
        for (int num : dp[m - 1]) {
            ans = Math.min(num, ans);
        }
        return ans;
    }

}

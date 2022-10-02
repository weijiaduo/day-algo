package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 第 313 场周赛
 * <p>
 * 6193. 沙漏的最大总和
 * <p>
 * 给你一个大小为 m x n 的整数矩阵 grid 。
 * <p>
 * 按以下形式将矩阵的一部分定义为一个 沙漏 ：
 * <p>
 * A B C
 * <p>
 * &nbsp;&nbsp;&nbsp;D
 * <p>
 * E F G
 * <p>
 * 返回沙漏中元素的 最大 总和。
 * <p>
 * 注意：沙漏无法旋转且必须整个包含在矩阵中。
 *
 * @author weijiaduo
 * @since 2022/10/2
 */
public class MaxSum implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] grid = {{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}};
        int result = maxSum(grid);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：暴力模拟，直接按照题目要求，求出每个沙漏的和
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     */
    private int maxSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans = Math.max(sum(grid, i, j), ans);
            }
        }
        return ans;
    }

    /**
     * 计算一个沙漏的和
     */
    private int sum(int[][] grid, int i, int j) {
        int sum = 0;
        for (int k = 0; k < 3; k++) {
            sum += grid[i][j + k];
        }
        sum += grid[i + 1][j + 1];
        for (int k = 0; k < 3; k++) {
            sum += grid[i + 2][j + k];
        }
        return sum;
    }

}

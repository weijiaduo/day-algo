package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 1252. 奇数值单元格的数目
 * <p>
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，
 * <p>
 * 其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * <p>
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * <p>
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 * <p>
 * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * @author weijiaduo
 * @since 2022/7/12
 */
public class OddCells implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int m = 2;
        int n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        int result = oddCells2(m, n, indices);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接暴力法，生成一个矩阵，按照indices设置值，最后再遍历矩阵判断奇数
     * <p>
     * 复杂度：时间 O(km + kn + mn) 空间 O(mn)
     * <p>
     * 执行耗时:1 ms,击败了55.04% 的Java用户
     * 内存消耗:39.9 MB,击败了7.75% 的Java用户
     */
    private int oddCells(int m, int n, int[][] indices) {
        if (m <= 0 || n <= 0 || indices.length <= 0) {
            return 0;
        }

        int[][] matrix = new int[m][n];
        for (int[] dice : indices) {
            for (int j = 0; j < n; j++) {
                matrix[dice[0]][j]++;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][dice[1]]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[i][j] & 1) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 思路：记录每行和每列的增量，奇数单元格 = 奇数行数 * n + 奇数列数 * m - 奇数行和奇数列的交点
     * <p>
     * 复杂度：时间 O(n + m + indices.length) 空间 O(n + m)
     * <p>
     * 行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了91.47% 的Java用户
     */
    private int oddCells2(int m, int n, int[][] indices) {
        if (m <= 0 || n <= 0 || indices.length <= 0) {
            return 0;
        }

        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] dice : indices) {
            row[dice[0]]++;
            col[dice[1]]++;
        }

        int ans = 0;
        int oddRows = 0;
        for (int num : row) {
            if ((num & 1) == 1) {
                oddRows++;
            }
        }
        int oddCols = 0;
        for (int num : col) {
            if ((num & 1) == 1) {
                oddCols++;
            }
        }

        // 减去奇数行和奇数列的交点
        ans += oddRows * (n - oddCols);
        ans += oddCols * (m - oddRows);

        return ans;
    }

}

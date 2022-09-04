package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 1582. 二进制矩阵中的特殊位置
 * <p>
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：
 * <p>
 * 如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i,j) 被称为特殊位置。
 * <p>
 * 输入：mat = [[1,0,0],[0,0,1],[1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 * @author weijiaduo
 * @since 2022/9/4
 */
public class NumSpecial implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] mat = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int result = numSpecial(mat);
        System.out.println(result);
        return result;
    }

    private int numSpecial(int[][] mat) {
        // return map(mat);
        return map2(mat);
    }

    /**
     * 思路：把矩阵值分别投影到第一行和第一列，如果投影是1，说明这行/这列只有一个1
     * <p>
     * 复杂度：时间 O(m * n) 空间 O(m + n)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了11.21% 的Java用户
     */
    private int map(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }

        // 投影到一行和一行
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = mat[i][j];
                rows[i] += num;
                cols[j] += num;
            }
        }

        // 判断投影和为1的行列
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 && cols[j] == 1 && mat[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 思路：在投影的基础上，压缩空间，用 cols[j] 表示第j列中所有1所在行的1的总和，cols[j] == 0 的数量就是结果
     * <p>
     * 实际上还可以进一步压缩空间，直接用矩阵的第一列保存数量即可
     * <p>
     * 复杂度：时间 O(m * n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了85.78% 的Java用户
     */
    private int map2(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }

        int m = mat.length, n = mat[0].length;
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            // 统计行中1的数量
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += mat[i][j];
            }

            // 列中1所在行的1的累计数量
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cols[j] += count;
                }
            }
        }

        // 统计数量为1的位置
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (cols[j] == 1) {
                count++;
            }
        }
        return count;
    }

}

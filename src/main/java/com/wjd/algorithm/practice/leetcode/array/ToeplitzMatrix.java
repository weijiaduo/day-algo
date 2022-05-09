package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2021-06-08
 * <p>
 * 766. 托普利茨矩阵
 * <p>
 * 你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 */
public class ToeplitzMatrix implements Solution<Boolean> {

    @Override
    public Boolean solve(Object args) {
        int[][] matrix = {{1, 2}, {2, 2}};
        boolean result = isToeplitzMatrix(matrix);
        System.out.println(result);
        return result;
    }

    /**
     * 是否是托普利茨矩阵
     *
     * @param matrix 矩阵
     * @return true/false
     */
    private boolean isToeplitzMatrix0(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 是否是托普利茨矩阵
     *
     * @param matrix 矩阵
     * @return true/false
     */
    private boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return true;
        }
        int n = Math.max(matrix.length, matrix[0].length);
        for (int i = n - 1; i > 0; i--) {
            if (!isToeplitz(matrix, 0, i)
                    || !isToeplitz(matrix, i, 0)) {
                return false;
            }
        }
        return isToeplitz(matrix, 0, 0);
    }

    /**
     * 一条斜线是否都是相同数字
     *
     * @param matrix 矩阵
     * @param i      横坐标
     * @param j      纵坐标
     * @return true/false
     */
    private boolean isToeplitz(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int m = i + 1, n = j + 1;
        while (m < rows && n < cols) {
            if (matrix[m++][n++] != matrix[i][j]) {
                return false;
            }
        }
        return true;
    }

}

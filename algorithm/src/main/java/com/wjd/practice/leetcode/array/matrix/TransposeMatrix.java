package com.wjd.practice.leetcode.array.matrix;

/**
 * 867. 转置矩阵
 * <p>
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * @since 2021-06-23
 */
public class TransposeMatrix {

    /**
     * 矩阵转置
     *
     * @param matrix 矩阵
     * @return 转置矩阵
     */
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }
        int[][] trans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        return trans;
    }

}

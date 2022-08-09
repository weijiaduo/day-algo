package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-06-03
 * <p>
 * 566. 重塑矩阵
 * <p>
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * <p>
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * <p>
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 */
public class MatrixReshape implements Solution<int[][]> {

    @Override
    public int[][] solve(Object ...args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 2;
        int c = 4;
        int[][] result = matrixReshape(mat, r, c);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 重塑矩阵
     *
     * @param mat 矩阵
     * @param r   行数
     * @param c   列数
     * @return 重塑后的矩阵
     */
    private int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length <= 0 || mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[k / c][k % c] = mat[i][j];
                k++;
            }
        }
        return result;
    }
}

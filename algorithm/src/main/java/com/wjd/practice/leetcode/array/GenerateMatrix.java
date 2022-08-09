package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * 59. 螺旋矩阵2
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * @since 2022/5/31
 */
public class GenerateMatrix implements Solution<int[][]> {

    @Override
    public int[][] solve(Object... args) {
        int n = 1;
        int[][] result = generateMatrix(n);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 思路：使用四条边夹住未遍历的二维数组元素
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了9.07% 的Java用户
     */
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int top = -1, bottom = matrix.length;
        int left = -1, right = matrix[0].length;
        while (top + 1 < bottom && left + 1 < right) {
            // 上边
            top++;
            for (int i = left + 1; top < bottom && i < right; i++) {
                matrix[top][i] = num++;
            }
            // 右边
            right--;
            for (int i = top + 1; left < right && i < bottom; i++) {
                matrix[i][right] = num++;
            }
            // 下边
            bottom--;
            for (int i = right - 1; top < bottom && i > left; i--) {
                matrix[bottom][i] = num++;
            }
            // 左边
            left++;
            for (int i = bottom - 1; left < right && i > top; i--) {
                matrix[i][left] = num++;
            }
        }
        return matrix;
    }

}

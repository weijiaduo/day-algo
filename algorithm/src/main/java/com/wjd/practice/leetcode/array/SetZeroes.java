package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.util.ArrayUtil;

/**
 * 面试题 01.08 零矩阵
 * <p>
 * 相关题目:
 * <p>
 * 73. 矩阵置零
 * <p>
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 * @author weijiaduo
 * @since 2022/9/30
 */
public class SetZeroes implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeros(matrix);
        ArrayUtil.print(matrix);
        return null;
    }

    /**
     * 思路：使用行区和列区2个标记数组，标记每一行每一列的0情况，需要2次遍历，一次标记一次设0
     * <p>
     * 复杂度：时间 O(mn) 空间(m + n)
     */
    private void setZeros(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}

package com.wjd.practice.book.cracking.matrix;

import com.wjd.practice.TestCase;

/**
 * 面试题 01.08. 零矩阵
 * <p>
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 示例 1：
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
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 *
 * @author weijiaduo
 * @since 2023/12/14
 */
public class SetZeroes {

    /**
     * 思路：额外的2个一维数组记录 0 值
     * <p>
     * 复杂度：时间 O(mn) 空间 O(m + n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:43.4 MB,击败了61.67% 的Java用户
     */
    @TestCase(input = {"[[1,1,1],[1,0,1],[1,1,1]]", "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]"},
            output = {"[[1,0,1],[0,0,0],[1,0,1]]", "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]"})
    public void arraySetZeroes(int[][] matrix) {
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

    /**
     * 思路：把0值所在的行头和列头标记为0，表明这一行和一列都需要设置成0
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了69.13% 的Java用户
     */
    @TestCase(input = {"[[1,1,1],[1,0,1],[1,1,1]]", "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]"},
            output = {"[[1,0,1],[0,0,0],[1,0,1]]", "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]"})
    public void constSetZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // 先记录第1行和第1列是否有0存在
        int m = matrix.length, n = matrix[0].length;
        boolean row = false, col = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                col = true;
                break;
            }
        }

        // 投影到第1行和第1列，表示此处需要置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 标记行头和列头为0值
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 根据投影到第1行和第1列的零，对矩阵进行置零
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后需要单独判断第1行和第1列是否需要置零
        for (int i = 0; row && i < m; i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; col && j < n; j++) {
            matrix[0][j] = 0;
        }
    }

}

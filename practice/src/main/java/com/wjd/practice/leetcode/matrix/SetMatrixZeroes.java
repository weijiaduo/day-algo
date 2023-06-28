package com.wjd.practice.leetcode.matrix;

/**
 * 73. 矩阵置零
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
 * <p>
 * 请使用 原地 算法。
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * @since 2022/6/4
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        // matrixSetZeroes(matrix);
        // arraySetZeroes(matrix);
        constSetZeroes(matrix);
    }

    /**
     * 思路：额外的二维空间保存 0 的值
     * <p>
     * 复杂度：时间 O(nm(m+n)) 空间 O(mn)
     */
    public void matrixSetZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] flags = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flags[i][j] = matrix[i][j] == 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flags[i][j]) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }

    /**
     * 思路：额外的2个一维数组记录 0 值
     * <p>
     * 复杂度：时间 O(mn) 空间 O(m + n)
     * <p>
     * 执行耗时:1 ms,击败了37.14% 的Java用户
     * 内存消耗:42.6 MB,击败了93.23% 的Java用户
     */
    public void arraySetZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean f = matrix[i][j] == 0;
                rows[i] = rows[i] || f;
                cols[j] = cols[j] || f;
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < cols.length; j++) {
            if (cols[j]) {
                for (int i = 0; i < m; i++) {
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
    public void constSetZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
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
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 标记行头和列头为0值
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
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
        // 第一列
        for (int i = 0; row && i < m; i++) {
            matrix[i][0] = 0;
        }
        // 第一行
        for (int j = 0; col && j < n; j++) {
            matrix[0][j] = 0;
        }
    }
}

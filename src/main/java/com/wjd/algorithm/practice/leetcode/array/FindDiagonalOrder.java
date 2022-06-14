package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * 498. 对角线遍历
 * <p>
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * <p>
 * @since 2022/6/14
 */
public class FindDiagonalOrder implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = findDiagonalOrder(mat);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 思路：从左上角到右下角，当成一个三角形，一层一层遍历，当然也要跳过非法的点
     *
     * 执行耗时:136 ms,击败了5.17% 的Java用户
     * 内存消耗:43 MB,击败了72.21% 的Java用户
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int length = m + n - 1;
        int k = 0, x = 0;
        int[] ans = new int[m * n];
        while (k < length) {
            if (k % 2 == 0) {
                for (int i = k, j = 0; i >= 0; i--, j++) {
                    if (i >= m || j >= n) {
                        continue;
                    }
                    ans[x++] = mat[i][j];
                }
            } else {
                for (int i = 0, j = k; j >= 0; i++, j--) {
                    if (i >= m || j >= n) {
                        continue;
                    }
                    ans[x++] = mat[i][j];
                }
            }
            k++;
        }
        return ans;
    }

    /**
     * 思路，一样是三角形层次遍历，但是减少不必要的遍历，直接算出起始点
     *
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.9 MB,击败了86.31% 的Java用户
     */
    public int[] findDiagonalOrder2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int x = 0;
        int[] ans = new int[m * n];
        for (int k = 0; k < m + n - 1; k++) {
            if (k % 2 == 0) {
                // 左下角起
                int i = k >= m ? m - 1 : k;
                int j = k >= m ? k - m + 1 : 0;
                for (; i >= 0 && j < n; i--, j++) {
                    ans[x++] = mat[i][j];
                }
            } else {
                // 右上角起
                int i = k >= n ? k - n + 1 : 0;
                int j = k >= n ? n - 1 : k;
                for (; i < m && j >= 0; i++, j--) {
                    ans[x++] = mat[i][j];
                }
            }
        }
        return ans;
    }

}

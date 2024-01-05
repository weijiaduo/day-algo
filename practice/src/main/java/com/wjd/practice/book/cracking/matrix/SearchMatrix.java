package com.wjd.practice.book.cracking.matrix;

import com.wjd.practice.TestCase;

/**
 * 面试题 10.09. 排序矩阵查找
 * <p>
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 *
 * @author weijiaduo
 * @since 2024/1/5
 */
public class SearchMatrix {

    /**
     * 思路：排除法
     * <p>
     * 当 target > m[i][j] 时，有两种走向 i+1 和 j+1
     * <p>
     * 当 target < m[i][j] 时，有两种走向 i-1 和 j-1
     * <p>
     * 但是如果从左下角（右上角亦可）开始遍历，
     * <p>
     * 因为 i+1 和 j-1 会超出范围，所以就能够直接排除这两种情况
     * <p>
     * 只剩下 j+1 和 i-1 的情况
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了60.10% 的Java用户
     * 内存消耗:44.9 MB,击败了94.58% 的Java用户
     */
    @TestCase(input = {"[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", "5",
            "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", "20"},
            output = {"true", "false"})
    public boolean except(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

}

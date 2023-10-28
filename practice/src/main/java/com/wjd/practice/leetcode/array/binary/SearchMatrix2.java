package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

/**
 * 240. 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * <p>
 * 该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * <p>
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10⁹ <= matrix[i][j] <= 10⁹
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10⁹ <= target <= 10⁹
 *
 * @author weijiaduo
 * @since 2023/6/10
 */
public class SearchMatrix2 {

    /**
     * 思路：Z形走位，从左下角开始，大于当前值走右边，小于当前值走上边
     * <p>
     * 复杂度：时间 O(m + n)，空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了98.05% 的Java用户
     * 内存消耗:48 MB,击败了33.15% 的Java用户
     */
    @TestCase(input = {"[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", "5",
            "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", "20"},
            output = {"true", "false"})
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = m - 1;
        while (y >= 0 && x < n) {
            if (matrix[y][x] == target) {
                return true;
            }
            if (matrix[y][x] < target) {
                // 往右走
                x++;
            } else {
                // 往上走
                y--;
            }
        }
        return false;
    }

}

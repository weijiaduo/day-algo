package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

/**
 * 74. 搜索矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 * <p>
 * 该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * <p>
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10⁴ <= matrix[i][j], target <= 10⁴
 *
 * @since 2022/6/4
 */
public class SearchSortedMatrix {

    /**
     * 思路：二维二分查找法，先做行二分，再做列二分
     * <p>
     * 复杂度：时间 O(log(mn)) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了65.12% 的Java用户
     */
    @TestCase(input = {"[[1,3,5,7],[10,11,16,20],[23,30,34,60]]", "3",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]", "13"},
            output = {"true", "false"})
    public boolean searchRowCol(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = -1;
        int i = 0, j = m - 1;
        while (i <= j) {
            int d = i + (j - i) / 2;
            if (matrix[d][0] <= target && target <= matrix[d][n - 1]) {
                row = d;
                break;
            }
            if (matrix[d][0] > target) {
                j = d - 1;
            } else {
                i = d + 1;
            }
        }
        if (row < 0) {
            return false;
        }
        i = 0;
        j = n - 1;
        while (i <= j) {
            int d = i + (j - i) / 2;
            if (matrix[row][d] == target) {
                return true;
            }
            if (matrix[row][d] > target) {
                j = d - 1;
            } else {
                i = d + 1;
            }
        }
        return false;
    }

    /**
     * 思路：一维二分查找法，把二维数组看成一维数组，直接进行二分法
     * <p>
     * 复杂度：时间 O(log(mn)) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了77.84% 的Java用户
     */
    @TestCase(input = {"[[1,3,5,7],[10,11,16,20],[23,30,34,60]]", "3",
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]", "13"},
            output = {"true", "false"})
    public boolean searchArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n - 1;
        while (i <= j) {
            int d = i + (j - i) / 2;
            int r = d / n;
            int c = d % n;
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                j = d - 1;
            } else {
                i = d + 1;
            }
        }
        return false;
    }

}

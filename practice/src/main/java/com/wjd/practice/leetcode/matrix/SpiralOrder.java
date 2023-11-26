package com.wjd.practice.leetcode.matrix;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @since 2022/5/31
 */
public class SpiralOrder {

    /**
     * 思路：使用四条边夹住未遍历的二维数组元素
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了55.37% 的Java用户
     */
    @TestCase(input = {"[[1,2,3],[4,5,6],[7,8,9]]", "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]"},
            output = {"[1,2,3,6,9,8,7,4,5]", "[1,2,3,4,8,12,11,10,9,5,6,7]"})
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int rows = matrix.length, cols = matrix[0].length;
        // 上下左右边界
        int l = 0, r = cols - 1, u = 0, d = rows - 1;
        while (l <= r && u <= d) {
            // 从左到右
            for (int i = l; u <= d && i <= r; i++) {
                ans.add(matrix[u][i]);
            }
            u++;

            // 从上到下
            for (int i = u; l <= r && i <= d; i++) {
                ans.add(matrix[i][r]);
            }
            r--;

            // 从右到左
            for (int i = r; u <= d && i >= l; i--) {
                ans.add(matrix[d][i]);
            }
            d--;

            // 从下到上
            for (int i = d; l <= r && i >= u; i--) {
                ans.add(matrix[i][l]);
            }
            l++;
        }
        return ans;
    }

}

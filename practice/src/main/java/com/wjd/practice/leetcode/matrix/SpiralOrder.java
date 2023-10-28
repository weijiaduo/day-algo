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
        int top = -1, bottom = matrix.length;
        int left = -1, right = matrix[0].length;
        while (top + 1 < bottom && left + 1 < right) {
            // 上边
            top++;
            for (int i = left + 1; i < right && top < bottom; i++) {
                ans.add(matrix[top][i]);
            }
            // 右边
            right--;
            for (int i = top + 1; i < bottom && left < right; i++) {
                ans.add(matrix[i][right]);
            }
            // 下边
            bottom--;
            for (int i = right - 1; i > left && top < bottom; i--) {
                ans.add(matrix[bottom][i]);
            }
            // 左边
            left++;
            for (int i = bottom - 1; i > top && left < right; i--) {
                ans.add(matrix[i][left]);
            }
        }
        return ans;
    }

}

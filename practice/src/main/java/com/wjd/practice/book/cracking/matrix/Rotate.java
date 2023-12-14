package com.wjd.practice.book.cracking.matrix;

import com.wjd.practice.TestCase;

/**
 * 面试题 01.07. 旋转矩阵
 * <p>
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author weijiaduo
 * @since 2023/12/14
 */
public class Rotate {

    /**
     * 思路：原地翻转，按照旋转顺序，一次性更新4条边的点，避免用额外的空间
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了58.52% 的Java用户
     */
    @TestCase(input = {"[[1,2,3],[4,5,6],[7,8,9]]", "[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]"},
            output = {"[[7,4,1],[8,5,2],[9,6,3]]", "[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]"})
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            // 遍历一行，但四个角不算在内，因为是共用的
            for (int j = i; j < n - 1 - i; j++) {
                int x = matrix[i][j];
                // 左边 转 上边
                matrix[i][j] = matrix[n - 1 - j][i];
                // 下边 转 左边
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                // 右边 转 下边
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // 上边 转 右边
                matrix[j][n - 1 - i] = x;
            }
        }
    }

    /**
     * 对角线翻转
     * <p>
     * 思路：旋转可以用一次水平翻转和一次对角线翻转替代
     * <p>
     * 好家伙，这个官方思路很有意思~~
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了94.24% 的Java用户
     */
    @TestCase(input = {"[[1,2,3],[4,5,6],[7,8,9]]", "[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]"},
            output = {"[[7,4,1],[8,5,2],[9,6,3]]", "[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]"})
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}

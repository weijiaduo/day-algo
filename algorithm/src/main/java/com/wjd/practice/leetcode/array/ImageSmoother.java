package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-06-06
 * <p>
 * 661. 图片平滑器
 * <p>
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度(向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * <p>
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 */
public class ImageSmoother implements Solution<int[][]> {

    @Override
    public int[][] solve(Object ...args) {
        int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result = imageSmoother(img);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 图片平滑器
     *
     * @param img 二维数组
     * @return 新的二维数组
     */
    private int[][] imageSmoother(int[][] img) {
        if (img.length == 0) {
            return new int[0][];
        }
        int rows = img.length, cols = img[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = getAvgRect(img, i, j);
            }
        }
        return result;
    }

    /**
     * 获取区域的平均值
     *
     * @param img 二维数组
     * @param i   横坐标
     * @param j   纵坐标
     * @return 平均值
     */
    private int getAvgRect(int[][] img, int i, int j) {
        int sum = 0, count = 0;
        int rows = img.length, cols = img[0].length;
        for (int m = i - 1; m <= i + 1; m++) {
            if (m < 0 || m >= rows) {
                continue;
            }
            for (int n = j - 1; n <= j + 1; n++) {
                if (n < 0 || n >= cols) {
                    continue;
                }
                count++;
                sum += img[m][n];
            }
        }
        return sum / count;
    }
}

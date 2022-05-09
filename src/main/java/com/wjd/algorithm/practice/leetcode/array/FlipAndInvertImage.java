package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-06-09
 * <p>
 * 832. 翻转图像
 * <p>
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 */
public class FlipAndInvertImage implements Solution<int[][]> {

    @Override
    public int[][] solve(Object args) {
        int[][] image = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] result = flipAndInvertImage(image);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 翻转图像
     *
     * @param image 图像矩阵
     * @return 翻转后的矩阵
     */
    public int[][] flipAndInvertImage(int[][] image) {
        if (image.length == 0) {
            return image;
        }
        int rows = image.length;
        int cols = image[0].length;
        int halfCols = (cols + 1) >> 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < halfCols; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][cols - j - 1] ^ 1;
                image[i][cols - j - 1] = temp ^ 1;
            }
        }
        return image;
    }

}

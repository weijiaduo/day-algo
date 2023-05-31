package com.wjd.practice.leetcode.array.simulate;

/**
 * 832. 翻转图像
 * <p>
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * <p>
 * 例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。
 * <p>
 * 例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 * <p>
 * 示例 1：
 * <p>
 * 输入：image = [[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * @since 2021-06-09
 */
public class FlipAndInvertImage {

    /**
     * 思路：直接模拟，按照题目要求进行翻转
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.5 MB,击败了21.96% 的Java用户
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

package com.wjd.practice.book.cracking.matrix;

import com.wjd.practice.TestCase;

/**
 * 面试题 08.10. 颜色填充
 * <p>
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * <p>
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * <p>
 * 提示：
 * <p>
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 *
 * @author weijiaduo
 * @since 2024/1/1
 */
public class FloodFill {

    /**
     * 思路：深度优先搜索
     * <p>
     * 遍历到周围每个位置，然后就设置新颜色
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.5 MB,击败了6.79% 的Java用户
     */
    @TestCase(input = {"[[1,1,1],[1,1,0],[1,0,1]]", "1", "1", "2"},
            output = {"[[2,2,2],[2,2,0],[2,0,1]]"})
    public int[][] dfs(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        if (sr < 0 || sr >= m || sc < 0 || sc >= n) {
            return image;
        }
        return dfs(image, sr, sc, image[sr][sc], newColor);
    }

    /**
     * 深度优先搜索
     *
     * @param image    矩阵
     * @param sr       横坐标
     * @param sc       纵坐标
     * @param oldColor 旧颜色
     * @param newColor 新颜色
     * @return 新矩阵
     */
    public int[][] dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int m = image.length, n = image[0].length;
        if (sr < 0 || sr >= m || sc < 0 || sc >= n) {
            return image;
        }
        if (image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return image;
        }

        // 填充颜色
        image[sr][sc] = newColor;

        // 右上左下
        dfs(image, sr, sc + 1, oldColor, newColor);
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
        dfs(image, sr + 1, sc, oldColor, newColor);

        return image;
    }

}

package com.wjd.practice.leetcode.array.section;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1637. 两点之间不包含任何点的最宽垂直区域
 * <p>
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 * <p>
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 *
 * @author weijiaduo
 * @since 2023/3/30
 */
public class MaxWidthOfVerticalArea {

    /**
     * 思路：直接按横坐标排序，取相邻横坐标的间距最大值
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(nlogn)
     * <p>
     * 执行耗时:45 ms,击败了23.02% 的Java用户
     * 内存消耗:68.6 MB,击败了64.75% 的Java用户
     *
     * @param points 点
     * @return 最宽垂直区域
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int maxWidth = 0;
        int n = points.length;
        for (int i = 1; i < n; i++) {
            maxWidth = Math.max(maxWidth, points[i][0] - points[i - 1][0]);
        }
        return maxWidth;
    }

}

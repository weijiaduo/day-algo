package com.wjd.practice.leetcode.array.section;

import java.util.*;

/**
 * 850. 矩形面积2
 * <p>
 * 我们给出了一个（轴对齐的）二维矩形列表 rectangles 。
 * <p>
 * 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形 i 左下角的坐标，
 * (xi1, yi1) 是该矩形 左下角 的坐标，
 * (xi2, yi2) 是该矩形 右上角 的坐标。
 * <p>
 * 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。
 * <p>
 * 返回 总面积 。因为答案可能太大，返回
 * 10⁹ + 7 的 模 。
 * <p>
 * 输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * 输出：6
 * 解释：如图所示，三个矩形覆盖了总面积为6的区域。
 * 从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
 * 从(1,0)到(2,3)，三个矩形都重叠。
 *
 * @author weijiaduo
 * @since 2022/9/17
 */
public class RectangleArea {

    /**
     * 思路：以平行于 y 轴的直线作为扫描线，累计扫描线从上一个左/右边界到下一个左/右边界扫过的面积
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了38.44% 的Java用户
     * 内存消耗:40.7 MB,击败了77.55% 的Java用户
     *
     * @param rectangles 矩形
     * @return 面积
     */
    private int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        if (n <= 0) {
            return 0;
        }

        final int MOD = 1000000007;
        long ans = 0;

        // 统计不同的上下边界值
        Set<Integer> yRects = new HashSet<>();
        for (int[] rect : rectangles) {
            // 下边界
            yRects.add(rect[1]);
            // 上边界
            yRects.add(rect[3]);
        }
        // 对上下边界进行排序，从小到大
        List<Integer> yBounds = new ArrayList<>(yRects);
        yBounds.sort((a, b) -> a - b);

        // 统计左右边界值
        List<int[]> xBounds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 左边界
            xBounds.add(new int[]{rectangles[i][0], i, 1});
            // 右边界
            xBounds.add(new int[]{rectangles[i][2], i, -1});
        }
        // 对左右边界进行排序，从小到大
        xBounds.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // 以平行于 y 轴的直线作为扫描线，从左往右扫描
        // 扫描线被 m 条上下边界分割成 m-1 个有效扫描区域
        // 每个区域的范围是 yBounds[i + 1] - yBounds[i]
        // 记录每个区域扫到的矩形数量
        int m = yBounds.size();
        int[] segments = new int[m - 1];
        int i = 0, size = xBounds.size();
        while (true) {
            // 当前扫描线的位置坐标
            int yScan = xBounds.get(i)[0];

            // 增量统计扫描线扫到的矩形边界
            for (; i < size; i++) {
                int[] x = xBounds.get(i);
                if (x[0] != yScan) {
                    break;
                }

                // 检查当前矩形在哪个有效扫描区域内
                int[] rect = rectangles[x[1]];
                int yBottom = rect[1], yTop = rect[3];
                for (int k = 0; k < m - 1; k++) {
                    if (yBottom <= yBounds.get(k) &&
                            yBounds.get(k + 1) <= yTop) {
                        // 左边界+1，右边界-1
                        segments[k] += x[2];
                    }
                }
            }
            // 后面已经没有了
            if (i >= size) {
                break;
            }

            // 当前扫描线扫过的距离，即到最近两条边界的间距
            int xWidth = xBounds.get(i)[0] - xBounds.get(i - 1)[0];
            // 当前扫描线扫到的矩形高度总和
            int yHeight = 0;
            for (int k = 0; k < m - 1; k++) {
                // segments[k] > 0 表示该区域内扫到了矩形
                if (segments[k] > 0) {
                    // 矩形高度
                    yHeight += yBounds.get(k + 1) - yBounds.get(k);
                }
            }

            // 当前扫描线扫到下一条边界前的面积
            ans += (long) xWidth * yHeight;
        }
        return (int) (ans % MOD);
    }

    /**
     * 思路：
     * <p>
     * 以每个左右边界所在直线作为扫描线，累计每条扫描线扫过的面积
     * <p>
     * 扫描线扫过的面积 = 相邻 2 条扫描线的间距
     * <p>
     * 复杂度：时间 O(n^2logn) 空间 O(n)
     * <p>
     * 执行耗时:9 ms,击败了45.58% 的Java用户
     * 内存消耗:40.9 MB,击败了58.50% 的Java用户
     *
     * @param rectangles 矩形
     * @return 面积
     */
    private int rectangleArea2(int[][] rectangles) {
        int n = rectangles.length;
        if (n <= 0) {
            return 0;
        }

        final int MOD = 1000000007;
        long ans = 0;

        // 统计所有的左右边界，作为扫描线
        List<Integer> scanLines = new ArrayList<>(2 * n);
        for (int[] rect : rectangles) {
            scanLines.add(rect[0]);
            scanLines.add(rect[2]);
        }
        Collections.sort(scanLines);

        // 以每条边界所在直线作为扫描线，每条扫描线扫过的距离是最近两条扫描线的间距
        int size = scanLines.size();
        for (int i = 0; i < size - 1; i++) {
            int yScanLine = scanLines.get(i);
            // 当前扫描线扫过的距离 = 2条扫描线的间距
            int width = scanLines.get(i + 1) - yScanLine;
            // 相同的扫描线只保留最后一条
            if (width == 0) {
                continue;
            }

            // 找出当前扫描线扫中的矩形，并统计它们的上下边界
            List<int[]> yBounds = new ArrayList<>();
            for (int[] rect : rectangles) {
                int xLeft = rect[0], xRight = rect[2];
                // 矩形的右边界已经不算是在扫描范围内了
                if (xLeft <= yScanLine && yScanLine < xRight) {
                    yBounds.add(new int[]{rect[1], rect[3]});
                }
            }

            // 算出上下边界实际的叠加后的累计高度
            int height = 0, lastTop = -1;
            yBounds.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            for (int[] yBound : yBounds) {
                if (yBound[0] > lastTop) {
                    // 矩形无重叠，直接加上当前矩形高度
                    height += yBound[1] - yBound[0];
                    lastTop = yBound[1];
                } else if (yBound[1] > lastTop) {
                    // 矩形有重叠，并且当前矩形高度更高
                    height += yBound[1] - lastTop;
                    lastTop = yBound[1];
                }
            }

            // 当前扫描线扫过的面积
            ans += (long) width * height;
        }

        return (int) (ans % MOD);
    }

}

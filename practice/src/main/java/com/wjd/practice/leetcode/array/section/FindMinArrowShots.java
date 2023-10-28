package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * <p>
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
 * <p>
 * 墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。
 * <p>
 * 你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
 * <p>
 * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足xstart ≤ x ≤ xend，则该气球会被 引爆 。
 * <p>
 * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * <p>
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * <p>
 * 提示:
 * <p>
 * 1 <= points.length <= 10⁵
 * points[i].length == 2
 * -2³¹ <= xstart < xend <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2023/10/19
 */
public class FindMinArrowShots {

    /**
     * 思路：排序，按照左端点升序、右端点升序排序
     * <p>
     * 然后扫描，将重叠的区间一次性引爆
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     * <p>
     * 执行耗时:55 ms,击败了64.81% 的Java用户
     * 内存消耗:74.4 MB,击败了61.98% 的Java用户
     */
    @TestCase(input = {"[[10,16],[2,8],[1,6],[7,12]]",
            "[[1,2],[3,4],[5,6],[7,8]]",
            "[[1,2],[2,3],[3,4],[4,5]]",
            "[[-2147483646,-2147483645],[2147483646,2147483647]]"},
            output = {"2", "4", "2", "2"})
    public int sort(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int n = points.length;
        int r = points[0][1];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (points[i][0] > r) {
                // 无重叠
                r = points[i][1];
                cnt++;
            } else {
                // 有重叠
                r = Math.min(points[i][1], r);
            }
        }
        return cnt;
    }

    /**
     * 思路：贪心，按右端点升序排序
     * <p>
     * 射箭的位置，始终选择右端点，这样可以保证最大重叠数量
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     * <p>
     * 执行耗时:58 ms,击败了45.26% 的Java用户
     * 内存消耗:75 MB,击败了8.75% 的Java用户
     */
    @TestCase(input = {"[[10,16],[2,8],[1,6],[7,12]]",
            "[[1,2],[3,4],[5,6],[7,8]]",
            "[[1,2],[2,3],[3,4],[4,5]]",
            "[[-2147483646,-2147483645],[2147483646,2147483647]]"},
            output = {"2", "4", "2", "2"})
    public int greedy(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // 按右端点升序排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int n = points.length;
        int r = points[0][1];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (points[i][0] > r) {
                // 无重叠
                r = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }

}

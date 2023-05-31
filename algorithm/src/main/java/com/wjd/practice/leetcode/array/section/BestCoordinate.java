package com.wjd.practice.leetcode.array.section;

/**
 * 1620. 网络信号最好的坐标
 * <p>
 * 给你一个数组 towers 和一个整数 radius 。
 * <p>
 * 数组 towers 中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信
 * 号强度参数为 qi 。
 * <p>
 * 所有坐标都是在 X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
 * <p>
 * 整数 radius 表示一个塔 能到达 的 最远距离 。
 * <p>
 * 如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。
 * <p>
 * 在这个范围以外信号会很微弱，所以 radius 以外的距离该塔是 不能到达的 。
 * <p>
 * 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。
 * <p>
 * 一个坐标的 信号强度 是所有能到达 该坐标的塔的信号强度之和。
 * <p>
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点 (cx, cy) 。
 * <p>
 * 如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 * <p>
 * 注意：
 * <p>
 * 坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小，需满足以下条件之一：
 * <p>
 * 要么 x1 < x2 ，
 * 要么 x1 == x2 且 y1 < y2 。
 * <p>
 * ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。
 * <p>
 * <p>
 * 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
 * 输出：[2,1]
 * 解释：
 * 坐标 (2, 1) 信号强度之和为 13
 * - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
 * - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
 * - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
 * 没有别的坐标有更大的信号强度。
 *
 * @author weijiaduo
 * @since 2022/11/2
 */
public class BestCoordinate {

    /**
     * 思路：信号最强的点必定在所有信号塔范围的内部
     * <p>
     * 如果在外部，肯定有一个对称的点在内部，可以达到外部点的信号强度，所以最强信号还是在内部
     * <p>
     * 执行耗时:31 ms,击败了58.95% 的Java用户
     * 内存消耗:42.2 MB,击败了5.27% 的Java用户
     */
    public int[] solve(int[][] towers, int radius) {
        // 收集信号的范围
        int l = Integer.MAX_VALUE, r = 0, t = 0, b = Integer.MAX_VALUE;
        for (int[] tower : towers) {
            l = Math.min(l, tower[0]);
            r = Math.max(r, tower[0]);
            t = Math.max(t, tower[1]);
            b = Math.min(b, tower[1]);
        }
        // ？？？凭什么信号值为 0 时答案是 [0,0]
        l = b = 0;

        // 找出最强信号的位置
        int maxQuality = -1;
        int[] maxP = null;
        int r2 = radius * radius;
        for (int i = l; i <= r; i++) {
            for (int j = b; j <= t; j++) {
                int[] p = new int[]{i, j};
                int q = quality(towers, p, r2);
                if (q > maxQuality) {
                    maxQuality = q;
                    maxP = p;
                }
            }
        }
        return maxP;
    }

    /**
     * 当前位置的信号强度
     */
    private int quality(int[][] towers, int[] p, int r2) {
        int sum = 0;
        for (int[] tower : towers) {
            int d = distance(tower, p);
            if (d <= r2) {
                sum += (int) Math.floor(tower[2] / (1 + Math.sqrt(d)));
            }
        }
        return sum;
    }

    /**
     * 两点距离
     */
    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

}

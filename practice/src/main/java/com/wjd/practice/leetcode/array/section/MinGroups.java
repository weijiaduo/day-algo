package com.wjd.practice.leetcode.array.section;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 第 310 场周赛
 * <p>
 * 6178. 将区间分为最少组数
 * <p>
 * 给你一个二维整数数组intervals，其中intervals[i] = [lefti, righti]表示 闭区间[lefti, righti]。
 * <p>
 * 你需要将intervals 划分为一个或者多个区间组，每个区间 只属于一个组，且同一个组中任意两个区间 不相交。
 * <p>
 * 请你返回 最少需要划分成多少个组。
 * <p>
 * 如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交的。比方说区间[1, 5] 和[5, 8]相交。
 * <p>
 * 输入：intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
 * 输出：3
 * 解释：我们可以将区间划分为如下的区间组：
 * - 第 1 组：[1, 5] ，[6, 8] 。
 * - 第 2 组：[2, 3] ，[5, 10] 。
 * - 第 3 组：[1, 10] 。
 * 可以证明无法将区间划分为少于 3 个组。
 *
 * @author weijiaduo
 * @since 2022/9/11
 */
public class MinGroups {

    /**
     * 思路：贪心算法，优先往右区间小的分组放置新的区间
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     *
     * @param intervals 区间数组
     * @return 最小分割数
     */
    private int minGroup(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // 按组区间的最大值排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (queue.isEmpty()) {
                queue.offer(interval[1]);
            } else if (interval[0] <= queue.peek()) {
                // 所有分组都放不下，新开一组
                queue.offer(interval[1]);
            } else {
                // 放到第一组
                queue.poll();
                queue.offer(interval[1]);
            }
        }

        return queue.size();
    }

}

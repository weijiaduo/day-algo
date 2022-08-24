package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.*;

/**
 * 757. 设置交集大小至少为2
 * <p>
 * 一个整数区间 [a, b] ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
 * <p>
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * <p>
 * 输出这个最小集合S的大小。
 * <p>
 * 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * 输出: 3
 * 解释:
 * 考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
 * 且这是S最小的情况，故我们输出3。
 *
 * @author weijiaduo
 * @since 2022/7/22
 */
public class IntersectionSizeTwo implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        int result = intersectionSizeTwo(intervals);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：贪心，先排序，从后往前寻找最小交集，尽量选区间前面的数字，因为它有可能和前面区间产生交集
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:18 ms,击败了38.54% 的Java用户
     * 内存消耗:42.3 MB,击败了89.58% 的Java用户
     *
     * @param intervals 区间
     * @return 最小交集的大小
     */
    private int intersectionSizeTwo(int[][] intervals) {
        Set<Integer> set = new TreeSet<>();
        int k = 2;

        // 区间起始位置小的排前面
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int n = intervals.length;
        for (int i = n - 1; i >= 0; i--) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            int remains = k;

            // 当前集合和当前区间已有的交集
            Set<Integer> covers = new HashSet<>();
            for (int num : set) {
                if (remains == 0 || num > end) {
                    break;
                }
                covers.add(num);
                remains--;
            }

            // 从前往后寻找，补充剩余的交集
            for (int j = start; remains > 0 && j <= end; j++) {
                if (covers.contains(j)) {
                    continue;
                }
                set.add(j);
                remains--;
            }
        }
        return set.size();
    }

}

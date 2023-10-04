package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * <p>
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10⁴
 *
 * @since 2022/5/31
 */
public class MergeIntervals {

    /**
     * 思路：区间按照左端点排序，然后遍历一遍区间，一路判断能否合并即可
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了98.01% 的Java用户
     * 内存消耗:46.3 MB,击败了39.35% 的Java用户
     */
    @TestCase(input = {"[[1,3],[2,6],[8,10],[15,18]]", "[[1,4],[4,5]]"},
            output = {"[[1,6],[8,10],[15,18]]", "[[1,5]]"})
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 区间按照左端点从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int n = intervals.length;
        List<int[]> newIntervals = new ArrayList<>(n);
        int[] merge = intervals[0];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            // 排序后已保证 merge[0] <= interval[0]
            if (interval[0] > merge[1]) {
                // 两个区间无法合并
                newIntervals.add(merge);
                merge = interval;
            } else {
                // 两个区间可以合并，只需要更新最大值即可
                merge[1] = Math.max(merge[1], interval[1]);
            }
        }
        // 添加最后一个区间
        newIntervals.add(merge);
        return newIntervals.toArray(new int[0][]);
    }
}

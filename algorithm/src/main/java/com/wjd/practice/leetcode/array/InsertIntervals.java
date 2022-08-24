package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * @since 2022/5/31
 */
public class InsertIntervals implements Solution<int[][]> {

    @Override
    public int[][] solve(Object... args) {
        int[][] intervals = {};
        int[] newInterval = {2,5};
        int[][] result = insert(intervals, newInterval);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 思路：找到可以插入的元素，插入它的前面，并判断是否可以合并
     *
     * 执行耗时:1 ms,击败了87.02% 的Java用户
     * 内存消耗:43.4 MB,击败了78.15% 的Java用户
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean inserted = false;
        int length = intervals.length;
        List<int[]> newIntervals = new ArrayList<>(length + 1);
        for (int[] interval : intervals) {
            // 没有交集，在当前区间之后，寻找下一个插入点
            if (inserted || newInterval[0] > interval[1]) {
                newIntervals.add(interval);
                continue;
            }

            // 没有交集，在当前区间之前，刚好插入空隙
            if (newInterval[1] < interval[0]) {
                newIntervals.add(newInterval);
                newIntervals.add(interval);
                // 标记已插入，后面的不用判断了
                inserted = true;
                continue;
            }

            // 有交集，与当前区间合并
            newInterval[0] = Math.min(newInterval[0], interval[0]);
            newInterval[1] = Math.max(newInterval[1], interval[1]);
        }

        // 没有插入，说明它是在最后一个追加的
        if (!inserted) {
            newIntervals.add(newInterval);
        }

        return newIntervals.toArray(new int[0][]);
    }

}

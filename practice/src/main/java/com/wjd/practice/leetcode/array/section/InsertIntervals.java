package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 10⁵
 *
 * @since 2022/5/31
 */
public class InsertIntervals {

    /**
     * 思路：找到可以插入的元素，插入它的前面，并判断是否可以合并
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了87.02% 的Java用户
     * 内存消耗:43.4 MB,击败了78.15% 的Java用户
     */
    @TestCase(input = {"[[1,3],[6,9]]", "[2,5]",
            "[[1,2],[3,5],[6,7],[8,10],[12,16]]", "[4,8]",
            "[]", "[5,7]",
            "[[1,5]]", "[2,3]",
            "[[1,5]]", "[2,7]"},
            output = {"[[1,5],[6,9]]", "[[1,2],[3,10],[12,16]]", "[[5,7]]", "[[1,5]]", "[[1,7]]  "})
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>(n + 1);
        boolean inserted = false;
        for (int[] interval : intervals) {
            // 没有交集，在当前区间之后，寻找下一个插入点
            if (inserted || newInterval[0] > interval[1]) {
                list.add(interval);
                continue;
            }

            // 没有交集，在当前区间之前，刚好插入空隙
            if (newInterval[1] < interval[0]) {
                list.add(newInterval);
                list.add(interval);
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
            list.add(newInterval);
        }

        return list.toArray(new int[0][]);
    }

}

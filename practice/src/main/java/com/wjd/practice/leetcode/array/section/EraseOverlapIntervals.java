package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * <p>
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * <p>
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 示例 2:
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 示例 3:
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * 提示:
 * <p>
 * 1 <= intervals.length <= 10⁵
 * intervals[i].length == 2
 * -5 * 10⁴ <= starti < endi <= 5 * 10⁴
 *
 * @author weijiaduo
 * @since 2023/10/19
 */
public class EraseOverlapIntervals {

    /**
     * 思路：排序，对区间 start 进行升序，对 end 也是升序
     * <p>
     * 1. 如果区间 [i,j] 和 [x,y] 满足 i<=x && j>=y 则 去掉 [i,j] 区间
     * <p>
     * 2. 否则看谁的 end 更大，去掉更大的那个
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     * <p>
     * 执行耗时:73 ms,击败了8.12% 的Java用户
     * 内存消耗:93.9 MB,击败了80.13% 的Java用户
     */
    @TestCase(input = {"[[1,2],[2,3],[3,4],[1,3]]", "[ [1,2], [1,2], [1,2] ]", "[ [1,2], [2,3] ]"},
            output = {"1", "2", "0"})
    public int sort(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int ans = 0;
        int n = intervals.length;
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            // 区间没有重叠
            int[] cur = intervals[i];
            if (cur[0] >= prev[1]) {
                prev = cur;
                continue;
            }
            // 去掉右边界更大的
            if (cur[1] <= prev[1]) {
                prev = cur;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 思路：贪心，对右端点进行排序，优先取右端点小的区间
     * <p>
     * 优先取右端点小的区间，可以保证后面有更多的空间，因此可以保留更多区间
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     * <p>
     * 执行耗时:54 ms,击败了46.05% 的Java用户
     * 内存消耗:97.9 MB,击败了6.92% 的Java用户
     */
    @TestCase(input = {"[[1,2],[2,3],[3,4],[1,3]]", "[ [1,2], [1,2], [1,2] ]", "[ [1,2], [2,3] ]"},
            output = {"1", "2", "0"})
    public int greedy(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 按照右端点从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int n = intervals.length;
        int right = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                // 增加一个新区间
                cnt++;
                right = intervals[i][1];
            }
        }
        return n - cnt;
    }

}

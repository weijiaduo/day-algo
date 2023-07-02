package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <=10⁵
 * 0 <= heights[i] <= 10⁴
 *
 * @since 2022/6/7
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        return twiceLargestRectangleArea(heights);
    }

    /**
     * 官方题解
     * <p>
     * 思路：单调栈，递增单调栈
     * <p>
     * 矩形面积由 宽x高 得到，遍历每个点，固定高，然后向左右扩展宽
     * <p>
     * 扩展的要求是新点的高度不比基准点高度低，扩展方向是左右两边
     * <p>
     * 可以用2个单调栈来记录每个位置左右两边最近的比它矮的柱子高度
     * <p>
     * 然后就能快速计算出每个位置的宽度了
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:28 ms,击败了56.81% 的Java用户
     * 内存消耗:57.5 MB,击败了22.66% 的Java用户
     */
    @TestCase(input = {"[2,1,5,6,2,3]", "[2,4]"},
            output = {"10", "4"})
    private int twiceLargestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 左边界
        Deque<Integer> mos = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!mos.isEmpty() && heights[mos.peek()] >= heights[i]) {
                mos.pop();
            }
            left[i] = mos.isEmpty() ? -1 : mos.peek();
            mos.push(i);
        }

        // 右边界
        mos.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!mos.isEmpty() && heights[mos.peek()] >= heights[i]) {
                mos.pop();
            }
            right[i] = mos.isEmpty() ? n : mos.peek();
            mos.push(i);
        }

        // 计算最大值
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：单调栈，优化了遍历次数，遍历一次数组就能获取左右单调栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:20 ms,击败了83.24% 的Java用户
     * 内存消耗:57.7 MB,击败了19.64% 的Java用户
     */
    @TestCase(input = {"[2,1,5,6,2,3]", "[2,4]"},
            output = {"10", "4"})
    private int onceLargestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> mos = new ArrayDeque<>(n);
        for (int i = 0; i < n; ++i) {
            while (!mos.isEmpty() && heights[mos.peek()] >= heights[i]) {
                right[mos.peek()] = i;
                mos.pop();
            }
            left[i] = mos.isEmpty() ? -1 : mos.peek();
            mos.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int area = (right[i] - left[i] - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }

}

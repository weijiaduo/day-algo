package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.segmenttree.LinkSegmentTree;

import java.util.Map;
import java.util.TreeMap;

/**
 * 732. 我的日程安排表3
 * <p>
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 * <p>
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * <p>
 *
 * @since 2022/6/6
 */
public class MyCalendarThree implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] values = {{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19}, {3, 14}, {25, 39}, {6, 19}};
        for (int[] value : values) {
            int result = book(value[0], value[1]);
            System.out.print(result);
            System.out.print(" ");
        }
        System.out.println();
        return null;
    }

    public MyCalendarThree() {
        // 方法 1
        cnt = new TreeMap<>();
        // 方法 2
        segmentTree = new MaxLinkSegmentTree(low, high);
    }

    /**
     * 看来是没理解清楚题意
     * <p>
     * 执行耗时:99 ms,击败了28.23% 的Java用户
     * 内存消耗:42 MB,击败了51.36% 的Java用户
     */
    public int book(int start, int end) {
        return segmentTreeBook(start, end);
    }

    private TreeMap<Integer, Integer> cnt;

    /**
     * 思路：哈希表法，哈希记录区间每个值的次数
     *
     * @param start [start, end)
     * @param end   [start, end)
     * @return 最大预订次数
     */
    private int hashBook(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }

    final int low = 0;
    final int high = (int) 1e9;
    MaxLinkSegmentTree segmentTree;

    /**
     * 思路：区间最大值线段树，节点保存区间最大值
     * <p>
     * 执行耗时:22 ms,击败了93.11% 的Java用户
     * 内存消耗:43.3 MB,击败了28.65% 的Java用户
     *
     * @param start [start, end)
     * @param end   [start, end)
     * @return true可预订/false不可预订
     */
    private int segmentTreeBook(int start, int end) {
        segmentTree.update(start, end - 1, 1);
        return segmentTree.query(low, high);
    }

    static class MaxLinkSegmentTree extends LinkSegmentTree {

        public MaxLinkSegmentTree(int low, int high) {
            super(low, high);
        }

        /**
         * @implNote 查询指定区间最大值
         */
        @Override
        protected int mergeQuery(Node node, int start, int end, Integer lVal, Integer rVal) {
            int max = low - 1;
            if (lVal != null) {
                max = lVal;
            }
            if (rVal != null) {
                max = Math.max(rVal, max);
            }
            return max;
        }

        /**
         * @implNote 向上更新区间最大值
         */
        @Override
        protected void writeUp(Node node, int start, int end) {
            node.val = Math.max(node.left.val, node.right.val);
        }

        /**
         * @implNote 向下更新区间值，同时更新懒惰标记
         */
        @Override
        protected void writeDown(Node node, int start, int end, int val) {
            node.val += val;
            node.add += val;
        }

    }

}

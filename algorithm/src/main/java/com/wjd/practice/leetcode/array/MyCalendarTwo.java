package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.segmenttree.LinkSegmentTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 731. 我的日程安排2
 * <p>
 * 实现一个 MyCalendar 类来存放你的日程安排。
 * <p>
 * 如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar 有一个 book(int start, int end)方法。
 * <p>
 * 它意味着在 start 到 end 时间内增加一个日程安排，
 * <p>
 * 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < end。
 * <p>
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 * <p>
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
 * <p>
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * @author weijiaduo
 * @since 2022/7/19
 */
public class MyCalendarTwo implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(25, 35));
        System.out.println(myCalendarTwo.book(26, 32));
        System.out.println(myCalendarTwo.book(25, 32));
        System.out.println(myCalendarTwo.book(18, 26));
        System.out.println(myCalendarTwo.book(40, 45));
        System.out.println(myCalendarTwo.book(19, 26));
        System.out.println(myCalendarTwo.book(48, 50));
        System.out.println(myCalendarTwo.book(1, 6));
        System.out.println(myCalendarTwo.book(46, 50));
        System.out.println(myCalendarTwo.book(11, 18));
        return null;
    }

    /**
     * 打个卡
     * <p>
     * 执行耗时:365 ms,击败了8.86% 的Java用户
     * 内存消耗:52.1 MB,击败了5.04% 的Java用户
     */
    public MyCalendarTwo() {
        // 方法 1
        tree = new HashMap<>();
        // 方法 2
        segmentTree = new MaxLinkSegmentTree(low, high);
    }

    public boolean book(int start, int end) {
        // return hashBook(start, end);
        return segmentTreeBook(start, end);
    }

    Map<Integer, int[]> tree;

    private boolean hashBook(int start, int end) {
        update(start, end - 1, 1, 0, 1000000000, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update(start, end - 1, -1, 0, 1000000000, 1);
            return false;
        }
        return true;
    }

    private void update(int start, int end, int val, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        tree.putIfAbsent(idx, new int[2]);
        if (start <= l && r <= end) {
            tree.get(idx)[0] += val;
            tree.get(idx)[1] += val;
        } else {
            int mid = (l + r) >> 1;
            update(start, end, val, l, mid, 2 * idx);
            update(start, end, val, mid + 1, r, 2 * idx + 1);
            tree.putIfAbsent(2 * idx, new int[2]);
            tree.putIfAbsent(2 * idx + 1, new int[2]);
            tree.get(idx)[0] = tree.get(idx)[1] + Math.max(tree.get(2 * idx)[0], tree.get(2 * idx + 1)[0]);
        }
    }

    final int low = 0;
    final int high = (int) 1e9;
    MaxLinkSegmentTree segmentTree;

    /**
     * 思路：区间和线段树，节点保存区间最大值，0为未预订，1为已预订1个，2为已预订2个
     * <p>
     * 执行耗时:51 ms,击败了84.36% 的Java用户
     * 内存消耗:44.5 MB,击败了27.50% 的Java用户
     *
     * @param start [start, end)
     * @param end   [start, end)
     * @return true可预订/false不可预订
     */
    private boolean segmentTreeBook(int start, int end) {
        int sum = segmentTree.query(start, end - 1);
        if (sum < 2) {
            segmentTree.update(start, end - 1, 1);
            return true;
        } else {
            return false;
        }
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

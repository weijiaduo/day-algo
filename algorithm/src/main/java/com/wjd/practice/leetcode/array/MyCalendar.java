package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.segmenttree.SumLinkSegmentTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表
 * <p>
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * <p>
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < end 。
 * <p>
 * 实现 MyCalendar 类：
 * <p>
 * MyCalendar() 初始化日历对象。
 * <p>
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。
 * <p>
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 *
 * @author weijiaduo
 * @since 2022/7/5
 */
public class MyCalendar implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
        return null;
    }

    public MyCalendar() {
        // 方法 1
        books = new ArrayList<>();
        // 方法 2
        segmentTree = new SumLinkSegmentTree(low, high);
    }

    public boolean book(int start, int end) {
        // return sortBook(start, end);
        return segmentTreeBook(start, end);
    }

    List<int[]> books;

    /**
     * 思路：维护有序列表，每次插入遍历有序列表，插到指定位置里面
     *
     * @param start [start, end)
     * @param end   [start, end)
     * @return true可预订/false不可预订
     */
    private boolean sortBook(int start, int end) {
        int i = 0;
        for (; i < books.size(); i++) {
            int[] book = books.get(i);
            if (book[1] <= start) {
                continue;
            }
            break;
        }
        if (i < books.size()) {
            int[] book = books.get(i);
            if (book[0] < end) {
                // 有交叉冲突
                return false;
            }
        }
        books.add(i, new int[]{start, end});
        return true;
    }

    final int low = 0;
    final int high = (int) 1e9;
    SumLinkSegmentTree segmentTree;

    /**
     * 线段树，节点保存区间和，区间和为0时表示未被预订
     * <p>
     * 执行耗时:54 ms,击败了56.87% 的Java用户
     * 内存消耗:48.5 MB,击败了9.69% 的Java用户
     *
     * @param start [start, end)
     * @param end   [start, end)
     * @return true可预订/false不可预订
     */
    private boolean segmentTreeBook(int start, int end) {
        int sum = segmentTree.query(start, end - 1);
        if (sum == 0) {
            segmentTree.update(start, end - 1, 1);
        }
        return sum == 0;
    }

}

package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 731. 我的日程安排2
 *
 * @author weijiaduo
 * @since 2022/7/19
 */
public class MyCalendarTwo implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        return null;
    }

    Map<Integer, int[]> tree;

    /**
     * 打个卡
     *
     * 执行耗时:365 ms,击败了8.86% 的Java用户
     * 内存消耗:52.1 MB,击败了5.04% 的Java用户
     */
    public MyCalendarTwo() {
        tree = new HashMap<Integer, int[]>();
    }

    public boolean book(int start, int end) {
        update(start, end - 1, 1, 0, 1000000000, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update(start, end - 1, -1, 0, 1000000000, 1);
            return false;
        }
        return true;
    }

    public void update(int start, int end, int val, int l, int r, int idx) {
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

}

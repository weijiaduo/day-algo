package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表
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

    List<int[]> books;

    public MyCalendar() {
        books = new ArrayList<>();
    }

    public boolean book(int start, int end) {
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

}

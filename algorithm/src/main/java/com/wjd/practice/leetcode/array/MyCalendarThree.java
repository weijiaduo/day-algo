package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Map;
import java.util.TreeMap;

/**
 * 732. 我的日程安排表
 * <p>
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 * <p>
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * <p>
 * @since 2022/6/6
 */
public class MyCalendarThree implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] values = {{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19}, {3, 14}, {25, 39}, {6, 19}};
        for (int[] value : values) {
            int result = book(value[0], value[1]);
            System.out.println(result);
        }
        return null;
    }

    private TreeMap<Integer, Integer> cnt;

    public MyCalendarThree() {
        cnt = new TreeMap<>();
    }

    /**
     * 看来是没理解清楚题意
     *
     * 执行耗时:99 ms,击败了28.23% 的Java用户
     * 内存消耗:42 MB,击败了51.36% 的Java用户
     */
    public int book(int start, int end) {
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

}

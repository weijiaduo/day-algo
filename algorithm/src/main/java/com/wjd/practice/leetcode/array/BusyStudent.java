package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 1450. 在既定时间做作业的学生人数
 * <p>
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
 * <p>
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * <p>
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。
 * <p>
 * 形式上，返回能够使 queryTime 处于区间 [startTime[i],endTime[i]]（含）的学生人数。
 * <p>
 * 输入：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * 输出：1
 *
 * @author weijiaduo
 * @since 2022/8/19
 */
public class BusyStudent implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] startTime = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] endTime = {10, 10, 10, 10, 10, 10, 10, 10, 10};
        int queryTime = 5;
        int result = busyStudent(startTime, endTime, queryTime);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接遍历判断区间就行了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了8.94% 的Java用户
     */
    private int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int num = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            int s = startTime[i];
            int e = endTime[i];
            if (s <= queryTime && queryTime <= e) {
                num++;
            }
        }
        return num;
    }

}

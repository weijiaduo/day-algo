package com.wjd.practice.leetcode.array.traversal;

/**
 * 495. 提莫攻击
 * <p>
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * <p>
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *
 * @since 2021-06-23
 */
public class FindPoisonedDuration {

    /**
     * 思路：记录中毒结束时间，判断攻击时间是否在结束时间之前
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:44.4 MB,击败了5.05% 的Java用户
     *
     * @param timeSeries 时间序列
     * @param duration   间隔
     * @return 持续时间
     */
    private int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0, end = 0;
        for (int time : timeSeries) {
            if (time >= end) {
                sum += duration;
            } else {
                sum += time + duration - end;
            }
            end = time + duration;
        }
        return sum;
    }

}

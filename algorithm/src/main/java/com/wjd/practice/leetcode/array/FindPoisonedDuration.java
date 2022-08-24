package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * @since 2021-06-23
 *
 * 495. 提莫攻击
 *
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *
 */
public class FindPoisonedDuration implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] timeSeries = {1,4};
        int duration = 2;
        int result = findPoisonedDuration(timeSeries, duration);
        System.out.println(result);
        return result;
    }

    /**
     * 计算持续中毒时间
     * @param timeSeries 时间序列
     * @param duration 间隔
     * @return 持续时间
     */
    private int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int nextTime = 0;
        for (int time : timeSeries) {
            if (time >= nextTime) {
                sum += duration;
            } else {
                sum += time + duration - nextTime;
            }
            nextTime = time + duration;
        }
        return sum;
    }

}

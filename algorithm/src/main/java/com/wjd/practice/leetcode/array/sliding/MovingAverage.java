package com.wjd.practice.leetcode.array.sliding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * <p>
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * <p>
 * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class MovingAverage {

    Queue<Integer> queue = new LinkedList<>();
    int size;
    double sum;

    /**
     * 思路：使用队列保存滑动窗口，超过大小就从列头弹出，列尾压入
     * <p>
     * 执行耗时:36 ms,击败了96.62% 的Java用户
     * 内存消耗:45.2 MB,击败了94.96% 的Java用户
     */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }

}

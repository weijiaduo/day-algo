package com.wjd.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. 最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class MinStack {

    public Void solve(Object... args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        return null;
    }

    /**
     * 数据栈
     */
    private final Deque<Integer> dataStack;
    /**
     * 最小值栈
     */
    private final Deque<Integer> minStack;

    /**
     * 思路：数组保存栈结构，另外用一个栈保存最小值的索引，直接指向数组的最小值
     * <p>
     * 执行耗时:4 ms,击败了93.16% 的Java用户
     * 内存消耗:43.6 MB,击败了5.62% 的Java用户
     */
    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            return;
        }
        int x = dataStack.pop();
        if (!minStack.isEmpty() && x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) {
            return -1;
        }
        return dataStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

}

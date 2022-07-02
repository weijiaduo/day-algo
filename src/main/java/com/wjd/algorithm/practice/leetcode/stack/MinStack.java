package com.wjd.algorithm.practice.leetcode.stack;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.*;

/**
 * 155. 最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class MinStack implements Solution<Void> {

    @Override
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

    ArrayList<Integer> stack;
    Deque<Integer> minStack;

    /**
     * 思路：数组保存栈结构，另外用一个栈保存最小值的索引，直接指向数组的最小值
     * <p>
     * 执行耗时:4 ms,击败了93.16% 的Java用户
     * 内存消耗:43.6 MB,击败了5.62% 的Java用户
     */
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val <= getMin()) {
            minStack.push(stack.size());
        }
        stack.add(val);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        if (!minStack.isEmpty() && minStack.peek() == stack.size()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minStack.peek());
    }

}

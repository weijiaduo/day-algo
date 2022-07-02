package com.wjd.algorithm.practice.leetcode.stack;

import com.wjd.algorithm.practice.leetcode.Solution;

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
public class DiffMinStack implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        DiffMinStack minStack = new DiffMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        return null;
    }

    Deque<Long> stack;
    long min;

    /**
     * 思路：用栈保存当前值和当前最小值的差值
     * <p>
     * 执行耗时:4 ms,击败了93.16% 的Java用户
     * 内存消耗:43.5 MB,击败了10.08% 的Java用户
     */
    public DiffMinStack() {
        stack = new ArrayDeque<>();
        min = 0;
    }

    public void push(int val) {
        long diff;
        if (stack.isEmpty()) {
            diff = 0;
            min = val;
        } else {
            diff = val - min;
            if (diff < 0) {
                min = val;
            }
        }
        stack.push(diff);
    }

    public void pop() {
        long diff = stack.pop();
        if (diff < 0) {
            min = min - diff;
        }
    }

    public int top() {
        long diff = stack.peek();
        long top;
        if (diff < 0) {
            top = min;
        } else {
            top = min + diff;
        }
        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }

}

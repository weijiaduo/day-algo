package com.wjd.practice.book.cracking.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.02. 栈的最小值
 * <p>
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * <p>
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top(); --> 返回 0.
 * minStack.getMin(); --> 返回 -2.
 *
 * @author weijiaduo
 * @since 2023/12/17
 */
public class MinStack {

    /**
     * 数据栈
     */
    private final Deque<Integer> dataStack;
    /**
     * 最小值栈
     */
    private final Deque<Integer> minStack;

    /**
     * 思路：两个栈，一个放数据，一个放最小值
     * <p>
     * 当入栈元素小于等于栈顶元素时，同时入最小值栈
     * <p>
     * 当出栈元素等于栈顶元素时，同时最小值出栈
     * <p>
     * 执行耗时:13 ms,击败了88.86% 的Java用户
     * 内存消耗:46 MB,击败了37.42% 的Java用户
     */
    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
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

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top()); // 0
        System.out.println(minStack.getMin()); // -2
    }

}

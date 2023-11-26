package com.wjd.practice.book.sword.stack;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 30. 包含 min 函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class MinStack {

    /**
     * 数据栈
     */
    Deque<Integer> dataStack = new ArrayDeque<>();
    /**
     * 最小值栈
     */
    Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int node) {
        dataStack.push(node);
        // 只在 <= min 的时候，才入最小值栈
        if (minStack.isEmpty() || node <= min()) {
            minStack.push(node);
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Empty Stack!");
        }

        int res = dataStack.pop();
        if (res == min()) {
            minStack.pop();
        }
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Empty Stack!");
        }

        return minStack.peek();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    @TestCase(input = {"[3,4,2,1]"},
            output = {"[3,3,2,1,1,2,3,3]"})
    public List<Integer> test(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        MinStack stack = new MinStack();
        for (int num : nums) {
            stack.push(num);
            ans.add(stack.min());
        }
        while (!stack.isEmpty()) {
            ans.add(stack.min());
            stack.pop();
        }
        return ans;
    }

}

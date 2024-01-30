package com.wjd.practice.book.sword.stack;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 9. 用两个栈实现队列、232. 用栈实现队列
 * <p>
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class TwoStackForQueue {

    /**
     * 数据入栈
     */
    Deque<Integer> inStack;
    /**
     * 数据出栈
     */
    Deque<Integer> outStack;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.39 MB,击败了11.58% 的Java用户
     */
    public TwoStackForQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (empty()) {
            throw new NoSuchElementException("Empty Queue!");
        }
        ensureQueue();
        return outStack.pop();
    }

    public int peek() {
        if (empty()) {
            throw new NoSuchElementException("Empty Queue!");
        }
        ensureQueue();
        return outStack.peek();
    }

    private void ensureQueue() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    @TestCase(input = {"1"}, output = {})
    public void test(int unused) {
        List<Integer> expect = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> actual = new ArrayList<>();
        TwoStackForQueue queue = new TwoStackForQueue();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 2; i++) {
            actual.add(queue.pop());
        }
        for (int i = 5; i < 10; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 8; i++) {
            actual.add(queue.pop());
        }
        assert expect.equals(actual);
    }

}

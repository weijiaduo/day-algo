package com.wjd.practice.book.cracking.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.04. 化栈为队
 * <p>
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1); queue.push(2);
 * <p>
 * queue.peek();  // 返回 1
 * <p>
 * queue.pop();   // 返回 1
 * <p>
 * queue.empty(); // 返回 false 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * <p>
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author weijiaduo
 * @since 2023/12/18
 */
public class MyQueue {

    /**
     * 入队的栈
     */
    Deque<Integer> inStack;
    /**
     * 出队的栈
     */
    Deque<Integer> outStack;

    /**
     * 思路：两个栈， 一个入队的栈，一个出队的栈
     * <p>
     * 执行耗时:9 ms,击败了97.67% 的Java用户
     * 内存消耗:39.3 MB,击败了40.12% 的Java用户
     */
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        ensureDequeue();
        if (outStack.isEmpty()) {
            return -1;
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        ensureDequeue();
        if (outStack.isEmpty()) {
            return -1;
        }
        return outStack.peek();
    }

    /**
     * 从入队栈中的数据压入出队栈中
     */
    private void ensureDequeue() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        System.out.println(queue.empty()); // false
        System.out.println(queue.pop()); // 2
        System.out.println(queue.empty()); // true
    }

}

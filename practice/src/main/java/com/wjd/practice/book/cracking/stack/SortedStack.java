package com.wjd.practice.book.cracking.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.05. 栈排序
 * <p>
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * <p>
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * <p>
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * <p>
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * <p>
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 *
 * @author weijiaduo
 * @since 2023/12/18
 */
public class SortedStack {

    /**
     * 有序栈
     */
    Deque<Integer> stack;
    /**
     * 临时栈
     */
    Deque<Integer> temp;

    /**
     * 思路：双栈 + 惰性更新
     * <p>
     * 入栈的时候，将小于当前元素的栈元素弹出到临时栈
     * <p>
     * 然后将当前元素入栈
     * <p>
     * 而临时栈的元素则等待需要时再重新入栈
     * <p>
     * 执行耗时:11 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了45.85% 的Java用户
     */
    public SortedStack() {
        stack = new ArrayDeque<>();
        temp = new ArrayDeque<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && val > stack.peek()) {
            temp.push(stack.pop());
        }
        while (!temp.isEmpty() && val < temp.peek()) {
            stack.push(temp.pop());
        }
        stack.push(val);
    }

    public void pop() {
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public int peek() {
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // 1
        stack.pop();
        System.out.println(stack.peek()); // 2
        System.out.println(stack.isEmpty()); // false
        stack.pop();
        System.out.println(stack.peek()); // 3
        System.out.println(stack.isEmpty()); // false
        stack.pop();
        System.out.println(stack.isEmpty()); // true
    }

}

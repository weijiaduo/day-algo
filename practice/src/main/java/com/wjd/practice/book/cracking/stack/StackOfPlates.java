package com.wjd.practice.book.cracking.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 面试题 03.03. 堆盘子
 * <p>
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。
 * <p>
 * 因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
 * <p>
 * 请实现数据结构SetOfStacks，模拟这种行为。
 * <p>
 * SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * <p>
 * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 * <p>
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * <p>
 * 示例2:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 *
 * @author weijiaduo
 * @since 2023/12/17
 */
public class StackOfPlates {

    /**
     * 每个栈的容量
     */
    private final int capacity;
    /**
     * 栈集合
     */
    private final List<Deque<Integer>> stacks;

    /**
     * 思路：栈集合，没当一个栈满以后，就新建栈添加元素
     * <p>
     * 执行耗时:8 ms,击败了98.38% 的Java用户
     * 内存消耗:48.7 MB,击败了96.76% 的Java用户
     */
    public StackOfPlates(int cap) {
        this.capacity = cap;
        this.stacks = new ArrayList<>();
    }

    public void push(int val) {
        if (capacity <= 0) {
            return;
        }
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() >= capacity) {
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(stacks.size() - 1).push(val);
    }

    public int pop() {
        return popAt(stacks.size() - 1);
    }

    public int popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            return -1;
        }
        Deque<Integer> stack = stacks.get(index);
        int val = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return val;
    }

    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates(1);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.popAt(1)); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // -1
    }

}

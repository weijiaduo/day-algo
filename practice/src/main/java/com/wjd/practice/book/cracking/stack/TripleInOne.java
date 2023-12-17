package com.wjd.practice.book.cracking.stack;

/**
 * 面试题 03.01. 三合一
 * <p>
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
 * <p>
 * stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * <p>
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * <p>
 * 提示：
 * <p>
 * 0 <= stackNum <= 2
 *
 * @author weijiaduo
 * @since 2023/12/17
 */
public class TripleInOne {

    /**
     * 栈的数量
     */
    private static final int N = 3;
    /**
     * 每个栈的大小
     */
    private final int capacity;
    /**
     * 3 个栈空间
     */
    private final int[] stack;
    /**
     * 3 个栈顶
     */
    private final int[] tops;

    /**
     * 思路：数组分成 3 段，每段属于一个栈
     * <p>
     * 执行耗时:8 ms,击败了97.65% 的Java用户
     * 内存消耗:48.3 MB,击败了14.71% 的Java用户
     */
    public TripleInOne(int stackSize) {
        capacity = stackSize;
        stack = new int[stackSize * N];
        tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = stackSize * i;
        }
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            return;
        }
        stack[tops[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return stack[--tops[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return stack[tops[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return tops[stackNum] <= stackNum * capacity;
    }

    public boolean isFull(int stackNum) {
        return tops[stackNum] >= (stackNum + 1) * capacity;
    }

    public static void main(String[] args) {
        TripleInOne triple = new TripleInOne(1);
        triple.push(0, 1);
        triple.push(0, 2);
        System.out.println(triple.pop(0));
        System.out.println(triple.pop(0));
        System.out.println(triple.pop(0));
        System.out.println(triple.isEmpty(0));

        triple = new TripleInOne(2);
        triple.push(0, 1);
        triple.push(0, 2);
        triple.push(0, 3);
        System.out.println(triple.pop(0));
        System.out.println(triple.pop(0));
        System.out.println(triple.pop(0));
        System.out.println(triple.peek(0));
    }

}

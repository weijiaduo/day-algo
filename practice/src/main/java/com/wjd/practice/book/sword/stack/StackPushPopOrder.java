package com.wjd.practice.book.sword.stack;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 31. 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * <p>
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * <p>
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * <p>
 * （注意：这两个序列的长度是相等的）
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class StackPushPopOrder {

    /**
     * 思路：出入栈模拟
     * <p>
     * 将入栈序列入栈，当栈顶元素和当前出栈序列元素一致时，出栈
     * <p>
     * 如果最后栈为空，则表示出栈序列是正确的
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[1,2,3,4,5]", "[4,5,3,2,1]"},
            output = {"true"})
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null ||
            pushA.length != popA.length || pushA.length == 0) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int length = pushA.length;
        int pushIndex = 0, popIndex = 0;
        while (pushIndex < length) {
            // 入栈序列
            stack.push(pushA[pushIndex++]);
            // 出栈序列，当栈顶元素和序列元素相等时，出栈
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

}

package com.wjd.practice.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 * <p>
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * <p>
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * @author weijiaduo
 * @since 2022/8/31
 */
public class ValidateStackSequences {

    /**
     * 思路：将pushed序列推入栈，碰到poped的值时出栈，直到最后，如果栈中数据为空，表示是有效序列
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了95.57% 的Java用户
     * 内存消耗:41.2 MB,击败了41.09% 的Java用户
     *
     * @param pushed 入栈
     * @param popped 出栈
     * @return true/false
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0, j = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < n) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && j < n && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}

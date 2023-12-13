package com.wjd.practice.leetcode.stack;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. 移掉 K 位数字
 * <p>
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 请你以字符串形式返回这个最小的数字。
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * <p>
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 10⁵
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 * @author weijiaduo
 * @since 2023/12/13
 */
public class RemoveKdigits {

    /**
     * 思路：单调栈
     * <p>
     * 当前元素比栈顶元素小时，就移除栈顶元素，保证小的放前面
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:11 ms,击败了76.61% 的Java用户
     * 内存消耗:42.5 MB,击败了90.93% 的Java用户
     */
    @TestCase(input = {"1432219", "3", "10200", "1", "10", "2"},
            output = {"1219", "200", "0"})
    public String monotonic(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        // 还没删除完 k 个元素
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // 去掉前导 0，然后转成字符串
        while (!stack.isEmpty() && stack.getLast() == '0') {
            stack.pollLast();
        }
        if (stack.isEmpty()) {
            return "0";
        }
        char[] chs = new char[stack.size()];
        for (int i = chs.length - 1; !stack.isEmpty(); i--) {
            chs[i] = stack.pop();
        }
        return new String(chs);
    }

}

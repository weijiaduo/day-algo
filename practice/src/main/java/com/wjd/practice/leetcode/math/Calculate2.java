package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. 基本计算器 II
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。
 * <p>
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 10⁵
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * @author weijiaduo
 * @since 2024/3/7
 */
public class Calculate2 {

    /**
     * 思路：模拟
     * <p>
     * 第一轮先计算 * 和 / 的结果
     * <p>
     * 第二轮再计算 + 和 - 的结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:16 ms,击败了86.61% 的Java用户
     * 内存消耗:45.8 MB,击败了29.07% 的Java用户
     */
    @TestCase(input = {"3+2*2", " 3/2 ", " 3+5 / 2 ", "1-1+1", "0-2147483647"},
            output = {"7", "1", "5", "1", "-2147483647"})
    public int calculate(String s) {
        // 去掉空格
        char[] chs = s.toCharArray();
        int n = chs.length, m = 0;
        for (int i = 0; i < n; i++) {
            if (chs[i] != ' ') {
                chs[m++] = chs[i];
            }
        }

        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        // 计算乘除法
        for (int i = 0; i < m; i++) {
            // 数字
            int num = 0;
            while (i < m && Character.isDigit(chs[i])) {
                num = num * 10 + (chs[i++] - '0');
            }
            numbers.push(num);

            if (!ops.isEmpty() &&
                (ops.peek() == '*' || ops.peek() == '/')) {
                int second = numbers.pop();
                int first = numbers.pop();
                if (ops.pop() == '*') {
                    numbers.push(first * second);
                } else {
                    numbers.push(first / second);
                }
            }

            // 操作符
            if (i < m) {
                ops.push(chs[i]);
            }
        }

        // 计算加减法，需要从前往后计算
        while (!ops.isEmpty() && numbers.size() > 1) {
            int first = numbers.removeLast();
            int second = numbers.removeLast();
            char op = ops.removeLast();
            if (op == '+') {
                numbers.addLast(first + second);
            } else if (op == '-') {
                numbers.addLast(first - second);
            }
        }
        return numbers.isEmpty() ? 0 : numbers.peek();
    }

}

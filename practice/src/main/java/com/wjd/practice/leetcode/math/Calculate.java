package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 10⁵
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 *
 * @author weijiaduo
 * @since 2023/12/11
 */
public class Calculate {

    /**
     * 思路：官方题解，模拟
     * <p>
     * 由于只有 +/- 这两种操作符，没有优先级关系
     * <p>
     * 所以即使将括号去除，也不影响计算结果
     * <p>
     * 唯一需要考虑的括号前面如果是 - 号，括号内的数字都需要变号
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:13 ms,击败了49.90% 的Java用户
     * 内存消耗:42.7 MB,击败了73.72% 的Java用户
     */
    @TestCase(input = {"1 + 1",
            " 2-1 + 2 ",
            "(1+(4+5+2)-3)+(6+8)",
            "1-(     -2)"},
            output = {"2", "3", "23", "3"})
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    /**
     * 思路：栈模拟
     * <p>
     * 用两个栈，一个存数字，一个存操作符
     * <p>
     * 当遇到数字时，如果有操作符+/-，则对数字栈的两个数字进行操作
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:13 ms,击败了49.90% 的Java用户
     * 内存消耗:43 MB,击败了36.84% 的Java用户
     */
    @TestCase(input = {"1 + 1",
            " 2-1 + 2 ",
            "(1+(4+5+2)-3)+(6+8)",
            "1-(     -2)"},
            output = {"2", "3", "23", "3"})
    public int calculate1(String s) {
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        int n = s.length(), i = 0;
        boolean lastIsNumber = false;
        while (i < n) {
            // 跳过空格
            char ch = s.charAt(i++);
            if (ch == ' ') {
                continue;
            }

            if (ch == '+') {
                ops.push(ch);
                lastIsNumber = false;
                continue;
            }
            if (ch == '-') {
                ops.push(ch);
                if (!lastIsNumber) {
                    // 负数的情况
                    nums.push(0);
                    lastIsNumber = true;
                }
                continue;
            }
            if (ch == '(') {
                ops.push(ch);
                lastIsNumber = false;
                continue;
            }
            if (ch == ')') {
                // 弹出 (
                ops.pop();
                calc(nums, ops);
                lastIsNumber = true;
                continue;
            }

            // 数字
            lastIsNumber = true;
            int num = ch - '0';
            while (i < n && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i++) - '0');
            }

            // 计算
            nums.push(num);
            calc(nums, ops);
        }
        return nums.isEmpty() ? 0 : nums.pop();
    }

    /**
     * 计算表达式
     *
     * @param nums 数字栈
     * @param ops  操作符栈
     */
    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        while (!ops.isEmpty() && nums.size() > 1) {
            char op = ops.peek();
            if (op == '+') {
                ops.pop();
                int second = nums.pop();
                int first = nums.pop();
                nums.push(first + second);
            } else if (op == '-') {
                ops.pop();
                int second = nums.pop();
                int first = nums.pop();
                nums.push(first - second);
            } else {
                break;
            }
        }
    }

}

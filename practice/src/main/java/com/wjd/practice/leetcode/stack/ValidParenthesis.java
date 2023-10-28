package com.wjd.practice.leetcode.stack;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 *
 * @author weijiaduo
 * @since 2022/8/24
 */
public class ValidParenthesis {

    /**
     * 思路：栈匹配，遇到左括号入栈，遇到右括号出栈，最终栈为空则是有效的括号
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了98.88% 的Java用户
     * 内存消耗:39.5 MB,击败了57.00% 的Java用户
     */
    @TestCase(input = {"()", "()[]{}", "(]"},
            output = {"true", "true", "false"})
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(', '[', '{' -> stack.push(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                }
                default -> {
                }
            }
        }
        return stack.isEmpty();
    }

}

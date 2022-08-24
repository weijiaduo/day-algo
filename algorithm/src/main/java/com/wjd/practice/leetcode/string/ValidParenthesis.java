package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

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
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * @author weijiaduo
 * @since 2022/8/24
 */
public class ValidParenthesis implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String s = "{[}}";
        boolean result = isValid(s);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：栈匹配，遇到左括号入栈，遇到右括号出栈，最终栈为空则是有效的括号
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了98.88% 的Java用户
     * 内存消耗:39.5 MB,击败了57.00% 的Java用户
     *
     * @param s 括号字符串
     * @return 是否是有效括号
     */
    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

}

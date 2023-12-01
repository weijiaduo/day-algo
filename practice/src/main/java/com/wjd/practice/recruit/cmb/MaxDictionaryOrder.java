package com.wjd.practice.recruit.cmb;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 求最大子序列
 * <p>
 * 求一个字符串的所有子序列中，最大的那个子序列
 *
 * @author weijiaduo
 * @since 2023/12/1
 */
public class MaxDictionaryOrder {

    /**
     * 思路：递减单调栈
     * <p>
     * 从右往左遍历字符串，大于等于栈顶字符时入栈
     * <p>
     * 因为在前面的字符是越大越好，所以最大子序列是一个非递减序列
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"cmbchina", "aabcbccacbbcbaaba"},
            output = {"na", "cccccbba"})
    public String maxDictionaryOrder(String s) {
        // 递减单调栈
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || ch >= stack.peek()) {
                stack.push(ch);
            }
        }

        // 出栈并构造子序列
        int size = stack.size();
        char[] chs = new char[size];
        for (int i = 0; i < size; i++) {
            chs[i] = stack.pop();
        }
        return new String(chs);
    }

}

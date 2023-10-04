package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 *
 * @since 2022/5/15
 */
public class GenerateParenthesis {

    /**
     * 思路：回溯法，枚举 2n 个位置，每个位置的可选值有：左括号/右括号
     * <p>
     * 但是，括号数量需要限制，左括号和右括号的数量分别是 n 个
     * <p>
     * 同时，还需要保证左右括号能够正确匹配
     * <p>
     * 复杂度：时间 O(n * n!) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了82.07% 的Java用户
     */
    @TestCase(input = {"3", "1"},
            output = {"[\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]", "[\"()\"]"})
    public List<String> backtrack1(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder(n * 2);
        backtrack1(n, n, str, ans);
        return ans;
    }

    /**
     * 回溯法，枚举 2n 个位置，每个位置的可选值有：左括号/右括号
     *
     * @param left  剩余没用的左括号
     * @param right 剩余没用的右括号
     * @param str   当前括号序列
     * @param ans   不同排列结果
     */
    private void backtrack1(int left, int right, StringBuilder str, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(str.toString());
            return;
        }
        // 右括号不足以匹配左括号时，剪枝
        if (left > right) {
            return;
        }
        // 左括号还有剩余
        if (left > 0) {
            str.append('(');
            backtrack1(left - 1, right, str, ans);
            str.deleteCharAt(str.length() - 1);
        }
        // 右括号还有剩余
        if (right > 0) {
            str.append(')');
            backtrack1(left, right - 1, str, ans);
            str.deleteCharAt(str.length() - 1);
        }
    }

    /**
     * 思路：回溯法，枚举 2n 个位置，每个位置的可选值有：左括号/右括号
     * <p>
     * 但是，括号数量需要限制，左括号和右括号的数量分别是 n 个
     * <p>
     * 同时，还需要保证左右括号能够正确匹配
     * <p>
     * 复杂度：时间 O(n * n!) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了94.67% 的Java用户
     */
    @TestCase(input = {"3", "1"},
            output = {"[\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]", "[\"()\"]"})
    public List<String> backtrack2(int n) {
        List<String> ans = new ArrayList<>();
        char[] chars = new char[2 * n];
        backtrack2(n, n, chars, 0, ans);
        return ans;
    }

    /**
     * 回溯法，枚举 2n 个位置，每个位置的可选值有：左括号/右括号
     *
     * @param left  剩余没用的左括号
     * @param right 剩余没用的右括号
     * @param chars 括号序列
     * @param index 当前索引
     * @param ans   不同排列结果
     */
    private void backtrack2(int left, int right, char[] chars, int index, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(new String(chars));
            return;
        }
        // 右括号不足以匹配左括号时，剪枝
        if (left > right) {
            return;
        }
        // 左括号还有剩余
        if (left > 0) {
            chars[index] = '(';
            backtrack2(left - 1, right, chars, index + 1, ans);
        }
        // 右括号还有剩余
        if (right > 0) {
            chars[index] = ')';
            backtrack2(left, right - 1, chars, index + 1, ans);
        }
    }

}

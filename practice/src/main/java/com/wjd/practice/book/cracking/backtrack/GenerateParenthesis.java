package com.wjd.practice.book.cracking.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * <p>
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author weijiaduo
 * @since 2023/12/31
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
     * 内存消耗:41.6 MB,击败了29.78% 的Java用户
     */
    @TestCase(input = {"3", "1"},
            output = {"[\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]", "[\"()\"]"})
    public List<String> backtrack(int n) {
        char[] chs = new char[2 * n];
        List<String> ret = new ArrayList<>();
        backtrack(chs, 0, n, n, ret);
        return ret;
    }

    /**
     * 回溯法，枚举 2n 个位置，每个位置的可选值有：左括号/右括号
     *
     * @param chs 字符数组
     * @param i   待选下标
     * @param lc  左括号剩余数量
     * @param rc  右括号剩余数量
     * @param ret 结果集合
     */
    private void backtrack(char[] chs, int i, int lc, int rc, List<String> ret) {
        if (i == chs.length) {
            ret.add(new String(chs));
            return;
        }
        // 快速剪枝
        if (lc > rc) {
            return;
        }
        // 放入左括号
        if (lc > 0) {
            chs[i] = '(';
            backtrack(chs, i + 1, lc - 1, rc, ret);
        }
        // 放入右括号
        if (rc > 0) {
            chs[i] = ')';
            backtrack(chs, i + 1, lc, rc - 1, ret);
        }
    }

}

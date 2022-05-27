package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 1021. 删除最外层的括号
 * <p>
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * <p>
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * <p>
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * @since 2022/5/28
 */
public class RemoveOuterParentheses implements Solution<String> {

    @Override
    public String solve(Object args) {
        String s = "()()";
        String result = removeOuterParentheses(s);
        System.out.println(result);
        return result;
    }

    /**
     * 直接遍历法
     *
     * 思路：从左至右遍历，找到每个有效的括号，去掉左右两边的括号即可
     *
     * 执行耗时:2 ms,击败了98.81% 的Java用户
     * 内存消耗:41.4 MB,击败了17.56% 的Java用户
     */
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int leftCount = 0, leftIndex = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                leftCount--;
                if (leftCount <= 0) {
                    // 刚好匹配完括号
                    sb.append(s, leftIndex + 1, i);
                    leftIndex = i + 1;
                }
            }
        }
        return sb.toString();
    }
}

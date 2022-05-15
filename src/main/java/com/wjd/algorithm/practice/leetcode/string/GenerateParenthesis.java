package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/5/15
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * <p>
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis implements Solution<List<String>> {

    @Override
    public List<String> solve(Object args) {
        int n = 1;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
        return result;
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder str = new StringBuilder(n * 2);
        backtrack(n, n, 0, str, results);
        return results;
    }

    private void backtrack(int left, int right, int sum, StringBuilder str,
                           List<String> results) {
        if (left == 0 && right == 0 && sum == 0) {
            results.add(str.toString());
        }
        if (left > 0) {
            // 左括号还有剩余
            if (sum + 1 <= right) {
                // 剩余的右括号足够配对前面的左括号
                str.append('(');
                backtrack(left - 1, right, sum + 1, str, results);
                str.deleteCharAt(str.length() - 1);
            }
        }
        if (right > 0) {
            // 右括号还有剩余
            if (sum - 1 >= 0) {
                // 前面还有待配对的左括号
                str.append(')');
                backtrack(left, right - 1, sum - 1, str, results);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

}

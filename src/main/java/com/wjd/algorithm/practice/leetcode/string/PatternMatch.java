package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2022/5/14
 * 10. 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * <p>
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * <p>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class PatternMatch implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        String s = "bbbb";
        String p = "b*";
        boolean result1 = deepMatch(s, p);
        boolean result2 = dynamicMatch(s, p);
        System.out.println(result1 + ", " + result2);
        return result1 && result2;
    }

    /**
     * 递归
     */
    public boolean deepMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            // 首字符相同
            if (p.length() > 1 && p.charAt(1) == '*') {
                // * 匹配零个或多个前面的字符
                return deepMatch(s.substring(1), p.substring(2)) ||
                        deepMatch(s.substring(1), p) ||
                        deepMatch(s, p.substring(2));
            } else {
                // 单个字符匹配
                return deepMatch(s.substring(1), p.substring(1));
            }
        } else {
            // 首字符不相同
            if (p.length() > 1 && p.charAt(1) == '*') {
                // * 匹配零个字符
                return deepMatch(s, p.substring(2));
            }
        }

        return false;
    }

    /**
     * 动态规划
     */
    private boolean dynamicMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (i > 0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        // 非首次匹配当前字符/首次匹配当前字符/忽略当前*型表达式
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 2] || dp[i][j - 2];
                    } else {
                        // 忽略当前*型表达式
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                        // 可匹配的情况，单字符匹配
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

}

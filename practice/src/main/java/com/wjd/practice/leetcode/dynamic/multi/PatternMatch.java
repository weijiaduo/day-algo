package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
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
 *
 * @since 2022/5/14
 */
public class PatternMatch {

    int[][] cache;

    /**
     * 思路：记忆化搜索
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了9.50% 的Java用户
     */
    @TestCase(input = {"aa", "a", "aa", "a*", "ab", ".*", "a", "ab*"},
            output = {"false", "true", "true", "true"})
    public boolean dfs(String s, String p) {
        cache = new int[s.length() + 1][p.length()];
        return dfs(s, 0, p, 0);
    }

    private boolean dfs(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (cache[i][j] != 0) {
            return cache[i][j] == 1;
        }

        boolean ans = false;
        boolean firstEqual = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean secondStar = j < p.length() - 1 && p.charAt(j + 1) == '*';
        if (secondStar) {
            // * 匹配零个字符
            ans = dfs(s, i, p, j + 2);
            if (firstEqual) {
                // * 匹配一个或多个前面的字符
                ans = ans || dfs(s, i + 1, p, j + 2)
                      || dfs(s, i + 1, p, j);
            }
        } else if (firstEqual) {
            // 单个字符匹配
            ans = dfs(s, i + 1, p, j + 1);
        }

        cache[i][j] = ans ? 1 : -1;
        return ans;
    }

    /**
     * 思路：动态规划，从记忆化搜索可转化而来
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了23.18% 的Java用户
     */
    @TestCase(input = {"aa", "a", "aa", "a*", "ab", ".*", "a", "ab*"},
            output = {"false", "true", "true", "true"})
    public boolean dynamic2(String s, String p) {
        // 状态定义
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 状态初始化
        dp[0][0] = true;
        // 状态转移
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // * 匹配零个字符
                    dp[i][j] = dp[i][j - 2];
                    if (i > 0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        // * 匹配一个或多个前面的字符
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                        // 单个字符匹配
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

}

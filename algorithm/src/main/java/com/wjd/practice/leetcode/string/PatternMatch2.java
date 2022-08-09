package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 10. 通配符匹配
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * <p>
 * '*' 可以匹配任意字符串（包括空字符串）。
 * <p>
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * <p>
 *
 * @since 2022/5/14
 */
public class PatternMatch2 implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        String s = "acdcb";
        String p = "a*c?b";
        // boolean result1 = deepMatch(s, p);
        // System.out.println(result1);
        // boolean result2 = deepMatchCache(s, p, new HashMap<>());
        // System.out.println(result2);
        boolean result3 = dynamicMatch(s, p);
        System.out.println(result3);
        return result3;
    }

    /**
     * 递归
     * <p>
     * Time Limit Exceeded
     */
    public boolean deepMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        char pc = p.charAt(0);
        if (s.length() > 0) {
            if (pc == '?' || s.charAt(0) == pc) {
                // 单个字符匹配
                return deepMatch(s.substring(1), p.substring(1));
            }
            if (pc == '*') {
                // * 匹配0个、1个或多个字符
                return deepMatch(s.substring(1), p.substring(1))
                        || deepMatch(s.substring(1), p)
                        || deepMatch(s, p.substring(1));
            }
        } else {
            if (pc == '*') {
                // * 匹配0个字符
                return deepMatch(s, p.substring(1));
            }
        }

        return false;
    }

    /**
     * 递归
     * <p>
     * Time Limit Exceeded
     */
    public boolean deepMatchCache(String s, String p, Map<String, Map<String, Boolean>> cache) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        Map<String, Boolean> map = cache.getOrDefault(p, new HashMap<>());
        if (map.containsKey(s)) {
            return map.get(s);
        }

        boolean isMatch = false;
        char pc = p.charAt(0);
        if (s.length() > 0) {
            if (pc == '?' || s.charAt(0) == pc) {
                // 单个字符匹配
                isMatch = deepMatch(s.substring(1), p.substring(1));
            } else if (pc == '*') {
                // * 匹配0个、1个或多个字符
                isMatch = deepMatch(s.substring(1), p.substring(1))
                        || deepMatch(s.substring(1), p)
                        || deepMatch(s, p.substring(1));
            }
        } else {
            if (pc == '*') {
                // * 匹配0个字符
                isMatch = deepMatch(s, p.substring(1));
            }
        }

        map.put(s, isMatch);
        cache.put(p, map);
        return false;
    }

    /**
     * 动态规划
     * <p>
     * 比想象中的慢呀
     * <p>
     * 执行耗时:24 ms,击败了64.67% 的Java用户
     * 内存消耗:41.8 MB,击败了41.45% 的Java用
     */
    private boolean dynamicMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > 0) {
                    if (p.charAt(j - 1) == '*') {
                        // 匹配0个或多个字符
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                        // 匹配单个字符
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (p.charAt(j - 1) == '*') {
                        // 匹配0个字符
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

}

package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 97. 交错字符串
 * <p>
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * <p>
 * @since 2022/6/11
 */
public class IsInterleave implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        boolean result = isInterleave(s1, s2, s3);
        System.out.println(result);
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // return dfs(s1, 0, s2, 0, s3, 0);
        // return dynamic(s1, s2, s3);
        return dynamic2(s1, s2, s3);
    }

    /**
     * 递归法
     * <p>
     * 果然还是超时了
     * <p>
     * Time Limit Exceeded
     */
    private boolean dfs(String s1, int i, String s2, int j, String s3, int k) {
        if (s3.length() - k != s1.length() - i + s2.length() - j) {
            return false;
        }
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        char ch = s3.charAt(k);
        if (i < s1.length() && s1.charAt(i) == ch) {
            if (dfs(s1, i + 1, s2, j, s3, k + 1)) {
                return true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == ch) {
            if (dfs(s1, i, s2, j + 1, s3, k + 1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 动态规划
     * <p>
     * 思路：计算每个s1[i]子串和s2[j]子串是否可以交错成s3[i+j]子串
     * <p>
     * 执行耗时:2 ms,击败了92.64% 的Java用户
     * 内存消耗:39.4 MB,击败了85.08% 的Java用户
     */
    private boolean dynamic(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化动态数组
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // 推导动态数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[m][n];
    }

    /**
     * 动态规划
     * <p>
     * 思路：只用到左边和上边，可以压缩二维数组成一维数组
     * <p>
     * 执行耗时:1 ms,击败了97.05% 的Java用户
     * 内存消耗:39.1 MB,击败了99.35% 的Java用
     */
    private boolean dynamic2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];

        // 初始化动态数组
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // 推导动态数组
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[n];
    }

}

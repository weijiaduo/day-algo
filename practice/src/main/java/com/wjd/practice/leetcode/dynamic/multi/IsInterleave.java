package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 97. 交错字符串
 * <p>
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 *
 * @since 2022/6/11
 */
public class IsInterleave {

    /**
     * 思路：记忆化搜索，计算每个s1[i]子串和s2[j]子串是否可以交错成s3[i+j]子串
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:6 ms,击败了23.20% 的Java用户
     * 内存消耗:40.6 MB,击败了5.19% 的Java用户
     */
    @TestCase(input = {"aabcc", "dbbca", "aadbbcbcac",
            "aabcc", "dbbca", "aadbbbaccc",
            "aa", "ab", "aaba"},
            output = {"true", "false", "true"})
    public boolean memo(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return memo(s1, 0, s2, 0, s3, 0, new HashMap<>());
    }

    private boolean memo(String s1, int i, String s2, int j, String s3, int k, Map<String, Boolean> cache) {
        final String key = i + "_" + j;
        Boolean ret = cache.get(key);
        if (ret != null) {
            return ret;
        }
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        ret = false;
        char ch = s3.charAt(k);

        if (i < s1.length() && s1.charAt(i) == ch) {
            if (memo(s1, i + 1, s2, j, s3, k + 1, cache)) {
                ret = true;
            }
        }
        if (!ret && j < s2.length() && s2.charAt(j) == ch) {
            if (memo(s1, i, s2, j + 1, s3, k + 1, cache)) {
                ret = true;
            }
        }

        cache.put(key, ret);
        return ret;
    }

    /**
     * 思路：动态规划，计算每个s1[i]子串和s2[j]子串是否可以交错成s3[i+j]子串
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:2 ms,击败了90.33% 的Java用户
     * 内存消耗:39.9 MB,击败了13.80% 的Java用户
     */
    @TestCase(input = {"aabcc", "dbbca", "aadbbcbcac",
            "aabcc", "dbbca", "aadbbbaccc",
            "aa", "ab", "aaba"},
            output = {"true", "false", "true"})
    public boolean dynamic2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 状态定义
        // dp[i][j] 表示 s1[0~i) 和 s2[0~j) 可以交错成 s3[0~i+j)
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 状态初始化
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }


        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[m][n];
    }

    /**
     * 思路：动态规划+滚动数组，只用到左边和上边，可以压缩二维数组成一维数组
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了97.09% 的Java用户
     * 内存消耗:39.5 MB,击败了74.83% 的Java用户
     */
    @TestCase(input = {"aabcc", "dbbca", "aadbbcbcac",
            "aabcc", "dbbca", "aadbbbaccc",
            "aa", "ab", "aaba"},
            output = {"true", "false", "true"})
    public boolean dynamic1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 状态定义
        // dp[j] 表示 s1[0~i) 和 s2[0~j) 可以交错成 s3[0~i+j)
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];

        // 状态初始化
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // 状态转移
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

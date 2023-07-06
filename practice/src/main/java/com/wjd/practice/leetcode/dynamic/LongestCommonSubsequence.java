package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1143. 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
 * <p>
 * 如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * <p>
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * <p>
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * @author weijiaduo
 * @since 2023/7/6
 */
public class LongestCommonSubsequence {

    /**
     * 思路：动态规划
     * <p>
     * dp[i][j] 表示 text1[0...i] 和 text2[0...j] 的最长公共子序列长度
     * <p>
     * (1) 若 text1[i] == text2[j]
     * <p>
     * dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1])
     * <p>
     * (2) 若 text1[i] != text2[j]
     * <p>
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:18 ms,击败了69.50% 的Java用户
     * 内存消耗:47.3 MB,击败了70.43% 的Java用户
     */
    @TestCase(input = {"abcde", "ace", "abc", "abc", "abc", "def"},
            output = {"3", "3", "0"})
    public int dynamic2(String text1, String text2) {
        // 状态定义
        // dp[i][j] 表示 text1[0...i) 和 text2[0...j) 的最长公共子序列长度
        int m = text1.length(), n = text2.length();
        // 空间 +1 可以减少索引判断
        int[][] dp = new int[m + 1][n + 1];
        // 状态转移
        for (int i = 1; i <= m; i++) {
            char ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ch2 = text2.charAt(j - 1);
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (ch1 == ch2) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

}

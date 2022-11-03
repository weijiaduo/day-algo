package com.wjd.practice.leetcode.string;

import java.util.Arrays;

/**
 * 1688. 最大重复子字符串
 * <p>
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
 * <p>
 * 那么单词 word 的 重复值为 k 。
 * <p>
 * 单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * <p>
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * <p>
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 *
 * @author weijiaduo
 * @since 2022/11/3
 */
public class MaxRepeating {

    public int solve(String sequence, String word) {
        return dp(sequence, word);
    }

    /**
     * 思路：遍历 1~k 个 word 连接的字符串，是否在 sequence 中
     * <p>
     * 复杂度：时间 O(kmn) 空间 O(km)
     * <p>
     * 执行耗时:1 ms,击败了59.84% 的Java用户
     * 内存消耗:39.4 MB,击败了90.98% 的Java用户
     */
    private int contain(String sequence, String word) {
        int k = 0;
        String str = word;
        while (sequence.contains(str)) {
            k++;
            str += word;
        }
        return k;
    }

    /**
     * 思路：动态规划，以 i 结尾的 word，重复次数 f(i) 等于 f(i-m) + 1。
     * <p>
     * 复杂度： 时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了59.56% 的Java用户
     */
    private int dp(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (m > n) {
            return 0;
        }

        int ans = 0;
        int[] dp = new int[n];
        for (int i = m - 1; i < n; i++) {
            int offset = i - m + 1;
            boolean match = true;
            for (int j = m - 1; j >= 0; j--) {
                if (sequence.charAt(offset + j) != word.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                // f(i) = f(i-m) + 1
                dp[i] = (i >= m ? dp[i - m] : 0) + 1;
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

}

package com.wjd.practice.leetcode.dynamic;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * <p>
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 *
 * @since 2022/6/11
 */
public class NumDecodings {

    /**
     * 动态规划
     * <p>
     * 思路：当前数字，分为单个数字解码和双数解码2种情况
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了62.95% 的Java用户
     */
    public int numDecoding(String s) {
        int[] dp = new int[s.length()];
        char last = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 1、单数字解码
            if ('1' <= ch && ch <= '9') {
                dp[i] = i > 0 ? dp[i - 1] : 1;
            } else {
                dp[i] = 0;
            }

            // 2、双数字解码
            if (i > 0 && '1' <= last && last <= '2') {
                if (i < 2 || dp[i - 2] != 0) {
                    int num = (last - '0') * 10 + (ch - '0');
                    if (10 <= num && num <= 26) {
                        dp[i] += i > 1 ? dp[i - 2] : 1;
                    }
                }
            }

            last = ch;
        }

        return dp[s.length() - 1];
    }

    /**
     * 这内存消耗果然很假，哈哈哈
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了50.02% 的Java用户
     */
    private int numDecoding2(String s) {
        int dp = 0, dp1 = 0, dp2 = 0;
        int n = s.length(), number, lastNumber = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            number = ch - '0';

            // 1、单数字解码
            if (1 <= number && number <= 9) {
                dp = i > 0 ? dp1 : 1;
            } else {
                dp = 0;
            }

            // 2、双数字解码
            if (i > 0 && 1 <= lastNumber && lastNumber <= 2) {
                if (i < 2 || dp2 != 0) {
                    int temp = lastNumber * 10 + number;
                    if (10 <= temp && temp <= 26) {
                        dp += i > 1 ? dp2 : 1;
                    }
                }
            }

            lastNumber = number;
            dp2 = dp1;
            dp1 = dp;
        }

        return dp;
    }

}

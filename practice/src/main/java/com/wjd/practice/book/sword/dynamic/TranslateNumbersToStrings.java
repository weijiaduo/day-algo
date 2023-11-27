package com.wjd.practice.book.sword.dynamic;

import com.wjd.practice.TestCase;

/**
 * 46. 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * <p>
 * 0 翻译成 “a”，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * <p>
 * 一个数字可能有多个翻译。例如 12258 有 5 种不同的翻译，它们分别是 “bccfi”、“bwfi”、“bczi”、“mcfi” 和 “mzi”。
 * <p>
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class TranslateNumbersToStrings {

    /**
     * 思路：动态规划
     * <p>
     * 用 f(i) 表示从第 i 位数字开始的不同翻译的数目，那么 f(i) = f(i+1) + g(i, i+1) * f(i+2)
     * <p>
     * 当第 i 位和第 i+1 位两位数字拼接起来的数字在 10~25 的范围内时，函数 g(i, i+1) 的值为 1，否则为 0
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"12258"}, output = {"5"})
    public int dynamic1(int num) {
        String str = Integer.toString(num);
        int n = str.length();

        // 状态定义
        int[] dp = new int[n];
        // 状态初始化
        dp[n - 1] = 1;
        // 状态转移
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (i < n - 2) {
                // 检查数字是否在 10~25 之间
                int a = str.charAt(i) - '0';
                int b = str.charAt(i + 1) - '0';
                int c = a * 10 + b;
                if (c >= 10 && c <= 25) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * 由于只依赖于后两个状态，所以可以用滚动数组优化空间复杂度
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"12258"}, output = {"5"})
    public int dynamic0(int num) {
        String str = Integer.toString(num);
        int n = str.length();
        // 状态定义以及初始化
        int next1 = 1, next2 = 0;
        // 状态转移
        for (int i = n - 2; i >= 0; i--) {
            int next = next1;
            if (i < n - 2) {
                // 检查数字是否在 10~25 之间
                int a = str.charAt(i) - '0';
                int b = str.charAt(i + 1) - '0';
                int c = a * 10 + b;
                if (c >= 10 && c <= 25) {
                    next += next2;
                }
            }
            next2 = next1;
            next1 = next;
        }
        return next1;
    }

}

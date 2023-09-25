package com.wjd.practice.leetcode.string.compare;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1071. 字符串的最大公因子
 * <p>
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * <p>
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * <p>
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * <p>
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 由大写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/7/26
 */
public class GcdOfStrings {

    /**
     * 思路：暴力法，直接枚举所有可能的字符串
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:7 ms,击败了11.97% 的Java用户
     * 内存消耗:42.1 MB,击败了14.53% 的Java用户
     */
    @TestCase(input = {"ABCABC", "ABC", "ABABAB", "ABAB", "LEET", "CODE"},
            output = {"ABC", "AB", ""})
    public String bf(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        String ls = n1 > n2 ? str1 : str2;
        String ss = n1 > n2 ? str2 : str1;
        for (int i = ss.length(); i > 0; i--) {
            String r = ss.substring(0, i);
            if (check(ls, r) && check(ss, r)) {
                return r;
            }
        }
        return "";
    }

    /**
     * 思路：枚举优化，最大公因子字符串就是它们长度最大公因数的子串
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:7 ms,击败了11.97% 的Java用户
     * 内存消耗:42.1 MB,击败了14.53% 的Java用户
     */
    @TestCase(input = {"ABCABC", "ABC", "ABABAB", "ABAB", "LEET", "CODE"},
            output = {"ABC", "AB", ""})
    public String gcdString(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        String t = str1.substring(0, gcd(n1, n2));
        if (check(str1, t) && check(str2, t)) {
            return t;
        }
        return "";
    }

    /**
     * 两个数字的最大公因数
     */
    private int gcd(int n, int r) {
        return r == 0 ? n : gcd(r, n % r);
    }

    /**
     * 检查字符串t是否由n个s组成
     *
     * @param t 目标串
     * @param s 组成串
     * @return true/false
     */
    private boolean check(String t, String s) {
        int n = t.length(), m = s.length();
        return s.repeat(n / m).equals(t);
    }

}

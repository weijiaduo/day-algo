package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 28. 实现 strStr 函数
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * <p>
 * 如果不存在，则返回 -1 。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * <p>
 * 输出：2
 * <p>
 * @since 2022/5/17
 */
public class StrStr implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        String haystack = "a";
        String needle = "a";
        int result = strStr(haystack, needle);
        System.out.println(result);
        return result;
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

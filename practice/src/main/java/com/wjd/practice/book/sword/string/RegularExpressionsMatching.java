package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 19. 正则表达式匹配
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * <p>
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * <p>
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 *
 * @author weijiaduo
 * @since 2023/11/24
 */
public class RegularExpressionsMatching {

    @TestCase(input = {"aaa", "a.a", "aaa", "ab*ac*a", "aaa", "aa.a", "aaa", "ab*a"},
            output = {"true", "true", "false", "false"})
    public boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str.toCharArray(), 0, pattern.toCharArray(), 0);
    }

    /**
     * 递归正则匹配
     *
     * @param str 主串
     * @param i   主串下标
     * @param pat 模式串
     * @param j   模式串下标
     * @return 是否匹配
     */
    private boolean match(char[] str, int i, char[] pat, int j) {
        int m = str.length, n = pat.length;
        if (i > m || j > n) {
            return false;
        }
        // 主串末尾
        if (i == m) {
            return j == n;
        }
        // 模式串末尾
        if (j == n) {
            return false;
        }

        // a* 或 .* 模式
        if (j < n - 1 && pat[j + 1] == '*') {
            if (str[i] == pat[j] || pat[j] == '.') {
                return match(str, i + 1, pat, j)
                        || match(str, i, pat, j + 2);
            } else {
                return match(str, i, pat, j + 2);
            }
        }
        // a 或 . 模式
        if (str[i] == pat[j] || pat[j] == '.') {
            return match(str, i + 1, pat, j + 1);
        }
        return false;
    }

}

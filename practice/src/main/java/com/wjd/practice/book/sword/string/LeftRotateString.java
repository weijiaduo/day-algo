package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 58.2 左旋转字符串
 * <p>
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * <p>
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class LeftRotateString {

    /**
     * 思路：先左右两部分子串，再翻转整个字符串
     * <p>
     * 比如，原始字符串格式 <--<----
     * <p>
     * 先翻转左右子串 -->---->
     * <p>
     * 再翻转整个字符串 <----<--
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"\"abcXYZdef\"", "0",
            "\"abcXYZdef\"", "9",
            "\"abcXYZdef\"", "-1",
            "\"abcXYZdef\"", "10",
            "\"abcXYZdef\"", "3"},
            output = {"\"abcXYZdef\"",
                    "\"abcXYZdef\"",
                    "\"abcXYZdef\"",
                    "\"bcXYZdefa\"",
                    "\"XYZdefabc\""})
    public String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return str;
        }

        // 转成字符数组，方便翻转
        char[] chs = str.toCharArray();
        int tn = n % chs.length;

        // 翻转左半部分
        reverse(chs, 0, tn - 1);
        // 翻转右半部分
        reverse(chs, tn, chs.length - 1);
        // 翻转整个字符串
        reverse(chs, 0, chs.length - 1);

        return new String(chs);
    }

    /**
     * 翻转指定范围内的字符
     *
     * @param chs  字符数组
     * @param low  [low, high]
     * @param high [low, high]
     */
    private void reverse(char[] chs, int low, int high) {
        int lp = low, rp = high;
        while (lp < rp) {
            char ch = chs[lp];
            chs[lp++] = chs[rp];
            chs[rp--] = ch;
        }
    }

}

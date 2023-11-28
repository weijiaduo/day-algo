package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 58.1 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * <p>
 * 为简单起见，标点符号和普通字母一样处理。
 * <p>
 * 例如输入字符串 "I am a student."，则输出 "student. a am I"。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class ReverseWordsInSentence {

    /**
     * 思路：先翻转整个句子，再翻转每个单词
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"\"I am a student.\""}, output = {"\"student. a am I\""})
    public String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        // 转成字符数组，方便翻转
        char[] chs = str.toCharArray();
        int n = chs.length;

        // 首先翻转整个句子
        reverse(chs, 0, n - 1);
        // 然后翻转每个单词
        int lp = 0, rp = lp;
        while (rp < n) {
            // 寻找单词
            while (lp < n && chs[lp] == ' ') {
                lp++;
            }
            rp = lp;
            while (rp < n && chs[rp] != ' ') {
                rp++;
            }
            // 翻转单词
            reverse(chs, lp, rp - 1);
            lp = rp;
        }

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

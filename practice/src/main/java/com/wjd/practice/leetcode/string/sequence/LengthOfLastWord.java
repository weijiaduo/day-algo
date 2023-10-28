package com.wjd.practice.leetcode.string.sequence;

import com.wjd.practice.TestCase;

/**
 * 58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * @since 2022/5/22
 */
public class LengthOfLastWord {

    /**
     * 思路：前后指针，从后往前找，但是要先跳过最后面的空格
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了38.86% 的Java用户
     */
    @TestCase(input = {"Hello World", "   fly me   to   the moon  ", "luffy is still joyboy"},
            output = {"5", "4", "6"})
    public int doublePoint(String s) {
        int left = s.length() - 1, right;
        // 从后往前找到非空格的位置
        while (left >= 0 && s.charAt(left) == ' ') {
            left--;
        }
        right = left;
        // 从后往前找到空格位置
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }
}

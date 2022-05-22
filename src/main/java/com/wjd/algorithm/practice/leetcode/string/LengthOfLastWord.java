package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * <p>
 * @since 2022/5/22
 */
public class LengthOfLastWord implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        String s = "joyboy";
        int result = lengthOfLastWord(s);
        System.out.println(result);
        return result;
    }

    /**
     * 前后指针
     *
     * 思路：从后往前找，但是要先跳过最后面的空格
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了38.86% 的Java用户
     */
    public int lengthOfLastWord(String s) {
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

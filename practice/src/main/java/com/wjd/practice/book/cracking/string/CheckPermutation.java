package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * <p>
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * <p>
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author weijiaduo
 * @since 2023/12/12
 */
public class CheckPermutation {

    /**
     * 思路：哈希计数
     * <p>
     * 如果两个字符串的字符计数一样，说明他们是互为重排
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了10.63% 的Java用户
     */
    @TestCase(input = {"abc", "bca", "abc", "bad"},
            output = {"true", "false"})
    public boolean hash(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }

        // 字符计数，一个正计数，一个反计数
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            cnt[ch1 - 'a']++;
            cnt[ch2 - 'a']--;
        }

        for (int j : cnt) {
            // 如果计数不为 0，表示字符数量不一样
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路：排序，对2个字符串排序，排序结果相同就是互为重排
     * <p>
     * 复杂第：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了32.15% 的Java用户
     */
    @TestCase(input = {"abc", "bca", "abc", "bad"},
            output = {"true", "false"})
    public boolean sort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

}

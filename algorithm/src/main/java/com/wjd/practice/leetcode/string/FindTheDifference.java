package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 389. 找不同
 * <p>
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * @author weijiaduo
 * @since 2022/9/14
 */
public class FindTheDifference implements Solution<Character> {

    @Override
    public Character solve(Object... args) {
        String s = "";
        String t = "d";
        char result = findTheDifference(s, t);
        System.out.println(result);
        return result;
    }

    private char findTheDifference(String s, String t) {
        // return sortFind(s, t);
        return countFind(s, t);
    }

    /**
     * 思路：排序，找到第一个不同的字符
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了75.09% 的Java用户
     * 内存消耗:39.6 MB,击败了67.78% 的Java用户
     *
     * @param s 字符串
     * @param t 字符串
     * @return 不同字符
     */
    private char sortFind(String s, String t) {
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();
        Arrays.sort(scs);
        Arrays.sort(tcs);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (scs[i] != tcs[i]) {
                return tcs[i];
            }
        }
        return tcs[n];
    }

    /**
     * 思路：计数，统计s和t的字符数量，t中数量大于s的字符，就是不同字符
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了98.99% 的Java用户
     * 内存消耗:39.5 MB,击败了88.56% 的Java用户
     *
     * @param s 字符串
     * @param t 字符串
     * @return 不同字符
     */
    private char countFind(String s, String t) {
        int[] counts = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < 0) {
                return (char) ('a' + i);
            }
        }
        return t.charAt(n);
    }

    /**
     * 思路：求和，t的字符串和-s的字符串和=差异字符
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了98.99% 的Java用户
     * 内存消耗:39.4 MB,击败了95.69% 的Java用户
     *
     * @param s 字符串
     * @param t 字符串
     * @return 不同字符
     */
    private char sumFind(String s, String t) {
        int sum = 0;
        // 字符串的 length 方法是真的耗时
        int tn = t.length();
        for (int i = 0; i < tn; i++) {
            sum += t.charAt(i);
        }
        int sn = s.length();
        for (int i = 0; i < sn; i++) {
            sum -= s.charAt(i);
        }
        return (char) sum;
    }

    /**
     * 思路：s+t的所有相同字符次数都是偶数，只有差异字符的次数是奇数
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了98.99% 的Java用户
     * 内存消耗:39.4 MB,击败了93.80% 的Java用户
     *
     * @param s 字符串
     * @param t 字符串
     * @return 不同字符
     */
    private char oddFind(String s, String t) {
        char ch = 0;
        int sn = s.length();
        for (int i = 0; i < sn; i++) {
            ch ^= s.charAt(i);
        }
        int tn = t.length();
        for (int i = 0; i < tn; i++) {
            ch ^= t.charAt(i);
        }
        return ch;
    }

}

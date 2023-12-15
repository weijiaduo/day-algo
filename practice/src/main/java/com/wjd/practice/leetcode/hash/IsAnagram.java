package com.wjd.practice.leetcode.hash;

import com.wjd.practice.TestCase;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 10⁴
 * s 和 t 仅包含小写字母
 *
 * @author weijiaduo
 * @since 2022/9/6
 */
public class IsAnagram {

    /**
     * 思路：计数法，使用长度为26的数组，记录字符串字符的数量，s的字符+1，t的字符-1，判断最后数组的值是否都为0
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了90.23% 的Java用户
     * 内存消耗:41.1 MB,击败了56.99% 的Java用户
     */
    @TestCase(input = {"anagram", "nagaram", "rat", "car"},
            output = {"true", "false"})
    public boolean hash(String s, String t) {
        int m = s.length(), n = t.length();
        if (m != n) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < m; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (--count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}

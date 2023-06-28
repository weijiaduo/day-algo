package com.wjd.practice.leetcode.string.compare;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
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
     * 执行耗时:3 ms,击败了60.57% 的Java用户
     * 内存消耗:41.3 MB,击败了77.30% 的Java用户
     */
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if (m != n) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

}

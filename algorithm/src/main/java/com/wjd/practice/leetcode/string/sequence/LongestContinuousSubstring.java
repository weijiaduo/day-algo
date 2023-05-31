package com.wjd.practice.leetcode.string.sequence;

/**
 * 6181. 最长的字母序连续子字符串的长度
 *
 * @author weijiaduo
 * @since 2022/9/18
 */
public class LongestContinuousSubstring {

    /**
     * 思路：逐个遍历，判断当前字符是否是上一个字符的连续增长即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param s 字符串
     * @return 最长连续增长长度
     */
    public int longestContinuousSubstring(String s) {
        int ans = 0;
        int n = s.length(), count = 1;
        for (int i = 1; i < n; i++) {
            // 判断是否是连续增长
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        // 字符串结尾
        ans = Math.max(ans, count);
        return ans;
    }

}

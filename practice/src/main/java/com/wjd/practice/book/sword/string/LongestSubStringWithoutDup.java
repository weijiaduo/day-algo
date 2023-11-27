package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 48. 最长不含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 假设字符串中只包含从 'a' 到 'z' 的字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke"
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class LongestSubStringWithoutDup {

    /**
     * 思路：滑动窗口
     * <p>
     * 记录一个包含了不同字符的窗口，然后不断扩展右边界
     * <p>
     * 直到遇到重复字符，开始收缩左边界，直到去掉重复字符为止
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"abcabcbb", "bbbbb", "pwwkew"}, output = {"3", "1", "3"})
    public int slide(String s) {
        int ans = 0;
        int n = s.length();
        boolean[] flag = new boolean[26];
        for (int l = 0, r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (flag[c - 'a']) {
                // 重复字符，收缩左边界
                while (s.charAt(l) != c) {
                    flag[s.charAt(l) - 'a'] = false;
                    l++;
                }
                l++;
            }
            // 扩展右边界
            flag[c - 'a'] = true;
            // 更新最大长度
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }

}

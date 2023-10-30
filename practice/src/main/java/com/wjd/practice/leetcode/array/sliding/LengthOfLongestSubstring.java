package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 *
 * @author weijiaduo
 * @since 2023/6/6
 */
public class LengthOfLongestSubstring {

    /**
     * 思路：滑动窗口
     * <p>
     * 记录一个包含了不同字符的窗口，然后不断扩展右边界
     * <p>
     * 直到遇到重复字符，开始收缩左边界，直到去掉重复字符为止
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了89.73% 的Java用户
     * 内存消耗:42.5 MB,击败了18.59% 的Java用户
     */
    @TestCase(input = {"abcabcbb", "bbbbb", "pwwkew"},
            output = {"3", "1", "3"})
    public int slide(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int l = 0, r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (!set.add(c)) {
                // 重复字符，收缩左边界
                while (s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            // 更新最大长度
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }

}

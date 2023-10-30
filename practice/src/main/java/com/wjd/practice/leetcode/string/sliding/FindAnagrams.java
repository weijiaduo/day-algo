package com.wjd.practice.leetcode.string.sliding;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * <p>
 * 不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 10⁴
 * s 和 p 仅包含小写字母
 *
 * @author weijiaduo
 * @since 2023/6/4
 */
public class FindAnagrams {

    /**
     * 思路：滑动窗口
     * <p>
     * 用长度 26 的数组记录 p 的字母数量
     * <p>
     * s 的子串也用长度 26 的数组记录字母数量，同时采用滑动窗口更新数组，与 p 的数组对比
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:8 ms,击败了71.69% 的Java用户
     * 内存消耗:42.9 MB,击败了21.94% 的Java用户
     */
    @TestCase(input = {"cbaebabacd", "abc", "abab", "ab"},
            output = {"[0,6]", "[0,1,2]"})
    public List<Integer> fixedSlide(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        final char base = 'a';
        int n = s.length(), m = p.length();

        int[] pc = new int[26];
        for (int i = 0; i < m; i++) {
            pc[p.charAt(i) - base]++;
        }

        int[] sc = new int[26];
        for (int l = 0, r = 0; r < n; r++) {
            sc[s.charAt(r) - base]++;
            if (r - l + 1 < m) {
                continue;
            }
            if (r - l + 1 > m) {
                sc[s.charAt(l++) - base]--;
            }
            if (Arrays.equals(pc, sc)) {
                ret.add(l);
            }
        }
        return ret;
    }

    /**
     * 思路：变长滑动窗口
     * <p>
     * 使用数组记录 p 的字母频率，同时遍历 s 的子串，对 p 的频率进行消减
     * <p>
     * 如果频率小于 0，则收缩左边界；
     * <p>
     * 如果频率大于 0，则扩展右边界，同时验证子串长度是否满足 p 的长度
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了96.15% 的Java用户
     * 内存消耗:42.8 MB,击败了31.09% 的Java用户
     */
    @TestCase(input = {"cbaebabacd", "abc", "abab", "ab"},
            output = {"[0,6]", "[0,1,2]"})
    public List<Integer> dynamicSlide(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] pc = new int[128];
        for (int i = 0; i < m; i++) {
            pc[p.charAt(i)]++;
        }
        int l = 0, r = 0;
        while (r < n) {
            if (pc[s.charAt(r)] > 0) {
                // 扩展窗口，消减 p 的频率
                pc[s.charAt(r++)]--;
                if (r - l == m) {
                    ret.add(l);
                }
            } else {
                // 收缩窗口，恢复 p 的频率
                pc[s.charAt(l++)]++;
            }
        }
        return ret;
    }

}

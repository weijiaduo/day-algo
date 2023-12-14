package com.wjd.practice.leetcode.string.sequence;

import com.wjd.practice.TestCase;

/**
 * 28. 实现 strStr 函数
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * <p>
 * 如果 needle 不是 haystack 的一部分，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 10⁴
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @since 2022/5/17
 */
public class StrStr {

    /**
     * 思路：直接模拟暴力匹配
     * <p>
     * 遍历字符串每个起点，然后尝试匹配
     * <p>
     * 复杂度：时间 O(nm) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了71.15% 的Java用户
     */
    @TestCase(input = {"sadbutsad", "sad", "leetcode", "leeto"},
            output = {"0", "-1"})
    public int indexOf(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m - 1 < n; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

}

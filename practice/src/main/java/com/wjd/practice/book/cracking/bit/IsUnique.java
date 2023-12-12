package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 01.01. 判定字符是否唯一
 * <p>
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * <p>
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author weijiaduo
 * @since 2023/12/12
 */
public class IsUnique {

    /**
     * 思路：hash 计数，统计每个字符的数量
     * <p>
     * 如果出现次数都是 1，则表明字符是唯一的
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了6.98% 的Java用户
     */
    @TestCase(input = {"leetcode", "abc"},
            output = {"false", "true"})
    public boolean hash(String astr) {
        int[] cnt = new int[26];
        int n = astr.length();
        for (int i = 0; i < n; i++) {
            char ch = astr.charAt(i);
            if (++cnt[ch - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路：位图，只有 26 个字母，可以用一个整数的 32 位表示
     * <p>
     * 字符出现时，将对应 bit 位置为 1
     * <p>
     * 如果字符对应的 bit 已经是 1 了，则表示重复出现
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了7.26% 的Java用户
     */
    @TestCase(input = {"leetcode", "abc"},
            output = {"false", "true"})
    public boolean bit(String astr) {
        int bitmap = 0;
        int n = astr.length();
        for (int i = 0; i < n; i++) {
            char ch = astr.charAt(i);
            int mask = 1 << (ch - 'a');
            if ((bitmap & mask) != 0) {
                // 字符重复出现
                return false;
            }
            bitmap ^= mask;
        }
        return true;
    }

}

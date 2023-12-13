package com.wjd.practice.leetcode.string.compare;

import com.wjd.practice.TestCase;

/**
 * 680. 验证回文串 II
 * <p>
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁵
 * s 由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/12/13
 */
public class ValidPalindrome {

    /**
     * 思路：双指针，分别指向字符串的左右两边
     * <p>
     * 当遇到两个字符不相等时，有两种处理方式
     * <p>
     * 1. 左边的字符跳过，相当于删除左边字符
     * <p>
     * 2. 右边的字符跳过，相当于删除右边字符
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了100.00% 的Java用户
     * 内存消耗:43.2 MB,击败了49.93% 的Java用户
     */
    @TestCase(input = {"aba", "abca", "abc"},
            output = {"true", "true", "false"})
    public boolean doublePoint(String s) {
        return isPalindrome(s, 0, s.length() - 1, 1);
    }

    /**
     * 验证字符串删除 k 个字符后是否能够称为回文串
     *
     * @param s    字符串
     * @param low  [low, high]
     * @param high [low, high]
     * @param k    删除次数
     * @return true/false
     */
    private boolean isPalindrome(String s, int low, int high, int k) {
        int lp = low, rp = high;
        while (lp < rp) {
            if (s.charAt(lp) == s.charAt(rp)) {
                lp++;
                rp--;
                continue;
            }
            if (k == 0) {
                return false;
            }
            return isPalindrome(s, lp + 1, rp, k - 1)
                   || isPalindrome(s, lp, rp - 1, k - 1);
        }
        return true;
    }

}

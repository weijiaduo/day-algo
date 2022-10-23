package com.wjd.practice.leetcode.string;

/**
 * 1768. 交替合并字符串
 * <p>
 * 给你两个字符串 word1 和 word2 。
 * <p>
 * 请你从 word1 开始，通过交替添加字母来合并字符串。
 * <p>
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 *
 * @author weijiaduo
 * @since 2022/10/23
 */
public class MergeAlternately {

    /**
     * 思路：模拟法，交替放入字符
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了79.54% 的Java用户
     */
    public String solve(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] chars = new char[m + n];
        int k = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if ((k & 1) == 0) {
                chars[k++] = word1.charAt(i++);
            } else {
                chars[k++] = word2.charAt(j++);
            }
        }
        while (i < m) {
            chars[k++] = word1.charAt(i++);
        }
        while (j < n) {
            chars[k++] = word2.charAt(j++);
        }
        return new String(chars);
    }

}

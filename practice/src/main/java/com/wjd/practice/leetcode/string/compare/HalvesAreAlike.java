package com.wjd.practice.leetcode.string.compare;

/**
 * 1704. 判断字符串的两半是否相似
 * <p>
 * 给你一个偶数长度的字符串 s 。
 * <p>
 * 将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
 * <p>
 * 注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 *
 * @author weijiaduo
 * @since 2022/11/11
 */
public class HalvesAreAlike {

    /**
     * 思路：直接模拟，前半部分元音累加，后半部分元音累减，最终计数为0表示相似
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了95.38% 的Java用户
     * 内存消耗:39.6 MB,击败了79.08% 的Java用户
     */
    public boolean solve(String s) {
        char[] chs = "aeiouAEIOU".toCharArray();
        boolean[] flg = new boolean[128];
        for (char ch : chs) {
            flg[ch] = true;
        }

        int n = s.length(), cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            if (flg[s.charAt(i)]) {
                cnt++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (flg[s.charAt(i)]) {
                cnt--;
            }
        }
        return cnt == 0;
    }

}

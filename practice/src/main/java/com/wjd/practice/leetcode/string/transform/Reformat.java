package com.wjd.practice.leetcode.string.transform;

/**
 * 1417. 重新格式化字符串
 * <p>
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。
 * <p>
 * 也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * @author weijiaduo
 * @since 2022/8/11
 */
public class Reformat {

    /**
     * 思路：统计数字和字母的数量，然后根据数量大小判断数字放奇数位还是偶数位
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了63.14% 的Java用户
     * 内存消耗:41.3 MB,击败了86.54% 的Java用户
     *
     * @param s 字符串
     * @return 格式化后的字符串/空串
     */
    public String reformat(String s) {
        int n = s.length();
        int digits = 0, letters = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits++;
            } else {
                letters++;
            }
        }

        // 无法交替格式化字符串
        if (Math.abs(digits - letters) > 1) {
            return "";
        }

        char[] chars = new char[n];
        int dp = digits > letters ? 0 : 1;
        int lp = 1 - dp;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                chars[dp] = ch;
                dp += 2;
            } else {
                chars[lp] = ch;
                lp += 2;
            }
        }
        return new String(chars);
    }

}

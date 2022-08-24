package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * @since 2022/5/22
 */
public class AddBinary implements Solution<String> {

    @Override
    public String solve(Object ...args) {
        String a = "1010";
        String b = "1011";
        String result = addBinary(a, b);
        System.out.println(result);
        return result;
    }

    /**
     * 暴力法
     *
     * 思路：直接算
     *
     * 执行耗时:1 ms,击败了99.94% 的Java用户
     * 内存消耗:40 MB,击败了66.65% 的Java用户
     */
    public String addBinary(String a, String b) {
        int c = 0;
        int m = a.length(), n = b.length();
        int max = Math.max(m, n);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < max; i++) {
            int n1= 0, n2 = 0;
            if (m > i) {
                n1 = a.charAt(m - 1 - i) - '0';
            }
            if (n > i) {
                n2 = b.charAt(n - 1 - i) - '0';
            }
            int s = n1 + n2 + c;
            c = s / 2;
            s = s % 2;
            result.append(s);
        }
        if (c != 0) {
            result.append(c);
        }
        return result.reverse().toString();
    }
}

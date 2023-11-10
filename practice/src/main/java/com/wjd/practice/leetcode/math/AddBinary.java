package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 示例 1：
 * <p>
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * <p>
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 10⁴
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 * @since 2022/5/22
 */
public class AddBinary {

    /**
     * 思路：模拟法，直接按照数字加法计算
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.94% 的Java用户
     * 内存消耗:40 MB,击败了66.65% 的Java用户
     */
    @TestCase(input = {"11", "1", "1010", "1011"},
            output = {"100", "10101"})
    public String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        int m = a.length(), n = b.length();
        int max = Math.max(m, n);
        int c = 0;
        for (int i = 0; i < max; i++) {
            int n1 = 0, n2 = 0;
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

    /**
     * 思路：位加法，用位操作完成加法运算
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 官解真废，二进制串超出整数范围了
     */
    @TestCase(input = {"11", "1", "1010", "1011"},
            output = {"100", "10101"})
    public String bitAdd(String a, String b) {
        int ai = Integer.parseInt(a, 2);
        int bi = Integer.parseInt(b, 2);
        while (bi != 0) {
            int sum = ai ^ bi;
            int carry = (ai & bi) << 1;
            ai = sum;
            bi = carry;
        }
        return Integer.toBinaryString(ai);
    }

}

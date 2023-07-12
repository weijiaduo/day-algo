package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.leetcode.TestCase;

/**
 * 2544. 交替数字和
 * <p>
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * <p>
 * 剩余每位上数字的符号都与其相邻数字相反。
 * <p>
 * 返回所有数字及其对应符号的和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10⁹
 *
 * @author weijiaduo
 * @since 2023/7/12
 */
public class AlternateDigitSum {

    /**
     * 思路：直接模拟，按照数字交替加起来
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了84.95% 的Java用户
     */
    @TestCase(input = {"521", "111", "886996", "10"},
            output = {"4", "1", "0", "1"})
    public int str(int n) {
        int sum = 0;
        String num = String.valueOf(n);
        int len = num.length(), sign = 1;
        for (int i = 0; i < len; i++) {
            sum += sign * (num.charAt(i) - '0');
            sign = -sign;
        }
        return sum;
    }

    /**
     * 官方题解
     * <p>
     * 思路：模拟，但是不用转字符串，而是直接用数字取余
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了46.49% 的Java用户
     */
    @TestCase(input = {"521", "111", "886996", "10"},
            output = {"4", "1", "0", "1"})
    public int math(int n) {
        int res = 0, sign = 1;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        return -sign * res;
    }

}

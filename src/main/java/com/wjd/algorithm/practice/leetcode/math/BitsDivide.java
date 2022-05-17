package com.wjd.algorithm.practice.leetcode.math;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 被除数和除数均为 32 位有符号整数。除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * @since 2022/5/18
 */
public class BitsDivide implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int dividend = 1;
        int divisor = 1;
        int result = divide(dividend, divisor);
        System.out.println(result);
        return result;
    }

    public int divide(int dividend, int divisor) {
        boolean symbol1 = dividend > 0;
        boolean symbol2 = divisor > 0;

        // 取负数作为除法操作数，取正数的话会溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int result = 0;
        while (dividend <= divisor) {
            int d = divisor;
            int b = 1;
            // 保证除数小于被除数，并且除数要始终小于0
            while (dividend <= (d << 1) && (d << 1) < 0) {
                d <<= 1;
                b <<= 1;
            }
            dividend -= d;
            result |= b;
        }

        if (symbol1 != symbol2) {
            // 相反符号
            result = -result;
        } else {
            // 相同符号，溢出判断
            if (result == Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            }
        }

        return result;
    }
}

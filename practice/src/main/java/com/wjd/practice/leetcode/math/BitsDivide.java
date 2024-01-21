package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 被除数和除数均为 32 位有符号整数。除数不为 0。
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 *
 * @since 2022/5/18
 */
public class BitsDivide {

    /**
     * 思路：快速乘 + 减法
     * <p>
     * 除法本质上就是减法，每减去一个值，商就+1
     * <p>
     * 因为可以利用减法来实现除法
     * <p>
     * 但是每次减一个值的速度太慢了，可以改成一次性减多个值
     * <p>
     * 比如 10 - 3 * 2，一次性减去 2 个 3
     * <p>
     * 但由于不能使用乘法，所以改成位操作 10 - (3 << 1)
     * <p>
     * 利用位操作可以实现快速乘法
     * <p>
     * (3 << 1) = 6
     * <p>
     * ((3 << 1) << 1) = 12
     * <p>
     * 以此加快减法的速度
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了9.84% 的Java用户
     */
    @TestCase(input = {"10", "3", "7", "-3"},
            output = {"3", "-2"})
    public int quickDivide(int dividend, int divisor) {
        // 处理溢出的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        // 取负数作为除法操作数，取正数的话会溢出
        boolean sign1 = dividend > 0, sign2 = divisor > 0;
        dividend = sign1 ? -dividend : dividend;
        divisor = sign2 ? -divisor : divisor;

        int ans = 0;
        while (dividend <= divisor) {
            int d = divisor, e = 1;
            // 保证除数不大于被除数，并且除数要始终小于 0
            while (dividend <= (d << 1) && (d << 1) < 0) {
                d <<= 1;
                e <<= 1;
            }
            dividend -= d;
            ans += e;
        }

        // 判断二者的符号
        return sign1 != sign2 ? -ans : ans;
    }
}

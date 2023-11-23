package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 16. 数值的整数次方
 * <p>
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。
 * <p>
 * 求 base 的 exponent 次方。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class Power {

    /**
     * 思路：使用快速幂算法
     * <p>
     * 比如 base = 3, exp = 5 的时候，不直接计算 3^5
     * <p>
     * 而是将 5 转换成二进制 101，即 5 = 2^2 + 2^0
     * <p>
     * 然后 3^5 = 3^(2^2 + 2^0) = 3^(2^2) * 3^(2^0)
     * <p>
     * 复杂度：时间 O(k) 空间 O(1)
     */
    @TestCase(input = {"2", "3", "0", "1", "1", "0", "2", "-3"},
            output = {"8.0", "0.0", "1.0", "0.125"})
    public double power(double base, int exp) {
        if (base == 0) {
            return 0;
        }
        if (exp == 0) {
            return 1;
        }
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }

        double res = 1;
        while (exp != 0) {
            if ((exp & 1) == 1) {
                res *= base;
            }
            exp >>= 1;
            base = base * base;
        }
        return res;
    }

}

package com.wjd.practice.book.cracking.math;

import com.wjd.practice.TestCase;

/**
 * 面试题 16.09. 运算
 * <p>
 * 请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * Operations() 构造函数
 * minus(a, b) 减法，返回a - b
 * multiply(a, b) 乘法，返回a * b
 * divide(a, b) 除法，返回a / b
 * <p>
 * 示例：
 * Operations operations = new Operations();
 * operations.minus(1, 2); // 返回-1
 * operations.multiply(3, 4); // 返回12
 * operations.divide(5, -2); // 返回-2
 * <p>
 * 提示：
 * <p>
 * 你可以假设函数输入一定是有效的，例如不会出现除法分母为0的情况
 * <p>
 * 单个用例的函数调用次数不会超过1000次
 *
 * @author weijiaduo
 * @since 2024/4/14
 */
public class Operations {

    /**
     * 执行耗时:16 ms,击败了32.76% 的Java用户
     * 内存消耗:43.7 MB,击败了32.76% 的Java用户
     */
    @TestCase(input = {"1"})
    public void test(int unused) {
        Operations operations = new Operations();
        System.out.println(operations.minus(1, 2)); // 返回-1
        System.out.println(operations.multiply(3, 4)); // 返回12
        System.out.println(operations.multiply(-100, 21474836)); // 返回-2147483600
        System.out.println(operations.divide(5, -2)); // 返回-2
        System.out.println(operations.divide(-2147483648, 1)); // 返回-2147483648
        System.out.println(operations.divide(-1491417400, 1228184586)); // 返回-1
    }

    /**
     * 减法
     *
     * @param a 被减数
     * @param b 减数
     * @return 差
     */
    public int minus(int a, int b) {
        return a + negate(b);
    }

    /**
     * 乘法
     *
     * @param a 被乘数
     * @param b 乘数
     * @return 积
     */
    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        if (b == 1) {
            return a;
        }
        if (a == -1) {
            return negate(b);
        }
        if (b == -1) {
            return negate(a);
        }

        int sa = abs(a), sb = abs(b);
        if (sb > sa) {
            return multiply(b, a);
        }

        // 使用加法模拟乘法
        int result = 0;
        int delta = sa, di = -1, n = sb;
        while (n + di >= 0) {
            n += di;
            result += delta;
            // 避免符号溢出
            if (sameSign(delta + delta, delta)) {
                delta += delta;
                di += di;
            }
            // 避免超出乘数范围
            if (n + di < 0) {
                delta = sa;
                di = -1;
            }
        }

        // 判断符号是否相反
        if (!sameSign(a, b)) {
            result = negate(result);
        }
        return result;
    }

    /**
     * 除法
     *
     * @param a 被除数
     * @param b 除数
     * @return 商
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("b = 0");
        }

        int na = a < 0 ? a : negate(a);
        int nb = b < 0 ? b : negate(b);
        if (na > nb) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (b == -1) {
            return negate(a);
        }

        int result = 0;
        // 使用减法模拟除法
        int sb = abs(b);
        int delta = sb, di = 1;
        while (na + delta <= 0) {
            na += delta;
            result += di;
            // 避免符号溢出
            if (sameSign(delta + delta, delta)) {
                delta += delta;
                di += di;
            }
            // 避免超出被除数范围
            if (na + delta > 0) {
                delta = sb;
                di = 1;
            }
        }

        // 判断符号是否相反
        if ((a >= 0) != (b >= 0)) {
            result = negate(result);
        }
        return result;
    }

    /**
     * 绝对值
     *
     * @param a 数值
     * @return 绝对值
     */
    private int abs(int a) {
        return a > 0 ? a : negate(a);
    }

    /**
     * 对数值取反
     *
     * @param a 数值
     * @return 取反值
     */
    private int negate(int a) {
        int na = 0;
        int newSign = a > 0 ? -1 : 1;
        int delta = newSign;
        while (a != 0) {
            // 判断符号是否发生变化
            if (a + delta != 0 && !sameSign(a + delta, a)) {
                delta = newSign;
            }
            a += delta;
            na += delta;
            delta += delta;
        }
        return na;
    }

    /**
     * 是否是相同的符号
     *
     * @param a 数值
     * @param b 数值
     * @return true/false
     */
    private boolean sameSign(int a, int b) {
        return (a >= 0) == (b >= 0);
    }

}

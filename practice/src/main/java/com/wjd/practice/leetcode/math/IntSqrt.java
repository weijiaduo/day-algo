package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 69. x的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 提示：
 * <p>
 * 0 <= x <= 2³¹ - 1
 *
 * @since 2022/5/22
 */
public class IntSqrt {

    /**
     * 思路：二分法，逐渐逼近平方值
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了94.67% 的Java用户
     * 内存消耗:38.3 MB,击败了94.76% 的Java用户
     */
    @TestCase(input = {"4", "8"},
            output = {"2", "2"})
    public int binary(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 思路：牛顿迭代法，可用于快速求解函数零点
     * <p>
     * 定义函数 y = x^2 - C，因此
     * <p>
     * 所求平方根就是 y = 0 时的结果 x = sqrt(C)
     * <p>
     * 利用牛顿迭代法可逐渐逼近 y = 0 的位置
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了94.28% 的Java用户
     * 内存消耗:38.6 MB,击败了36.67% 的Java用户
     */
    @TestCase(input = {"4", "8"},
            output = {"2", "2"})
    public int newton(int x) {
        if (x == 0) {
            return 0;
        }
        double c = x, x0 = 0.5 * x;
        while (true) {
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

}

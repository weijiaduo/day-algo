package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 50. Pow(x,y)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xⁿ <= 104
 *
 * @since 2022/5/29
 */
public class MyPow {

    /**
     * 思路：二分法，求 n 次，就拆分成 n/2 + n%2 次取幂
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了22.95% 的Java用户
     */
    @TestCase(input = {"2.00000", "10", "2.10000", "3", "2.00000", "-2"},
            output = {"1024.00000", "9.26100", "0.25000"})
    public double dfs(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        int mid = n / 2;
        int r = n - mid * 2;
        double midPow = dfs(x, mid);
        return midPow * midPow * dfs(x, r);
    }

    /**
     * 思路：幂次数可以转换为对应的 bit 位
     * <p>
     * 5 的二进制是 101，即 2^2 + 2^0，则 x^5 = x^(2^2) + x^(2^0)
     * <p>
     * 7 的二进制是 111，即 2^2 + 2^1 + 2^0，则 x^7 = x^(2^2) + x^(2^1) + x^(2^0)
     * <p>
     * 这个想法很有意思~~
     * <p>
     * 复杂度：时间 O(k) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了22.95% 的Java用户
     */
    @TestCase(input = {"2.00000", "10", "2.10000", "3", "2.00000", "-2"},
            output = {"1024.00000", "9.26100", "0.25000"})
    public double bit(double x, int n) {
        double ans = 1.0;
        double pow = x;
        long t = n;
        t = t > 0 ? t : -t; // -t可能会溢出
        while (t != 0) {
            if ((t & 0x1) == 1) {
                ans *= pow;
            }
            t >>= 1;
            pow *= pow;
        }
        if (n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }

}

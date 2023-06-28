package com.wjd.practice.leetcode.math;

/**
 * 50. Pow(x,y)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。
 * <p>
 *
 * @since 2022/5/29
 */
public class MyPow {

    public double myPow(double x, int n) {
        return bitPow(x, n);
    }

    /**
     * 二分法
     * <p>
     * 思路：求 n 次，就拆分成 n/2 + n%2 次取幂
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了22.95% 的Java用户
     */
    public double deepPow(double x, int n) {
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
        double midPow = deepPow(x, mid);
        return midPow * midPow * deepPow(x, r);
    }

    /**
     * 思路：5的二进制是101，即 2^2 * 2^0，所以幂次数可以转换为对应的bit位
     * <p>
     * 这个想法很有意思~~
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了22.95% 的Java用户
     */
    public double bitPow(double x, int n) {
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

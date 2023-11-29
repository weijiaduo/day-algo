package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 62. 圆圈中最后剩下的数字
 * <p>
 * 0,1,...,n-1 这 n 个数字排成一个圆圈，从数字 0 开始，
 * <p>
 * 每次从这个圆圈里删除第 m 个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4 这 5 个数字组成一个圆圈，
 * <p>
 * 从数字 0 开始每次删除第 3 个数字，则删除的前 4 个数字依次是 2、0、4、1，
 * <p>
 * 因此最后剩下的数字是 3。
 *
 * @author weijiaduo
 * @since 2023/11/30
 */
public class LastNumberInCircle {

    /**
     * 思路：暴力模拟
     * <p>
     * 用一个数组来表示圆圈，1 表示还在圈里，0 表示已经被删除了。
     * <p>
     * 从 0 开始，每次数 m 个，遇到 1 就数，数到 m 个就删除，直到剩下最后一个。
     * <p>
     * 复杂度：时间 O(nm) 空间 O(n)
     */
    @TestCase(input = {"5", "3"}, output = {"3"})
    public int imitate(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int last = 0;
        boolean[] flags = new boolean[n];
        for (int i = 0; i < n; i++) {
            int j = last, cnt = 0;
            while (cnt < m) {
                if (!flags[j]) {
                    last = j;
                    cnt++;
                }
                j = (j + 1) % n;
            }
            flags[last] = true;
        }
        return last;
    }

    /**
     * 思路：数学
     * <p>
     * f(n,m) = (f(n-1,m) + m) % n
     * <p>
     * f(1,m) = 0
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"5", "3"}, output = {"3"})
    public int math(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

}

package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 10. 斐波那契数列
 * <p>
 * 要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class Fibonacci {

    /**
     * 思路：递推，从前往后计算
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"0", "1", "10"},
            output = {"0", "1", "55"})
    public long fibonacci(int n) {
        if (n < 0) {
            return -1;
        }

        long last2 = 0, last1 = 1;
        // 算多一次，避免判断特殊情况
        for (int i = 1; i <= n; i++) {
            long sum = last1 + last2;
            last2 = last1;
            last1 = sum;
        }
        return last2;
    }

}

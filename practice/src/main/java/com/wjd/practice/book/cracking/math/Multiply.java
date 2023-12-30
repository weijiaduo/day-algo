package com.wjd.practice.book.cracking.math;

import com.wjd.practice.TestCase;

/**
 * 面试题 08.05. 递归乘法
 * <p>
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * <p>
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * <p>
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 *
 * @author weijiaduo
 * @since 2023/12/30
 */
public class Multiply {

    /**
     * 思路：分解乘法
     * <p>
     * a*b = (1 + a-1) * b = b + (a-1)*b
     * <p>
     * 复杂度：时间 O(C) 空间 O(C)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了5.23% 的Java用户
     */
    @TestCase(input = {"1", "10", "3", "4"},
            output = {"10", "12"})
    public int dfs(int a, int b) {
        if (a > b) {
            return dfs(b, a);
        }
        if (a == 1) {
            return b;
        }
        return b + dfs(a - 1, b);
    }

    /**
     * 思路：快速二分乘法
     * <p>
     * a*b = (a/2 + a/2 + a%2) * b
     * <p>
     * 复杂度：时间 O(logC) 空间 O(C)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了5.23% 的Java用户
     */
    @TestCase(input = {"1", "10", "3", "4"},
            output = {"10", "12"})
    public int divide(int a, int b) {
        if (a > b) {
            return divide(b, a);
        }
        if (a == 1) {
            return b;
        }

        int ans = 0;
        int half = divide(a / 2, b);
        ans += half + half;
        if (a % 2 == 1) {
            ans += b;
        }
        return ans;
    }

}

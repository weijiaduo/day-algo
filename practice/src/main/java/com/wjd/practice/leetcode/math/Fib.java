package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 509. 斐波那契数
 * <p>
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * <p>
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 *
 * @since 2025/04/04
 */
public class Fib {

    /**
     * 思路：使用递归，使用缓存来避免重复计算
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了5.39% 的Java用户
     *
     * @param n 数值
     * @return 斐波那契数
     */
    @TestCase(input = {"2", "3", "4"},
            output = {"1", "2", "3"})
    public int memo(int n) {
        int[] cache = new int[n + 1];
        return memo(n, cache);
    }

    private int memo(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = memo(n - 1, cache) + memo(n - 2, cache);
        return cache[n];
    }

    /**
     * 思路：迭代法，当前值等于前 2 个的和
     * <p>
     * 复杂的：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了81.02% 的Java用户
     *
     * @param n 数值
     * @return 斐波那契数
     */
    @TestCase(input = {"2", "3", "4"},
            output = {"1", "2", "3"})
    public int iter(int n) {
        if (n <= 1) {
            return n;
        }
        int last2 = 0, last1 = 1;
        for (int i = 2; i <= n; i++) {
            last1 = last2 + last1;
            last2 = last1 - last2;
        }
        return last1;
    }

}

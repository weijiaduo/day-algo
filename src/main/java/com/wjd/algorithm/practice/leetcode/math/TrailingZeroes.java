package com.wjd.algorithm.practice.leetcode.math;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 172. 阶乘后的零
 * <p>
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class TrailingZeroes implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 35;
        int result = trailingZeroes(n);
        System.out.println(result);
        return result;
    }

    private int trailingZeroes(int n) {
        // return lineTrailingZeroes(n);
        return lineTrailingZeroes2(n);
    }

    /**
     * 思路：统计5的数量，就是最终值末尾0的数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:8 ms,击败了6.50% 的Java用户
     * 内存消耗:38.3 MB,击败了85.86% 的Java用户
     */
    private int lineTrailingZeroes(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += getFiveNum(i);
        }
        return ans;
    }

    private int getFiveNum(int n) {
        int num = 0;
        while (n % 5 == 0) {
            num++;
            n /= 5;
        }
        return num;
    }

    /**
     * 思路：统计5、5*5、5*5*5...等多种形式的数量
     * <p>
     * 执行耗时:1 ms,击败了31.04% 的Java用户
     * 内存消耗:38.3 MB,击败了88.08% 的Java用户
     */
    private int lineTrailingZeroes2(int n) {
        int ans = 0;
        int e = 1, count = 0;
        while (true) {
            count++;
            e *= 5;
            if (e > n) {
                break;
            }
            int size = n / e;
            for (int i = 1; i <= size; i++) {
                // 避免5的数量变多
                if (i % 5 == 0) {
                    continue;
                }
                ans += count;
            }
        }
        return ans;
    }

    /**
     * 官解：也是统计5、5*5、5*5*5...等多种形式的数量，但是用一种比较巧妙的方式计算
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了91.09% 的Java用户
     */
    private int logTrailingZeroes2(int n) {
        int ans = 0;
        while (n != 0) {
            // 第一次除5，表示单个5的数量
            // 第二次除5，表示5*5的数量
            // 以此类推
            n /= 5;
            ans += n;
        }
        return ans;
    }

}

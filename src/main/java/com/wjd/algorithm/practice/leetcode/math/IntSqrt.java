package com.wjd.algorithm.practice.leetcode.math;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 69. x的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * @since 2022/5/22
 */
public class IntSqrt implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int x = 0;
        int result = mySqrt(x);
        System.out.println(result);
        return result;
    }

    /**
     * 不会写不会写
     *
     * 执行耗时:1 ms,击败了94.67% 的Java用户
     * 内存消耗:38.3 MB,击败了94.76% 的Java用户
     */
    public int mySqrt(int x) {
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

}

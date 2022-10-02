package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 周赛 313
 * <p>
 * 6192. 公因子的数目
 * <p>
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * <p>
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 *
 * @author weijiaduo
 * @since 2022/10/2
 */
public class CommonFactors implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int a = 452;
        int b = 392;
        int result = commonFactors(a, b);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：求出公因数，再找出公因数中每个因子
     * <p>
     * 复杂度：O(n) 空间 O(1)
     */
    private int commonFactors(int a, int b) {
        int g = gcd(a, b);
        int count = 0;
        for (int i = 1; i <= g; i++) {
            if (g % i == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 公因数
     */
    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

}

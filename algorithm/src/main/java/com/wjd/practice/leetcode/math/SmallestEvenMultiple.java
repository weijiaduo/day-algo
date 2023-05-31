package com.wjd.practice.leetcode.math;

/**
 * 6180. 最小偶倍数
 *
 * @author weijiaduo
 * @since 2022/9/18
 */
public class SmallestEvenMultiple {

    /**
     * 思路：2是质数，2和n的最小公倍数，不是n就是2n
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     *
     * @param n n
     * @return 最小公倍数
     */
    private int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }

}

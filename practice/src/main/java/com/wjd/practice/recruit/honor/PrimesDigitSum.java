package com.wjd.practice.recruit.honor;

import com.wjd.practice.TestCase;

/**
 * 质数的最小数位和
 * <p>
 * 给定数字范围 [low, high)，求这个范围内质数的十位和和个位和的最小值
 * <p>
 * 比如，[3, 20)，质数有 [3,5,7,11,13,17,19]
 * <p>
 * 它们的十位和是：0+0+0+1+1+1+1 = 4
 * <p>
 * 它们的各位和是：3+5+7+1+3+7+9 = 35
 * <p>
 * 结果返回它们之间的最小值 4
 *
 * @author weijiaduo
 * @since 2023/12/30
 */
public class PrimesDigitSum {

    /**
     * 思路：先找出 [low, high) 范围内的所有质数，
     * <p>
     * 然后计算十位和和个位和就行了。
     * <p>
     * 关键在于判断是否是质数。
     * <p>
     * 可使用埃氏筛判断 [1,high) 范围内的所有质数
     */
    @TestCase(input = {"3", "20"},
            output = {"4"})
    public int digitSum(int low, int high) {
        int ts = 0, gs = 0;
        boolean[] ps = primes(high);
        for (int i = low; i < high; i++) {
            if (ps[i]) {
                continue;
            }
            gs += i % 10;
            ts += (i / 10) % 10;
        }
        return Math.min(ts, gs);
    }

    /**
     * 标记返回 [1,n) 范围内的所有质数
     * <p>
     * true 表示非质数
     * <p>
     * false 表示质数
     *
     * @param n n
     * @return 质数标记数组
     */
    private boolean[] primes(int n) {
        boolean[] marks = new boolean[n + 2];
        marks[0] = marks[1] = true;
        for (int i = 2; i < n; i++) {
            if (marks[i]) {
                continue;
            }
            // 凡是 i 的倍数，都不可能是质数
            for (int j = i * i; j < n; j += i) {
                marks[j] = true;
            }
        }
        return marks;
    }

}

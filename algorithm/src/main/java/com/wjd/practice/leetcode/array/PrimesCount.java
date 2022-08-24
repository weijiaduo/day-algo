package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * @since 2021-06-28
 *
 * 204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class PrimesCount implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int n = 10;
        int result = countPrimes(n);
        System.out.println(result);
        return result;
    }

    /**
     * 统计所有小于非负整数 n 的质数的数量
     * @param n 非负整数
     * @return 质数数量
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] bools = new boolean[n];
        Arrays.fill(bools, true);
        bools[0] = bools[1] = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!bools[i]) {
                continue;
            }
            for (int sum = i * i; sum < n; sum += i) {
                bools[sum] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (bools[i]) {
                count++;
            }
        }
        return count;
    }
}

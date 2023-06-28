package com.wjd.practice.leetcode.math;

/**
 * 6115. 统计理想数组的数目
 *
 * @author weijiaduo
 * @since 2022/7/10
 */
public class IdealArrays {

    public int idealArrays(int n, int maxValue) {
        final int mod = (int) 1e9 + 7;
        int ans = 0;
        for (int i = 1; i <= maxValue; i++) {
            // i的不同倍数数量
            int num = maxValue / i;
            int count = 1 + (n - 1) * (num - 1);
            // 除开第一个以i开头，后面n-1个位置可以是任意倍数
            for (int j = 0; j < n - 1; j++) {
                count = count * num % mod;
            }
            ans = (ans + count) % mod;
        }
        return ans;
    }

}

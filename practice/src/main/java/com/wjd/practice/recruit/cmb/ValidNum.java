package com.wjd.practice.recruit.cmb;

import com.wjd.practice.TestCase;

/**
 * 有效的 cm 串
 * <p>
 * 长度为 N 字符串只包含 c 和 m 两种字符
 * <p>
 * 并且不能出现连续 2 个 c 的情况
 * <p>
 * 求符合这种要求的字符串有多少种
 *
 * @author weijiaduo
 * @since 2023/12/1
 */
public class ValidNum {

    /**
     * 思路：动态规划
     * <p>
     * f(i) 表示以下标 i 为 c 结尾字符串数量
     * <p>
     * g(i) 表示以下标 i 为 m 结尾的字符串数量
     * <p>
     * f(i) = g(i - 1)
     * <p>
     * g(i) = f(i - 1) + g(i - 1)
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"1", "2"},
            output = {"2", "3"})
    public int validNum(int N) {
        // 状态定义
        // 以 c 结尾的字符串数量
        int[] f = new int[N];
        // 以 m 结尾的字符串数量
        int[] g = new int[N];
        // 状态初始化
        f[0] = g[0] = 1;
        // 状态转移
        for (int i = 1; i < N; i++) {
            f[i] = g[i - 1];
            g[i] = g[i - 1] + f[i - 1];
        }
        return f[N - 1] + g[N - 1];
    }

    /**
     * 思路：动态规划+滚动数组
     * <p>
     * 由于只依赖于上一个状态，可采用滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"1", "2"},
            output = {"2", "3"})
    public int dynamic0(int N) {
        // 状态定义
        // 以 c 结尾的字符串数量
        int f = 1;
        // 以 m 结尾的字符串数量
        int g = 1;
        // 状态转移
        for (int i = 1; i < N; i++) {
            int last = g;
            g = g + f;
            f = last;
        }
        return f + g;
    }

}

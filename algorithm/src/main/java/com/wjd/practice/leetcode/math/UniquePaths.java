package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * @since 2022/6/1
 */
public class UniquePaths implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int m = 3;
        int n = 3;
        int result = uniquePaths(m, n);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：肯定要走的步数是下m-1和右n-1，因此只需要把下和右的步数组合一下，就是总数了
     *
     * 注意：溢出的问题，leetcode 的机器貌似溢出的截断好像有点不同
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了74.95% 的Java用户
     */
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        // 从(0, 0)开始走的
        int min = Math.min(m - 1, n - 1);
        int max = Math.max(m - 1, n - 1);
        int num = max + min;
        // 组合数量 n!/k!(n-k)!
        long ans = 1;
        for (int i = 1; i <= num - max; i++) {
            // 边乘边除，避免溢出
            ans = ans * (max + i) / i;
        }
        return (int) ans;
    }

}

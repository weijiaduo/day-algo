package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 剑指Offer 2 091 粉刷房子
 * <p>
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * <p>
 * 每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。 最少花费: 2 + 5 + 3 = 10。
 *
 * @author weijiaduo
 * @since 2022/6/25
 */
public class MinCost implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int result = minCost(costs);
        System.out.println(result);
        return result;
    }

    private int minCost(int[][] costs) {
        // int[] result = dfs(0, new int[3], costs);
        // return Math.min(Math.min(result[0], result[1]), result[2]);
        return dynamic(costs);
    }

    /**
     * 思路：递归法，递归计算到每个房子的最低成本，每个房子都有3种颜色，分别进行统计
     * <p>
     * 复杂度：时间 O(n)，空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了18.91% 的Java用户
     */
    private int[] dfs(int i, int[] total, int[][] costs) {
        if (i == costs.length) {
            return total;
        }

        int t0 = total[0], t1 = total[1], t2 = total[2];
        // 第i个房子刷0号颜色的最低成本
        total[0] = Math.min(t1, t2) + costs[i][0];
        // 第i个房子刷1号颜色的最低成本
        total[1] = Math.min(t0, t2) + costs[i][1];
        // 第i个房子刷2号颜色的最低成本
        total[2] = Math.min(t0, t1) + costs[i][2];

        // 递归下一个房子
        return dfs(i + 1, total, costs);
    }

    /**
     * 思路：动态规划，计算i号刷0、1、2号颜色的最小成本，再推导出i+1号房子的最小成本
     * <p>
     * 复杂度：时间 O(n)，空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了85.35% 的Java用户
     * 内存消耗:41.3 MB,击败了5.04% 的Java用户
     */
    private int dynamic(int[][] costs) {
        // 创建动态规划数组
        int n = costs.length;
        int[][] dp = new int[n + 1][3];

        // 初始化动态数组
        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        // 动态计算
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }

        // 返回结果
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }

}

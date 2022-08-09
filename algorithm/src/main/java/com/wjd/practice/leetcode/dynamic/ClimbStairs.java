package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.Solution;

import java.util.Map;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * @since 2022/6/3
 */
public class ClimbStairs implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 2;
        int result = climbStairs(n);
        System.out.println(result);
        return result;
    }

    public int climbStairs(int n) {
        // return memoryDfs(n, 0, new HashMap<>());
        return dynamic2(n);
    }

    /**
     * 递归法
     */
    private int dfs(int n, int k) {
        if(k > n) {
            return 0;
        }
        if (n == k) {
            return 1;
        }
        return dfs(n, k + 1) + dfs(n, k + 2);
    }

    /**
     * 记忆递归法
     */
    private int memoryDfs(int n, int k, Map<Integer, Integer> memory) {
        Integer val = memory.get(k);
        if (val != null) {
            return val;
        }

        if(k > n) {
            return 0;
        }
        if (n == k) {
            return 1;
        }
        int sum = dfs(n, k + 1) + dfs(n, k + 2);
        memory.put(k, sum);
        return sum;
    }

    /**
     * 一维数组动态规划
     */
    private int dynamic(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i > 1) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * 临时变量，动态规划
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.9 MB,击败了94.59% 的Java用户
     */
    private int dynamic2(int n) {
        int lastOne = 1;
        int lastTwo = 0;
        for (int i = 1; i <= n; i++) {
            int t = lastOne;
            lastOne += lastTwo;
            lastTwo = t;
        }
        return lastOne;
    }

}

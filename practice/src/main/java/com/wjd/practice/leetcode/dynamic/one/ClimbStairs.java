package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 *
 * @since 2022/6/3
 */
public class ClimbStairs {

    /**
     * 思路：递归法，第 n 个台阶，可以由 n-1 或者 n-2 跳到
     * <p>
     * 由此推出递归，dfs(n) = dfs(n-1) + dfs(n-2)
     * <p>
     * 复杂度：时间 O(2^n) 空间 O(n)
     * <p>
     * Time Limit Exceeded
     */
    @TestCase(input = {"2", "3"},
            output = {"2", "3"})
    private int dfs(int n) {
        return dfs(n, 0);
    }

    private int dfs(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (n == k) {
            return 1;
        }
        return dfs(n, k + 1) + dfs(n, k + 2);
    }

    /**
     * 思路：记忆化搜索，直接递归会由很多重复的计算
     * <p>
     * 可将已经算过的结果缓存起来，下次遇到直接返回
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了91.53% 的Java用户
     */
    @TestCase(input = {"2", "3"},
            output = {"2", "3"})
    private int memory(int n) {
        return memoryDfs(n, 0, new HashMap<>());
    }

    private int memoryDfs(int n, int k, Map<Integer, Integer> memory) {
        Integer val = memory.get(k);
        if (val != null) {
            return val;
        }

        if (k > n) {
            return 0;
        }
        if (n == k) {
            return 1;
        }
        int sum = memoryDfs(n, k + 1, memory) + memoryDfs(n, k + 2, memory);
        memory.put(k, sum);
        return sum;
    }

    /**
     * 思路：动态规划，dp[i] 表示跳到 i 的不同方法数量
     * <p>
     * 则有：dp[i] = dp[i - 1] + dp[i - 2]
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了86.66% 的Java用户
     */
    @TestCase(input = {"2", "3"},
            output = {"2", "3"})
    private int dynamic1(int n) {
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
     * 思路：滚动动态规划，优化空间，
     * <p>
     * 在普通的动态规划中，当前值只依赖于前2个值，
     * <p>
     * 所以优化空间后，可直接用2个临时变量保存
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.9 MB,击败了94.59% 的Java用户
     */
    @TestCase(input = {"2", "3"},
            output = {"2", "3"})
    private int dynamic0(int n) {
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

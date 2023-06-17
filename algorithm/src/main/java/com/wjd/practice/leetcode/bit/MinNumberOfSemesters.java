package com.wjd.practice.leetcode.bit;

import java.util.Arrays;

/**
 * 1494. 并行课程 II
 * <p>
 * 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中， relations[i] = [xi, yi] 表示一个先
 * 修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
 * <p>
 * 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
 * <p>
 * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
 * 输出：3
 * 解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
 * 输出：4
 * 解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 11, relations = [], k = 2
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 15
 * 1 <= k <= n
 * 0 <= relations.length <= n * (n-1) / 2
 * relations[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 所有先修关系都是不同的，也就是说 relations[i] != relations[j] 。
 * 题目输入的图是个有向无环图。
 *
 * @author weijiaduo
 * @since 2023/6/16
 */
public class MinNumberOfSemesters {

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // return dfs(n, relations, k);
        return dynamic(n, relations, k);
    }

    // 状态缓存
    int[] cache;
    // 前置课程
    int[] needs;

    /**
     * 思路：状态压缩+记忆化搜索
     * <p>
     * 所有课程数量小于 30，因此可压缩到一个整数中表示
     * <p>
     * 然后遍历所有的可选状态，并记录起来，避免重复计算
     * <p>
     * 当前可选课程的条件：
     * <p>
     * 1. 课程在未选课程中
     * 2. 课程的前置课程不在未选课程中
     * <p>
     * 同时满足这 2 个条件的课程，就是当前可选的课程。
     * <p>
     * 复杂度：时间 O(3^n) 空间 O(2^n)
     * <p>
     * 执行耗时:31 ms,击败了95.80% 的Java用户
     * 内存消耗:41.8 MB,击败了47.90% 的Java用户
     */
    private int dfs(int n, int[][] relations, int k) {
        cache = new int[1 << n];
        Arrays.fill(cache, -1);
        needs = new int[n];
        for (int[] r : relations) {
            needs[r[1] - 1] |= 1 << (r[0] - 1);
        }
        int u = (1 << n) - 1;
        return dfs(u, n, k);
    }

    /**
     * @param us 未选课程集合
     * @param n  课程数目
     * @param k  每学期可选数量
     * @return 最小学期数
     */
    private int dfs(int us, int n, int k) {
        if (us == 0) {
            return 0;
        }
        if (cache[us] != -1) {
            return cache[us];
        }

        // 当前的所有可选课程
        int avail = 0;
        for (int i = 0; i < n; i++) {
            // 在未选课程中，且前置课程都不在（即前置课程都已学了）
            boolean inUs = ((1 << i) & us) != 0;
            boolean noNeeds = ((needs[i] & us)) == 0;
            if (inUs && noNeeds) {
                avail |= (1 << i);
            }
        }

        int ans = Integer.MAX_VALUE;
        if (Integer.bitCount(avail) <= k) {
            // 可选课程小于 k，则选完所有可选课程
            ans = 1 + dfs(us ^ avail, n, k);
        } else {
            // 枚举可选课程子集合（尽量多选课程）
            for (int sub = avail; sub > 0; sub = (sub - 1) & avail) {
                if (Integer.bitCount(sub) == k) {
                    ans = Math.min(dfs(us ^ sub, n, k) + 1, ans);
                }
            }
        }
        return cache[us] = ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：将记忆化搜索的递归实现，改成迭代实现
     * <p>
     * 复杂度：时间 O(3^n) 空间 O(2^n)
     * <p>
     * 执行耗时:167 ms,击败了39.50% 的Java用户
     * 内存消耗:41.9 MB,击败了31.93% 的Java用户
     */
    private int dynamic(int n, int[][] relations, int k) {
        int[] needs = new int[n];
        for (int[] r : relations) {
            needs[r[1] - 1] |= 1 << (r[0] - 1);
        }

        int[] dp = new int[1 << n];
        dp[0] = 0;
        for (int us = 1; us < (1 << n); us++) {
            // 当前的所有可选课程
            int avail = 0;
            for (int i = 0; i < n; i++) {
                // 在未选课程中，且前置课程都不在（即前置课程都已学了）
                boolean inUs = ((1 << i) & us) != 0;
                boolean noNeeds = ((needs[i] & us)) == 0;
                if (inUs && noNeeds) {
                    avail |= (1 << i);
                }
            }

            // 可选课程小于 k，则选完所有可选课程
            if (Integer.bitCount(avail) <= k) {
                dp[us] = 1 + dp[us ^ avail];
                continue;
            }

            // 枚举可选课程子集合（尽量多选课程）
            dp[us] = Integer.MAX_VALUE;
            for (int sub = avail; sub > 0; sub = (sub - 1) & avail) {
                if (Integer.bitCount(sub) == k) {
                    dp[us] = Math.min(dp[us ^ sub] + 1, dp[us]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

}

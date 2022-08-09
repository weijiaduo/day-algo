package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.PriorityQueue;

/**
 * 871. 最低加油次数
 * <p>
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * <p>
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * <p>
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * <p>
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：我们可以在不加油的情况下到达目的地。
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class MinRefuelStops implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int result = greedyMinRefuelStops(target, startFuel, stations);
        System.out.println(result);
        return result;
    }

    int minStops;

    private int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            if (startFuel >= target) {
                return 0;
            } else {
                return -1;
            }
        }
        minStops = -1;
        dfs(target, startFuel - stations[0][0], stations, 0, 0);
        return minStops;
    }

    /**
     * 思路：回溯，遍历所有可能的情况，然后取最小的加油次数
     */
    private void dfs(int target, int fuel, int[][] stations, int i, int stops) {
        if (fuel < 0 || minStops > -1 && minStops <= stops) {
            return;
        }
        if (i == stations.length) {
            minStops = stops;
            return;
        }

        // 下一站的距离
        int distance;
        if (i == stations.length - 1) {
            distance = target - stations[i][0];
        } else {
            distance = stations[i + 1][0] - stations[i][0];
        }
        // 抵达下一站后剩余的油量
        fuel -= distance;

        // 不加油
        dfs(target, fuel, stations, i + 1, stops);
        // 加油
        dfs(target, fuel + stations[i][1], stations, i + 1, stops + 1);
    }

    /**
     * 官解：动态规划，dp[i][j] 表示对于 [0, i - 1] 范围内的加油站，最多加 j 次油能够到达的最远距离
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:5 ms,击败了50.45% 的Java用户
     * 内存消耗:41.4 MB,击败了64.06% 的Java用户
     */
    private int dynamicMinRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 思路：贪心，每次优先加大油量，减少加油次数
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了64.29% 的Java用户
     * 内存消耗:41.8 MB,击败了21.65% 的Java用户
     */
    private int greedyMinRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length;
        int fuel = startFuel, position = 0;
        for (int i = 0; i <= n; i++) {
            // 抵达下一站后的剩余油量
            if (i == n) {
                fuel -= target - position;
            } else {
                fuel -= stations[i][0] - position;
            }
            // 无法抵达下一站，优先加大油量
            while (fuel < 0 && !queue.isEmpty()) {
                fuel += queue.poll();
            }
            // 加完油都抵达不了
            if (fuel < 0) {
                return -1;
            }
            if (i < n) {
                position = stations[i][0];
                queue.offer(stations[i][1]);
            }
        }
        return n - queue.size();
    }

}

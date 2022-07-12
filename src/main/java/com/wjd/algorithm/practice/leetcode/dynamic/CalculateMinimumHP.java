package com.wjd.algorithm.practice.leetcode.dynamic;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * <p>
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。
 * <p>
 * 地下城是由 M x N 个房间组成的二维网格。
 * <p>
 * 我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 * <p>
 * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * @author weijiaduo
 * @since 2022/7/12
 */
public class CalculateMinimumHP implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int result = calculateMinimumHP3(dungeon);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：动态规划，从后往前动态计算，算出从 [i][j] 出发所需的最小生命值
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:4 ms,击败了6.65% 的Java用户
     * 内存消耗:41.3 MB,击败了7.77% 的Java用户
     */
    private int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }

        int m = dungeon.length, n = dungeon[0].length;

        // 表示从 [i][j] 出发所需的最小生命值
        int[][] dp = new int[m + 1][n + 1];

        // -1 表示此路不通
        for (int i = 0; i <= m; i++) {
            dp[i][n] = -1;
        }
        for (int j = 0; j <= n; j++) {
            dp[m][j] = -1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dungeon[i][j] < 0 ? 1 - dungeon[i][j] : 1;
                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                int max = Math.max(dp[i][j + 1], dp[i + 1][j]);
                // 优先走低消耗的路
                if (min > 0) {
                    dp[i][j] = Math.max(min - dungeon[i][j], dp[i][j]);
                } else if (max > 0) {
                    dp[i][j] = Math.max(max - dungeon[i][j], dp[i][j]);
                }
            }
        }

        return dp[0][0];
    }

    /**
     * 思路：压缩动态规划的二维数组
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了6.65% 的Java用户
     * 内存消耗:41.3 MB,击败了5.68% 的Java用户
     */
    private int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }

        int m = dungeon.length, n = dungeon[0].length;

        // 表示从 [i][j] 出发所需的最小生命值
        int[] dp = new int[n + 1];

        // -1 表示此路不通
        Arrays.fill(dp, -1);

        // 动态计算状态
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[j], dp[j + 1]);
                int max = Math.max(dp[j], dp[j + 1]);
                // 进入该房间的最低生命值
                dp[j] = dungeon[i][j] < 0 ? 1 - dungeon[i][j] : 1;
                // 优先走低消耗的路
                if (min > 0) {
                    dp[j] = Math.max(min - dungeon[i][j], dp[j]);
                } else if (max > 0) {
                    dp[j] = Math.max(max - dungeon[i][j], dp[j]);
                }
            }
        }

        return dp[0];
    }

    /**
     * 这个初始化状态，我想了半天，没想到啥好的方案
     * <p>
     * 官解：思路一样，不过初始化值不同，这速度明显提升了啊
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:2 ms,击败了61.52% 的Java用户
     * 内存消耗:40.7 MB,击败了83.11% 的Java用户
     */
    private int calculateMinimumHP3(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }

        int m = dungeon.length, n = dungeon[0].length;

        // 表示从 [i][j] 出发所需的最小生命值
        int[][] dp = new int[m + 1][n + 1];

        // 初始化状态
        for (int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            dp[m][j] = Integer.MAX_VALUE;
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;

        // 动态计算状态
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 进入该房间的最低生命值
                dp[i][j] = dungeon[i][j] < 0 ? 1 - dungeon[i][j] : 1;
                // 优先走低消耗的路
                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = Math.max(min - dungeon[i][j], dp[i][j]);
            }
        }

        return dp[0][0];
    }

}

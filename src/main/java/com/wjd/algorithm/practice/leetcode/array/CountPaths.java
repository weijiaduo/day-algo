package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 周赛300
 * <p>
 * 6110. 网格图中递增路径的数目
 * <p>
 * 给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。
 * <p>
 * 请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。
 * <p>
 * 由于答案可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * 如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。
 * <p>
 * 输入：grid = [[1,1],[3,4]]
 * 输出：8
 * 解释：严格递增路径包括：
 * - 长度为 1 的路径：[1]，[1]，[3]，[4] 。
 * - 长度为 2 的路径：[1 -> 3]，[1 -> 4]，[3 -> 4] 。
 * - 长度为 3 的路径：[1 -> 3 -> 4] 。
 * 路径数目为 4 + 3 + 1 = 8 。
 *
 * @author weijiaduo
 * @since 2022/7/3
 */
public class CountPaths implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] grid = {{1}, {3}};
        int result = countPath(grid);
        System.out.println(result);
        return result;
    }

    static final int MOD = (int) 1e9 + 7;
    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int[][] grid, cache;

    /**
     * 大家真是太厉害了，我都没想清楚，题解都出来了
     */
    private int countPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;

        // dp[i,j]表示以[i,j]为起点的路径
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(i, j)) % MOD;
            }
        }
        return ans;
    }

    /**
     * 思路：递归从[i,j]出发的路径数量
     */
    private int dfs(int i, int j) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int sum = 1;
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                if (grid[x][y] > grid[i][j]) {
                    sum = (sum + dfs(x, y)) % MOD;
                }
            }
        }
        return cache[i][j] = sum;
    }

}

package com.wjd.practice.leetcode.matrix;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 994. 腐烂的橘子
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * <p>
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * @author weijiaduo
 * @since 2023/6/17
 */
public class OrangesRotting {

    /**
     * 思路：直接模拟，每分钟将腐烂橘子附近的新鲜橘子变成腐烂
     * <p>
     * 复杂度：时间 O(nm) 空间 O(nm)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了89.92% 的Java用户
     */
    public int orangesRotting(int[][] grid) {
        // 统计新鲜和腐烂的数量
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Deque<int[]> rotted = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotted.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 广度优先遍历，每轮往外扩散一圈
        int cnt = 0;
        final int[][] offset = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!rotted.isEmpty() && fresh > 0) {
            // 多个地方可以同时扩散
            int size = rotted.size();
            for (int k = 0; k < size; k++) {
                int[] rot = rotted.poll();
                int i = rot[0], j = rot[1];
                for (int[] f : offset) {
                    if (0 <= i + f[0] && i + f[0] < m
                            && 0 <= j + f[1] && j + f[1] < n
                            && grid[i + f[0]][j + f[1]] == 1) {
                        grid[i + f[0]][j + f[1]] = 2;
                        rotted.offer(new int[]{i + f[0], j + f[1]});
                        fresh--;
                    }
                }
            }
            cnt++;
        }
        return fresh == 0 ? cnt : -1;
    }

}
